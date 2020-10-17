package com.workshop2;

import java.util.List;
public class Hotel {
    private String hotelName;
    private int rateOfHotelRegularCust;
    
    public Hotel() {
    	
    }
    public Hotel(String name,int rateOfHotelRegularCust) {
        this.hotelName=name;
        this.rateOfHotelRegularCust=rateOfHotelRegularCust;
    }
     
    public String getHotelName() {
    	return this.hotelName;
    }
    
    public int getRateRegCust() {
    	return this.rateOfHotelRegularCust;
    }
     
    public void setHotelName(String name) {
    	this.hotelName=name;
    }
    
    public void setRateRegCust(int rate) {
    	this.rateOfHotelRegularCust=rate;
    }
     
    public String toStrign() {
    	return "name= "+hotelName+" rateofRegularcust= "+rateOfHotelRegularCust;
    }
}
