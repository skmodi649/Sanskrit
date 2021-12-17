package com.example.sanskrit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class front extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
    }

    public void gogo(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}