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
		hotels.addHotel("Lakewood",110,90);
		hotels.addHotel("Bridgewood",150,50);
		hotels.addHotel("Rridgewood",200,150);
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
		hotels.addHotel("Lakewood",110,90);
		hotels.addHotel("Bridgewood",150,50);
		hotels.addHotel("Rridgewood",200,150);
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
		hotels.addHotel("Lakewood",110,90);
		hotels.addHotel("Bridgewood",150,50);
		hotels.addHotel("Rridgewood",200,150);
		try {
			LocalDate startDate=LocalDate.of(2020, 9, 11);
			LocalDate endDate=LocalDate.of(2020, 9, 12);
			int cheapestHotelCost=hotels.getCheapestHotel(startDate, endDate);
			boolean result=false;
			if(cheapestHotelCost==200)
				result=true;
			assertTrue(result);
		}catch(DateTimeException e) {
			System.out.println("Invalid date format");
		}
	}
	
	
}
