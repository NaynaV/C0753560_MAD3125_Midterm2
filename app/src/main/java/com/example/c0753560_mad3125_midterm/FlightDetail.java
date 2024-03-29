package com.example.c0753560_mad3125_midterm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlightDetail extends AppCompatActivity
{
FlightMain flightDetail;


    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtYear)
    TextView txtYear;
    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.txtDetails)
    TextView txtDetails;

    @BindView(R.id.txtRocketType)
    TextView txtRocketType;

    @BindView(R.id.txtRocketName)
    TextView txtRocketName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightdetail);

        ButterKnife.bind(this);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int position = getIntent().getIntExtra("position", 0);
        flightDetail = MainActivity.FlightList.get(position);
        txtName.setText(flightDetail.getMissionName());
        txtYear.setText(flightDetail.getLaunchYear());
        String photoUrl = flightDetail.getLinks().getMissionPatchSmall();
        Log.d("patch Link ------->>>", flightDetail.getLinks().getMissionPatchSmall());
        Glide.with(imageView)  //2
                .load(photoUrl) //3
                .centerCrop() //4
                .placeholder(R.drawable.img_placeholder) //5
                .error(R.drawable.img_notload) //6
                .fallback(R.drawable.img_placeholder) //7
                .into(imageView);
        txtDetails.setText(flightDetail.getDetails());
      /*  String upcoming = "";
        if (flightDetail.getUpcoming().equals("false")) {
            upcoming = "No";
            txtUpcoming.setTextColor(Color.RED);

        } else if(flight.getUpcoming().equals("true")) {
            upcoming = "Yes";
            txtUpcoming.setTextColor(Color.BLUE);
        }
        else
        {
            upcoming = "No";
            txtUpcoming.setTextColor(Color.RED);
        }
        txtUpcoming.setText(upcoming);
        txtRocketId.setText(flight.getRocket().getRocket_id());*/
        txtRocketName.setText(flightDetail.getRocket().getRocketName());
        txtRocketType.setText(flightDetail.getRocket().getRocketType());
        //txtSiteId.setText(flight.getLaunchSite().getSite_id());
        String success = "";
        if (flightDetail.getFlight_success().equals("false")) {
            success = "No";
            txtFlightSuccess.setTextColor(Color.RED);

        } else if(flight.getFlight_success().equals("true")) {
            success = "Yes";
            txtFlightSuccess.setTextColor(Color.BLUE);
        }
        else
        {
            success = "No";
            txtFlightSuccess.setTextColor(Color.RED);
        }

        txtFlightSuccess.setText(success);
        txtSiteName.setText(flight.getLaunchSite().getSite_name());

        imgArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightDetailsActivity.this,ArticleActivity.class);
                intent.putExtra("link", flight.getLinks().getArticle_link());
                startActivity(intent);
                finish();
            }
        });

        imgWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightDetailsActivity.this,ArticleActivity.class);
                intent.putExtra("link", flight.getLinks().getWikipedia());
                startActivity(intent);
                finish();
            }
        });
        imgYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightDetailsActivity.this,ArticleActivity.class);
                intent.putExtra("link", flight.getLinks().getVideo_link());
                startActivity(intent);
                finish();
            }
        });
    }
}
