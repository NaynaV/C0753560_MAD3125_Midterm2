package com.example.c0753560_mad3125_midterm.JavaClasses;

public class homeListView
{
    String flightimage;
    String flightName;
    String flightYear;

    public homeListView(String flightimage, String flightName, String flightYear) {
        this.flightimage = flightimage;
        this.flightName = flightName;
        this.flightYear = flightYear;
    }

    public String getFlightimage() {
        return flightimage;
    }

    public void setFlightimage(String flightimage) {
        this.flightimage = flightimage;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightYear() {
        return flightYear;
    }

    public void setFlightYear(String flightYear) {
        this.flightYear = flightYear;
    }

    @Override
    public String toString() {
        return "homeListView{" +
                "flightimage='" + flightimage + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightYear='" + flightYear + '\'' +
                '}';
    }
}
