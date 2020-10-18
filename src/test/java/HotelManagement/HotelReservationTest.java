package HotelManagement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.workshop2.Hotel;
import com.workshop2.HotelFuncs;

public class HotelReservationTest {
	@Test
	public void addedHotelCheck_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		boolean hotelInList = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Lakewood"))
			{ if(hotel.getRateOfHotelRegularCustWeekNday()==90)
				hotelInList=true;
			}
		}
		assertTrue(hotelInList);
	}
	
	@Test
	public void addedHotelCheck_ReturnFalse() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		boolean hotelInList = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Bakewood"))
			{ if(hotel.getRateOfHotelRegularCustWeekNday()==100)
				hotelInList=true;
			}
		}
		assertFalse(hotelInList);
	}
	
	@Test
	public void addedHotelCheckCheapest_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		try {
			LocalDate startDate=LocalDate.of(2020, 9, 11);
			LocalDate endDate=LocalDate.of(2020, 9, 12);
			int cheapestHotelCost=hotels.getCheapestHotel(startDate, endDate,"Regular");
			boolean result=false;
			if(cheapestHotelCost==200)
				result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid date format");
		}
	}
	
	@Test
	public void addedHotelRatings_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		
		boolean hotelRatingCheck1 = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Lakewood"))
			{ if(hotel.getRating()==3)
				{ hotelRatingCheck1=true;
			      break;
				}
			}
		}
		
		boolean hotelRatingCheck2 = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Ridgewood"))
			{ if(hotel.getRating()==5)
				{ hotelRatingCheck2=true;
			      break;
				}
			}
		}
		boolean result=hotelRatingCheck1 && hotelRatingCheck2;
		assertTrue(result);
	}
	
	@Test
	public void addedHotelCheckCheapestBestRated_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		try {
			LocalDate startDate=LocalDate.of(2020, 9, 11);
			LocalDate endDate=LocalDate.of(2020, 9, 12);
			int cheapestHotelCost=hotels.computeCost(hotels.getHotelList().get(1),startDate, endDate,"Regular");
			boolean result=false;
			boolean cond=  hotels.getHotelList().get(1).getHotelName().equalsIgnoreCase("Bridgewood") 
					       && cheapestHotelCost==200 && hotels.getHotelList().get(1).getRating()==4;
					if(cond)
						result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid date format");
		}
	}
	
	@Test
	public void addedHotelCheckBestRated_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		try {
			LocalDate startDate=LocalDate.of(2020, 9, 11);
			LocalDate endDate=LocalDate.of(2020, 9, 12);
			int bestRatedCost=hotels.bestRatedHotel(startDate, endDate,"Regular");
			boolean result=false;
			if(bestRatedCost==370)
				result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid date format");
		}
	}
	
	@Test
	public void addedHotelCheckRewardCustomer_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		boolean hotelInList = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Lakewood"))
			{ if(hotel.getRateOfHotelRewardCustWeekNday()==80)
				hotelInList=true;
			}
		}
		assertTrue(hotelInList);
	}
	
	@Test
	public void addedHotelCheckCheapestBestRatedForRewardCustomers_ReturnTrue() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110,90,80,80,3);
		hotels.addHotel("Bridgewood",150,50,110,50,4);
		hotels.addHotel("Ridgewood",220,150,100,40,5);
		try {
			LocalDate startDate=LocalDate.of(2020, 9, 11);
			LocalDate endDate=LocalDate.of(2020, 9, 12);
			int cheapestHotelCost=hotels.getCheapestHotel(startDate, endDate,"Reward");
			boolean result=false;
			boolean cond=  hotels.getHotelList().get(2).getHotelName().equalsIgnoreCase("Ridgewood") 
					       && cheapestHotelCost==140 && hotels.getHotelList().get(2).getRating()==5;
					if(cond)
						result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid date format");
		}
	}
	
}
