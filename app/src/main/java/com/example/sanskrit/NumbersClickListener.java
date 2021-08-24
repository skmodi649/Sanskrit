package com.example.sanskrit;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class NumbersClickListener extends Activity {
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
    }
};
