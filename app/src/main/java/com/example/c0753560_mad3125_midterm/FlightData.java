package com.example.c0753560_mad3125_midterm;

import android.content.Context;


import com.bumptech.glide.Glide;
import com.example.c0753560_mad3125_midterm.JavaClasses.FlightMain;
import com.example.c0753560_mad3125_midterm.JavaClasses.LaunchSite;
import com.example.c0753560_mad3125_midterm.JavaClasses.Links;
import com.example.c0753560_mad3125_midterm.JavaClasses.Rocket;

import org.json.JSONArray;
import org.json.JSONException;


import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


import java.io.IOException;

import java.nio.charset.StandardCharsets;

public class FlightData
{
    Context context;
    public ArrayList<FlightMain> mFlightList ;


    public ArrayList<FlightMain> getmSpaceXFlightList() {
        return mFlightList;
    }

    public FlightData(Context context)
    {
        this.context = context;
    }




    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open("Flight.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            //Log.d("-- COUNT --", String.format("%d Bytes",count));
            json = new String(buffer, "UTF8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null)
        {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                mFlightList = new ArrayList<FlightMain>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    FlightMain mFlight = getFlightObjectFromJSON(mJSONArray.getJSONObject(i));
                    mFlightList.add(mFlight);
                    //Log.d("-- JSON -- ", mSpaceXFlight.toString());

                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public FlightMain getFlightObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        String flight_number = userJsonObject.getString("flight_number");
        String mission_name = userJsonObject.getString("mission_name");
        String upcoming = userJsonObject.getString("upcoming");
        String launch_year = userJsonObject.getString("launch_year");
        String launch_window = userJsonObject.getString("launch_window");
        String details = userJsonObject.getString("details");

        //Read Rocket
        JSONObject rocket = new JSONObject(userJsonObject.getJSONObject("rocket").toString());
        String rocket_id = rocket.getString("rocket_id");
        String rocket_name = rocket.getString("rocket_name");
        String rocket_type = rocket.getString("rocket_type");

        //Read Launch Site
        JSONObject launchSite = new JSONObject(userJsonObject.getJSONObject("launch_site").toString());
        String site_id = launchSite.getString("site_id");
        String site_name = launchSite.getString("site_name");
        String site_name_long = launchSite.getString("site_name_long");

        //Read Links
        JSONObject links = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String mission_patch = links.getString("mission_patch");
        String mission_patch_small = links.getString("mission_patch_small");
        String article_link = links.getString("article_link");
        String wikipedia = links.getString("wikipedia");
        String video_link = links.getString("video_link");

        //start creating User object
        FlightMain mFlightMain = new FlightMain();
        mFlightMain.setFilghtNumber(flight_number);
        mFlightMain.setMissionName(mission_name);
        mFlightMain.setUpcoming(upcoming);
        mFlightMain.setLaunchYear(launch_year);
        mFlightMain.setLaunchWindow(launch_window);
        mFlightMain.setDetails(details);

        Rocket mRocket = new Rocket();
        mRocket.setRocketId(rocket_id);
        mRocket.setRocketName(rocket_name);
        mRocket.setRocketType(rocket_type);
        mFlightMain.setRocket(mRocket);

        LaunchSite mLaunchSite = new LaunchSite();
        mLaunchSite.setSiteID(site_id);
        mLaunchSite.setSiteName(site_name);
        mLaunchSite.setSiteNameLong(site_name_long);
        mFlightMain.setLaunchSite(mLaunchSite);

        Links mLinks = new Links();

        mLinks.setMissionPatchSmall(mission_patch_small);
        mLinks.setArticleLink(article_link);
        mLinks.setWikipedia(wikipedia);
        mLinks.setVideoLink(video_link);
        mFlightMain.setLinks(mLinks);

        return mFlightMain;
    }


}
