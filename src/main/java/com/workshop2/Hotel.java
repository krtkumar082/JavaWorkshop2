package com.workshop2;

import java.util.List;
public class Hotel {
    private String hotelName;
    private int rateOfHotelRegularCustWeekDay;
    private int rateOfHotelRegularCustWeekNday;
    private int rating;
    
    public Hotel() {
    	
    }
    public Hotel(String name,int rateOfHotelRegularCustWeekDay,int rateOfHotelRegularCustWeekNday,int rating) {
        this.hotelName=name;
        this.rateOfHotelRegularCustWeekDay=rateOfHotelRegularCustWeekDay;
        this.rateOfHotelRegularCustWeekNday=rateOfHotelRegularCustWeekNday;
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
     
    
   
}
