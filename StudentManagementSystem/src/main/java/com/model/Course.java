package com.model;

public class Course {
    private String name;
    private int duration;
    private double fee;

    public Course() {
        this.name = "Java";
        this.duration = 30;
        this.fee = 1000.0;
    }

    public Course(String name, int duration, double fee) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return this.fee;
    }

    public String toString() {
        return this.name + " (" + this.duration + " days, $" + this.fee + ")";
    }
    
}
