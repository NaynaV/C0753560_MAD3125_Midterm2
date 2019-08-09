package com.example.c0753560_mad3125_midterm.JavaClasses;

public class FlightMain
{
    private String filghtNumber;
    private String missionName;
    private String upcoming;
    private String launchYear;
    private String launchWindow;
    private String details;
    Rocket rocket;
    LaunchSite launchSite;
    Links links;

    public FlightMain()
    {
        this.filghtNumber = filghtNumber;
        this.missionName = this.missionName;
        this.upcoming = upcoming;
        this.launchYear = this.launchYear;
        this.launchWindow = launchWindow;
        this.details = details;
        this.rocket = rocket;
        this.launchSite = launchSite;
        this.links = links;
    }

    public String getFilghtNumber() {
        return filghtNumber;
    }

    public void setFilghtNumber(String filghtNumber) {
        this.filghtNumber = filghtNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(String upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(String launchWindow) {
        this.launchWindow = launchWindow;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "FlightMain{" +
                "filghtNumber='" + filghtNumber + '\'' +
                ", missionName='" + missionName + '\'' +
                ", upcoming='" + upcoming + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", launchWindow='" + launchWindow + '\'' +
                ", details='" + details + '\'' +
                ", rocket=" + rocket +
                ", launchSite=" + launchSite +
                ", links=" + links +
                '}';
    }
}
