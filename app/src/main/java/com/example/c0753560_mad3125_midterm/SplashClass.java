package com.example.c0753560_mad3125_midterm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;

public class SplashClass extends AppCompatActivity
{

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalshactivity);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashClass.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch
                (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        myThread.start();

    }
}
