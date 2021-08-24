package com.example.sanskrit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class front extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.appbgm);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    public void gogo(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void fur(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.appbgm);
        mediaPlayer.start();
    }
       public void fura(View view){
           MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.appbgm);
           mediaPlayer.stop();
       }
}