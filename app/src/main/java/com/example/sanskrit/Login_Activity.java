package com.example.sanskrit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    Button login;
    TextView signup;
    EditText email , password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        String emaila = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        login.setOnClickListener(view -> {
            if(emaila.equalsIgnoreCase(pass))
                startActivity(new Intent(Login_Activity.this , front.class));
            else
                Toast.makeText(Login_Activity.this , "Invalid Credentials!" , Toast.LENGTH_LONG).show();
        });
        signup.setOnClickListener(view -> startActivity(new Intent(Login_Activity.this , Register_Activity.class)));
    }
    @Override
    public void onStart(){
        super.onStart();
        // Checking if the user is signed in (non-null) and update the UI accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
}