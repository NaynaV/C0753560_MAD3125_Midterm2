package com.example.c0753560_mad3125_midterm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;
import com.example.c0753560_mad3125_midterm.JavaClasses.homeListView;

import java.util.List;

public class FlightAdaptor extends RecyclerView.Adapter<FlightAdaptor.flightViewHolder>
{

    public List<homeListView> flightList;
    ImageView flightImage;
    TextView flightName,flightYear;

    private static final String TAG = "FlightAdaptor";

    AppCompatActivity activity;

    public FlightAdaptor(AppCompatActivity activity_main, List<homeListView> flightList)
    {
        this.flightList = flightList;
        this.activity = activity_main;
        Log.e(TAG, "FlightAdaptor: "+flightList.size() );

    }

    @NonNull
    @Override
    public flightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.flightlist, viewGroup, false);

        return new flightViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull flightViewHolder holder, int i)
    {
        homeListView mFlightMain = flightList.get(i);
        String photoUrl = MainActivity.FlightList.get(i).getLinks().getMissionPatchSmall();
        Glide.with(holder.flightImage)  //2
                .load(photoUrl) //3
                .centerCrop() //4
                .placeholder(R.drawable.img_placeholder) //5
                .error(R.drawable.img_notload) //6
                .fallback(R.drawable.img_placeholder) //7
                .into(holder.flightImage);

        holder.flightName.setText(mFlightMain.getFlightName());
        Log.d("Misssion name:",String.valueOf(mFlightMain.getFlightName()));

        holder.flightYear.setText(mFlightMain.getFlightYear());

    }

    @Override
    public int getItemCount() {
        return flightList.size();
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
