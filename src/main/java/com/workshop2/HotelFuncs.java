package com.workshop2;

import java.util.ArrayList;
import java.util.List;

public class HotelFuncs {
	public static List<Hotel> hotelList=new ArrayList<>();
	public void addHotel(String hotelName,int rateOfHotelRegularCust) {
		Hotel hotel=new Hotel(hotelName,rateOfHotelRegularCust);
		hotelList.add(hotel);
	}
	 
	public List<Hotel> getHotelList(){
		return hotelList;
	}
	
}
