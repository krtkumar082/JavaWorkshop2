package com.workshop2;

import java.util.List;
public class Hotel {
    private String hotelName;
    private int rateOfHotelRegularCustWeekDay;
    private int rateOfHotelRegularCustWeekNday;
    private int rateOfHotelRewardCustWeekDay;
    private int rateOfHotelRewardCustWeekNday;
    private int rating;
    
    public Hotel() {
    	
    }
    public Hotel(String name,int rateOfHotelRegularCustWeekDay,int rateOfHotelRegularCustWeekNday,
    		     int rateOfHotelRewardCustWeekDay,int rateOfHotelRewardCustWeekNday,int rating) {
        this.hotelName=name;
        this.rateOfHotelRegularCustWeekDay=rateOfHotelRegularCustWeekDay;
        this.rateOfHotelRegularCustWeekNday=rateOfHotelRegularCustWeekNday;
        this.rateOfHotelRewardCustWeekDay=rateOfHotelRewardCustWeekDay;
        this.rateOfHotelRewardCustWeekNday=rateOfHotelRewardCustWeekNday;
        this.rating=rating;
    }
     
    public String getHotelName() {
    	return this.hotelName;
    }
    
    public int getRateOfHotelRegularCustWeekDay() {
    	return this.rateOfHotelRegularCustWeekDay;
    }
    
    public int getRateOfHotelRegularCustWeekNday() {
    	return this.rateOfHotelRegularCustWeekNday;
    }
    
    public int getRateOfHotelRewardCustWeekDay() {
    	return this.rateOfHotelRewardCustWeekDay;
    }
    
    public int getRateOfHotelRewardCustWeekNday() {
    	return this.rateOfHotelRewardCustWeekNday;
    }
    
    public int getRating() {
    	return this.rating;
    }
     
    public void setHotelName(String name) {
    	this.hotelName=name;
    }
    
    public void setRateOfHotelRegularCustWeekDay(int rate) {
    	this.rateOfHotelRegularCustWeekDay=rate;
    }
     
    public void setRateOfHotelRegularCustWeekNday(int rate) {
    	this.rateOfHotelRegularCustWeekNday=rate;
    }
     
    public void setRateOfHotelRewardCustWeekDay(int rate) {
    	this.rateOfHotelRewardCustWeekDay=rate;
    }
    
    public void setRateOfHotelRewardCustWeekNday(int rate) {
    	this.rateOfHotelRewardCustWeekNday=rate;
    }
   
}
