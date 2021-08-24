package com.example.sanskrit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sanskrit.R.layout.activity_main);
        //Now find the view that shows tha number category
        Button ob = (Button) findViewById(com.example.sanskrit.R.id.numbers);
        //Now setting a clickListener on that particular view
        ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(i);
            }
        });
        Button ob1 = (Button) findViewById(com.example.sanskrit.R.id.colors);
        ob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ColourActivity.class);
                startActivity(i);
            }
        });
        Button ob2 = (Button) findViewById(com.example.sanskrit.R.id.phrases);
        ob2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(i2);
            }
        });
        Button ob3 = (Button) findViewById(com.example.sanskrit.R.id.family);
        ob3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(i2);
            }
        });
    }
}