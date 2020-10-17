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
		hotels.addHotel("Lakewood",110);
		hotels.addHotel("Bridgewood",150);
		hotels.addHotel("Rridgewood",200);
		boolean hotelInList = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("Lakewood"))
				hotelInList= true;
		}
		assertTrue(hotelInList);
	}
	
	@Test
	public void addedHotelCheck_ReturnFalse() {
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110);
		hotels.addHotel("Bridgewood",150);
		hotels.addHotel("Rridgewood",200);
		boolean hotelInList = false;
		for (Hotel hotel : hotels.getHotelList()) {
			if(hotel.getHotelName().equalsIgnoreCase("KkHotels"))
				hotelInList= true;
		}
		assertFalse(hotelInList);
	}
	
	@Test
	public void addedHotelCheckCheapest_ReturnTrue() {
		
		HotelFuncs hotels=new HotelFuncs();
		hotels.addHotel("Lakewood",110);
		hotels.addHotel("Bridgewood",150);
		hotels.addHotel("Rridgewood",200);
		try {
			LocalDate startDate=LocalDate.of(2020,9,10);
			LocalDate endDate=LocalDate.of(2020,9,11);
			Hotel cheapest=hotels.cheapestHotel(startDate,endDate);
			boolean result=false;
			if(cheapest.getHotelName().equalsIgnoreCase("lakewood"))
				result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid Date format");
		}
	}
	
}
