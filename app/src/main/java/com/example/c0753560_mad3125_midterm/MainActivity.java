package com.example.c0753560_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FlightAdaptor mAdapter;

    FlightData mFlidatData;

    private List<FlightMain> flightRowList = new ArrayList<>();

    public static ArrayList<FlightMain> FlightList;

ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // imgView = findViewById(R.id.imgView);


        FlightData mFlightData = new FlightData(MainActivity.this);
        mFlightData.processJSON();
        Log.d("Size of List : ",String.valueOf(mFlightData.mFlightList.size()));

        String photoUrl = mFlightData.mFlightList.get(1).getLinks().getMissionPatchSmall();
        Log.d("string photo url  : ",photoUrl);
        Glide.with(imgView)  //2
                .load(photoUrl) //3
                .centerCrop() //4
                .placeholder(R.drawable.img_placeholder) //5
                .error(R.drawable.img_notload) //6
                .fallback(R.drawable.img_placeholder) //7
                .into(imgView);


//testCode
        mFlightData = new FlightData(MainActivity.this);
        mFlightData.processJSON();
        MainActivity.FlightList = mFlightData.mFlightList;
        Log.d("Size of SS space List :",String.valueOf(MainActivity.FlightList.size()));
        Log.d("Size of mSpaceList:",String.valueOf(mFlightData.mFlightList.size()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.flightImage);
        recyclerView = findViewById(R.id.flightListRecyclerView);


        mAdapter = new FlightAdaptor(this,flightRowList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareFlightListData();


    }

    private void prepareFlightListData()
    {
        for (FlightMain flight : mFlidatData.mFlightList)

        {
            FlightMain flightRow = new FlightMain();

            flightRowList.add(flightRow);
        }
        mAdapter.notifyDataSetChanged();
    }


    }

