package com.example.c0753560_mad3125_midterm.JavaClasses;

public class LaunchSite {
    private String siteID;
    private String siteName;
    private String siteNameLong;

    public LaunchSite(String siteID, String siteName, String siteNameLong) {
        this.siteID = siteID;
        this.siteName = siteName;
        this.siteNameLong = siteNameLong;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

    @Override
    public String toString() {
        return "LaunchSite{" +
                "siteID='" + siteID + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteNameLong='" + siteNameLong + '\'' +
                '}';
    }
}
