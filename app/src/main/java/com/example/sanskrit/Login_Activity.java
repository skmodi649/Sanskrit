package com.example.sanskrit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {
    Button login;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        login.setOnClickListener(view -> startActivity(new Intent(Login_Activity.this , front.class)));
        signup.setOnClickListener(view -> startActivity(new Intent(Login_Activity.this , Register_Activity.class)));
    }
}