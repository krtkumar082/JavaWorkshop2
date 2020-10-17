package com.workshop2;

import java.time.LocalDate;
import java.time.Period;
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
	
	public Hotel cheapestHotel(LocalDate startDate,LocalDate endDate) {
		Period period = Period.between(startDate, endDate);
		int days=period.getDays();
		Hotel cheapest=hotelList.get(0);
		for(int i=1;i<hotelList.size();i++) {
			if(hotelList.get(i).getRateRegCust()<cheapest.getRateRegCust())
				cheapest=hotelList.get(i);
		}
		return cheapest;
	}
}
