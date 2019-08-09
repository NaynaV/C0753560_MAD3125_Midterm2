package com.example.c0753560_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Recycler
    iew recyclerView;
    private FlightAdapter mAdapter;

    DataStore mDataStore;
    private List<FlightRow> flightRowList = new ArrayList<>();
    public static ArrayList<SpaceXFlight> staticSpaceXFlightList;

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
        mDataStore = new FlightData(MainActivity.this);
        mDataStore.p();
        MainActivity.staticSpaceXFlightList = mDataStore.mSpaceXFlightList;
        Log.d("Size of SS space List :",String.valueOf(MainActivity.staticSpaceXFlightList.size()));
        Log.d("Size of mSpaceList:",String.valueOf(mDataStore.mSpaceXFlightList.size()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recycleView);


        mAdapter = new FlightAdapter(this,flightRowList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareFlightListData();


    }

    private void prepareFlightListData()
    {
        for(SpaceXFlight flight : mDataStore.mSpaceXFlightList)
        {
            FlightRow flightRow = new FlightRow(flight.getLinks().getMission_patch_small(),flight.getMission_name(),flight.getLaunch_year());
            flightRowList.add(flightRow);
        }
        mAdapter.notifyDataSetChanged();
    }
    }

