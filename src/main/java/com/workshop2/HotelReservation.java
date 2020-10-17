package com.workshop2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class HotelReservation {
	
	static HotelFuncs f1=new HotelFuncs();
	static Scanner sc=new Scanner(System.in);
	
	
	
	
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
			 		System.out.println("enter the rate of the hotel for regular customer for week days");
			 		int rateWeekDay=sc.nextInt();
			 		System.out.println("enter the rate of the hotel for regular customer for weekend days");
			 		int rateWeekNday=sc.nextInt();
			 		f1.addHotel(name,rateWeekDay,rateWeekDay);
			 		System.out.println("want to add more hotel Y/N");
					 char ch=sc.next().charAt(0);
					 if(ch=='Y')
						 continue;
					 else
						 break;
		         }while(true);
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
