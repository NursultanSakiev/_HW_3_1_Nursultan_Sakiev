package com.example.saka;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText theme;
    private EditText sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        sms = findViewById(R.id.sms);
        Button send = findViewById(R.id.send);
        send.setOnClickListener(view -> sendMail());
    }
    private void sendMail() {

        String recipientList = email.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = theme.getText().toString();
        String message = sms.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "choose on email client"));
    }
}