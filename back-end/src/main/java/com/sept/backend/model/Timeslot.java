package com.sept.backend.model;

public class Timeslot {
    private long[] data;
    // index of startTime
    private int s = 0;
    // index of endTime
    private int e = 1;

    public Timeslot(long startTime, long endTime) {
        this.data[s] = startTime;
        this.data[e] = endTime;
    }

    public long getStartTime() {
        return data[s];
    }

    public long getEndTime() {
        return data[e];
    }
}
