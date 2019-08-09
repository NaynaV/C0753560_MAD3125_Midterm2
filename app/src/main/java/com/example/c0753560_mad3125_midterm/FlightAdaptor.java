package com.example.c0753560_mad3125_midterm;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;

import java.util.List;

public class FlightAdaptor extends RecyclerView.Adapter<FlightAdaptor.flightViewHolder>
{

    public List<FlightMain> flightRowsList;
    ImageView flightImage;
    TextView flightName,flightYear;

    private static final String TAG = "FlightAdapter";

    AppCompatActivity activity;

    public FlightAdaptor(AppCompatActivity activity_main, List<FlightMain> flightRowsList)
    {
        this.flightRowsList = flightRowsList;
        this.activity = activity_main;
        Log.e(TAG, "FlightAdapter: "+flightRowsList.size() );

    }

    @NonNull
    @Override
    public flightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull flightViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class flightViewHolder extends RecyclerView.ViewHolder
    {
        ImageView flightImage;
        TextView flightName,flightYear;

        public flightViewHolder(View view)
        {
            super(view);
            flightImage =  view.findViewById(R.id.flightImage);
            flightName =  view.findViewById(R.id.text_view_flightName);
            flightYear =  view.findViewById(R.id.text_view_launchYear);
        }
    }
}
