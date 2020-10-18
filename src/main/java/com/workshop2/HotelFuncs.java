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
	public void addHotel(String hotelName,int rateOfHotelRegularCustWeekDay,int rateOfHotelRegularCustWeekNday
			            ,int rateOfHotelRewardCustWeekDay,int rateOfHotelRewardCustWeekNDay,int rating) 
	{
		Hotel hotel=new Hotel(hotelName,rateOfHotelRegularCustWeekDay,rateOfHotelRegularCustWeekNday
				             ,rateOfHotelRewardCustWeekDay,rateOfHotelRewardCustWeekNDay,rating);
		hotelList.add(hotel);
	}
	 
	public List<Hotel> getHotelList(){
		return hotelList;
	}
	
	public static int getCheapestHotel(LocalDate startDate,LocalDate endDate,String custType) throws DateTimeException {
		int cheapestCost=computeCost(hotelList.get(0),startDate,endDate,custType);
		for(int i=1;i<hotelList.size();i++) {
			    int compareCost=computeCost(hotelList.get(i),startDate,endDate,custType);
			if(compareCost<cheapestCost)
				cheapestCost=compareCost;
		}
       int maxRating=0;
       for(int i=0;i<hotelList.size();i++){
       	 if(computeCost(hotelList.get(i),startDate,endDate,custType)==cheapestCost) {
    		   if(hotelList.get(i).getRating()>maxRating) {
    			  maxRating=hotelList.get(i).getRating();
		       }
    	 }
	}
       
       for(int i=0;i<hotelList.size();i++){
      		   if(hotelList.get(i).getRating()==maxRating) {
      			 System.out.println("The cheapest Hotel is "+"'"+hotelList.get(i).getHotelName()
      					+"'"+"for "+custType+" with Rating: "+maxRating+" with Total Rates: "+cheapestCost);
  		       }
      	 }
        return cheapestCost;
	
}
    
	public static int bestRatedHotel(LocalDate startDate,LocalDate endDate,String custType) throws DateTimeException{
		int maxRating=0;
		 for(int i=0;i<hotelList.size();i++){
	    		   if(hotelList.get(i).getRating()>maxRating) {
	    			  maxRating=hotelList.get(i).getRating();
			       }   	 
		}
		 
		 int bestRatedCost=0;
		 for(int i=0;i<hotelList.size();i++){
    		   if(hotelList.get(i).getRating()==maxRating) {
    			   bestRatedCost=computeCost(hotelList.get(i),startDate,endDate,custType);
    			  System.out.println("The best rated Hotel is "+"'"+hotelList.get(i).getHotelName()
        					+"'"+"for "+custType+" with Rating: "+maxRating+" with Total Rates: "+bestRatedCost);
    			  break;
		       }
    	 } 
		return bestRatedCost; 
	}
	 
	public static int computeCost(Hotel hotel, LocalDate startDate, LocalDate endDate, String custType ) throws DateTimeException {
		 int cost=0;
		 int weekdayRate=0;
		 int weekNdayRate=0;
		 if(custType.equalsIgnoreCase("Regular")) {
			 weekdayRate=hotel.getRateOfHotelRegularCustWeekDay();
			 weekNdayRate=hotel.getRateOfHotelRegularCustWeekNday();
		 }
		 else {
			 weekdayRate=hotel.getRateOfHotelRewardCustWeekDay();
			 weekNdayRate=hotel.getRateOfHotelRewardCustWeekNday();
		 }
		 endDate=endDate.plusDays(1);
		 while(startDate.compareTo(endDate)!=0) {
			 DayOfWeek day = DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK));
			 switch(day) {
			 case SATURDAY:
				        cost=cost+weekNdayRate;
				        break;
			 case SUNDAY:
				 		cost=cost+weekNdayRate;
				 		break;
			 default:
				        cost=cost+weekdayRate;
				        break;
			 }
			 startDate=startDate.plusDays(1);
		 }
		 return cost;
	}
	
}
