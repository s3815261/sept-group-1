package com.sept.backend.model;

import java.io.Serializable;

public class Availability implements Serializable {
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    public Availability(String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public String getFriday() {
        return friday;
    }

    public String toString() {
        return String.format("Monday={%s}, Tuesday={%s}, Wednesday={%s}, Thursday={%s}, Friday={%s}", monday, tuesday, wednesday, thursday, friday);
    }
}
