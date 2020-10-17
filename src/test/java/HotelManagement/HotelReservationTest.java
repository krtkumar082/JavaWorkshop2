package HotelManagement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
