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
		Hotel cheapestHotel = hotelList.stream()  
                .min((hotel1, hotel2)->   
                computeCost(hotel1,startDate,endDate,custType) > computeCost(hotel2,startDate,endDate,custType) ? 1: -1).get();
       
		Hotel cheapestBestRatedHotel =hotelList.stream()  
                .filter(hotel -> 
                 computeCost(hotel,startDate,endDate,custType)==computeCost(cheapestHotel,startDate,endDate,custType))
                .max((hotel1,hotel2)->hotel1.getRating()>hotel2.getRating()?1:-1)        
                .get(); 
       
		System.out.println("The Cheapest Best Rated Hotel is "+"'"+cheapestBestRatedHotel.getHotelName()
					+"'"+"For "+custType+" Customers  Rating: "+cheapestBestRatedHotel.getRating()+
					"  Total Rates: "+computeCost(cheapestBestRatedHotel,startDate,endDate,custType));
        return computeCost(cheapestBestRatedHotel,startDate,endDate,custType);
	
}
    
	public static int bestRatedHotel(LocalDate startDate,LocalDate endDate,String custType) throws DateTimeException{
		Hotel BestRatedHotel =hotelList.stream()  
                .max((hotel1,hotel2)->hotel1.getRating()>hotel2.getRating()?1:-1)        
                .get();
		 
		System.out.println("The Best Rated Hotel is "+"'"+BestRatedHotel.getHotelName()
		+"'"+"For "+custType+" Customers  Rating: "+BestRatedHotel.getRating()+
		"  Total Rates: "+computeCost(BestRatedHotel,startDate,endDate,custType));
		return computeCost(BestRatedHotel,startDate,endDate,custType); 
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
