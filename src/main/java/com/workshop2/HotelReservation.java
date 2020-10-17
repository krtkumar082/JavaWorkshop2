package com.workshop2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class HotelReservation {
	
	static HotelFuncs f1=new HotelFuncs();
	static Scanner sc=new Scanner(System.in);
	
	public static void cheapestHotelfunc() {
		try {
	 		System.out.println("enter the start date-(YYYY-MM-DD)");
	 		LocalDate startDate=LocalDate.parse(sc.next());
	 		System.out.println("enter the end date-(YYYY-MM-DD)");
	 		LocalDate endDate=LocalDate.parse(sc.next());
	 		Period period = Period.between(startDate, endDate);
	 		int days=period.getDays()+1;
	 		Hotel cheapest=f1.cheapestHotel(startDate,endDate);
	 		System.out.println("The cheapest hotel with rate is");
	 		System.out.println(cheapest.getHotelName()+" , Total Rates: "+cheapest.getRateRegCust()*days);
 		}catch(DateTimeException e) {
 			System.out.println("Invalid date format");
 		} 
	}
	
	
	public static void main(String[] args) {
	System.out.println(" Welcome to hotel management system");
	
	 int option=0;
	 do{
		 System.out.println("Enter the option to choose\n"+"1)add hotel\n"+"2) cheapest hotel\n"+"3)exit");
		 option=sc.nextInt();
		 switch(option) {
		 case 1:do {
			 		System.out.println("enter hotel name");
			 		String name=sc.next();
			 		System.out.println("enter the rate of the hotel for regular customer");
			 		int rate=sc.nextInt();
			 		f1.addHotel(name,rate);
			 		System.out.println("want to add more hotel Y/N");
					 char ch=sc.next().charAt(0);
					 if(ch=='Y')
						 continue;
					 else
						 break;
		         }while(true);
			 		break;
		 case 2:  cheapestHotelfunc();
		          break;
		          
	     case 3:System.out.println("exit");
	 			break;
	 			
	 }	 
		 System.out.println("want to continue Y/N");
		 char ch=sc.next().charAt(0);
		 if(ch=='Y')
			 continue;
		 else {
			 System.out.println("Thank You For Visting");
			 break;
		 }
	 }while(true);
   }
}
