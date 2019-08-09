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

import java.util.List;

public class FlightAdaptor extends RecyclerView.Adapter<FlightAdaptor.flightViewHolder>
{

    public List<FlightMain> flightList;
    ImageView flightImage;
    TextView flightName,flightYear;

    private static final String TAG = "FlightAdapter";

    AppCompatActivity activity;

    public FlightAdaptor(AppCompatActivity activity_main, List<FlightMain> flightList)
    {
        this.flightList = flightList;
        this.activity = activity_main;
        Log.e(TAG, "FlightAdapter: "+flightList.size() );

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
        FlightMain mFlightMain = flightList.get(i);
        String photoUrl = MainActivity.FlightList.get(i).getLinks().getMissionPatchSmall();
        Glide.with(holder.flightImage)  //2
                .load(photoUrl) //3
                .centerCrop() //4
                .placeholder(R.drawable.img_placeholder) //5
                .error(R.drawable.img_notload) //6
                .fallback(R.drawable.img_placeholder) //7
                .into(holder.flightImage);
        //myViewHolder.flightImage.setImageResource(mFlightRow.getImageId());
        //icon.setImageResource(context.getResources().getIdentifier(animal.getAnimalName().toLowerCase(),"drawable",context.getPackageName()));
        holder.flightName.setText(mFlightMain.getMissionName());
        holder.flightYear.setText(mFlightMain.getLaunchYear());

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
