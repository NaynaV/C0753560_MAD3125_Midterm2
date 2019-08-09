package com.example.c0753560_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgView = findViewById(R.id.imgView);


        FlightData mFlightData = new FlightData(MainActivity.this);
        mFlightData.processJSON();
        Log.d("Size of List : ",String.valueOf(mFlightData.mFlightList.size()));

        String photoUrl = mFlightData.mFlightList.get(1).getLinks().getMissionPatchSmall();
        Log.d("string photo url  : ",photoUrl);
        Glide.with(imgView)  //2
                .load(photoUrl) //3
                .centerCrop() //4
                //.placeholder(R.drawable.img_placeholder) //5
                //.error(R.drawable.img_notload) //6
                //.fallback(R.drawable.img_placeholder) //7
                .into(imgView);

    }
    }

