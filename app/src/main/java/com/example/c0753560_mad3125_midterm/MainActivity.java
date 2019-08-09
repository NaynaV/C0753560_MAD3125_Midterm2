package com.example.c0753560_mad3125_midterm;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;
import com.example.c0753560_mad3125_midterm.JavaClasses.homeListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FlightAdaptor mAdapter;

    FlightData mFlidatData;

    private List<homeListView> flightRowList = new ArrayList<homeListView>();

    public static ArrayList<FlightMain> FlightList;

ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



//testCode
        mFlidatData = new FlightData(MainActivity.this);
        mFlidatData.processJSON();
        MainActivity.FlightList = mFlidatData.mFlightList;
        Log.d("Size of SS space List :",String.valueOf(MainActivity.FlightList.size()));
        Log.d("Size of mSpaceList:",String.valueOf(mFlidatData.mFlightList.size()));

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
            homeListView flightRow = new homeListView();

            flightRowList.add(flightRow);
        }
        mAdapter.notifyDataSetChanged();
    }


    }

