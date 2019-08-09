package com.example.c0753560_mad3125_midterm.JavaClasses;

public class Rocket
{



    private String rocketId;
    private String rocketName;
    private String rocketType;

    public Rocket() {
    }

    public Rocket(String rocketId, String rocketName, String rocketType) {
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocketId='" + rocketId + '\'' +
                ", rocketName='" + rocketName + '\'' +
                ", rocketType='" + rocketType + '\'' +
                '}';
    }
}
