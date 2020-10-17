package com.workshop2;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class HotelFuncs {
	public static List<Hotel> hotelList=new ArrayList<>();
	public void addHotel(String hotelName,int rateOfHotelRegularCust,int rateOfHotelRegularCustWeekNday,int rating) {
		Hotel hotel=new Hotel(hotelName,rateOfHotelRegularCust,rateOfHotelRegularCustWeekNday,rating);
		hotelList.add(hotel);
	}
	 
	public List<Hotel> getHotelList(){
		return hotelList;
	}
	
	public static int getCheapestHotel(LocalDate startDate,LocalDate endDate) throws DateTimeException {
		int cheapestCost=computeCost(hotelList.get(0),startDate,endDate);
		for(int i=1;i<hotelList.size();i++) {
			    int compareCost=computeCost(hotelList.get(i),startDate,endDate);
			if(compareCost<cheapestCost)
				cheapestCost=compareCost;
		}
       int maxRating=0;
       for(int i=0;i<hotelList.size();i++){
       	 if(computeCost(hotelList.get(i),startDate,endDate)==cheapestCost) {
    		   if(hotelList.get(i).getRating()>maxRating) {
    			  maxRating=hotelList.get(i).getRating();
		       }
    	 }
	}
       
       for(int i=0;i<hotelList.size();i++){
      		   if(hotelList.get(i).getRating()==maxRating) {
      			 System.out.println("The cheapest Hotel is "+"'"+hotelList.get(i).getHotelName()
      					+"'"+" with Rating: "+maxRating+" with Total Rates: "+cheapestCost);
  		       }
      	 }
        return cheapestCost;
	
}
    
	 
	public static int computeCost(Hotel hotel, LocalDate startDate, LocalDate endDate) throws DateTimeException {
		 int cost=0;
		 endDate=endDate.plusDays(1);
		 while(startDate.compareTo(endDate)!=0) {
			 DayOfWeek day = DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK));
			 switch(day) {
			 case SATURDAY:
				        cost=cost+hotel.getRateOfHotelRegularCustWeekNday();
				        break;
			 case SUNDAY:
				 		cost=cost+hotel.getRateOfHotelRegularCustWeekNday();
				 		break;
			 default:
				        cost=cost+hotel.getRateOfHotelRegularCustWeekDay();
				        break;
			 }
			 startDate=startDate.plusDays(1);
		 }
		 return cost;
	}
	
}
