package com.workshop2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class HotelFuncs {
	public static List<Hotel> hotelList=new ArrayList<>();
	public void addHotel(String hotelName,int rateOfHotelRegularCust,int rateOfHotelRegularCustWeekNday) {
		Hotel hotel=new Hotel(hotelName,rateOfHotelRegularCust,rateOfHotelRegularCustWeekNday);
		hotelList.add(hotel);
	}
	 
	public List<Hotel> getHotelList(){
		return hotelList;
	}
	
	
}
