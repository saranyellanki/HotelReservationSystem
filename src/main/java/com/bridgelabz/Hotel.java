package com.bridgelabz;

public class Hotel implements Comparable{
    private String hotelName;
    private int weekdayRegularRate;
    private int weekendRegularRate;
    private int weekdayRewardRate;
    private int weekendRewardRate;
    private int rating;

    public Hotel(String hotelName, int weekdayRegularRate, int weekendRegularRate, int weekdayRewardRate, int weekendRewardRate, int rating) {
        this.hotelName = hotelName;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekendRegularRate = weekendRegularRate;
        this.weekdayRewardRate = weekdayRewardRate;
        this.weekendRewardRate = weekendRewardRate;
        this.rating = rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRewardRate() {
        return weekdayRewardRate;
    }

    public void setWeekdayRewardRate(int weekdayRewardRate) {
        this.weekdayRewardRate = weekdayRewardRate;
    }

    public int getWeekendRewardRate() {
        return weekendRewardRate;
    }

    public void setWeekendRewardRate(int weekendRewardRate) {
        this.weekendRewardRate = weekendRewardRate;
    }

    public int getWeekdayRegularRate() {
        return weekdayRegularRate;
    }

    public void setWeekdayRegularRate(int weekdayRegularRate) {
        this.weekdayRegularRate = weekdayRegularRate;
    }

    public int getWeekendRegularRate() {
        return weekendRegularRate;
    }

    public void setWeekendRegularRate(int weekendRegularRate) {
        this.weekendRegularRate = weekendRegularRate;
    }

    @Override
    public int compareTo(Object hotelRating) {
        return ((Hotel)hotelRating).rating-this.rating;
    }
}