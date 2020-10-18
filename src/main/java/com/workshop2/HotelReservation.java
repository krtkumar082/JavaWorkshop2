package com.workshop2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class HotelReservation {
	
	static HotelFuncs f1=new HotelFuncs();
	static Scanner sc=new Scanner(System.in);
	static HotelValidation valid=new HotelValidation();
	
	
	public static void cheapestHotelfunc() throws InvalidCustomerException {
		try {
	 		System.out.println("enter the start date-(YYYY-MM-DD)");
	 		LocalDate startDate=LocalDate.parse(sc.next());
	 		System.out.println("enter the end date-(YYYY-MM-DD)");
	 		LocalDate endDate=LocalDate.parse(sc.next());
	 		String custType=null;
	 	      
	 		do {
	 			try {
	 	    	  System.out.println("enter the customer type - Reward/Regular");
	 	    	  custType=sc.next();
	 	    	  if(custType.equalsIgnoreCase("Reward") || custType.equalsIgnoreCase("Regular"))
	 	    		  break;
	 	    	  else {
	 	    		  throw new InvalidCustomerException();
	 	    	  }
	 	      }catch(InvalidCustomerException e) {
	 	    	 System.out.println(e.getMessage()); 
	 	      }
	 		}while(true);
	 	int cost=0;	
	 	cost=f1.getCheapestHotel(startDate,endDate,custType);
 		}catch(DateTimeException e) {
 			System.out.println("Invalid date format");
 		} 
	}
	
	public static void bestRatedHotel() throws InvalidCustomerException{
		try {
	 		System.out.println("enter the start date-(YYYY-MM-DD)");
	 		LocalDate startDate=LocalDate.parse(sc.next());
	 		System.out.println("enter the end date-(YYYY-MM-DD)");
	 		LocalDate endDate=LocalDate.parse(sc.next());
	 		String custType=null;
	 		
	 		do {
	 			try {
	 	    	  System.out.println("enter the customer type - Reward/Regular");
	 	    	  custType=sc.next();
	 	    	  if(custType.equalsIgnoreCase("Reward") || custType.equalsIgnoreCase("Regular"))
	 	    		  break;
	 	    	  else {
	 	    		  throw new InvalidCustomerException();
	 	    	  }
	 	      }catch(InvalidCustomerException e) {
	 	    	 System.out.println(e.getMessage());
	 	      }
	 		}while(true);
	 	int cost=0;	
	 	cost=f1.bestRatedHotel(startDate,endDate,custType);
 		}catch(DateTimeException e) {
 			System.out.println("Invalid date format");
 		} 
	}
	
	public static void main(String[] args) throws InvalidCustomerException {
	System.out.println(" Welcome to hotel management system");
	
	 int option=0;
	 do{
		 System.out.println("Enter the option to choose\n"+"1)add hotel\n"+"2) cheapest hotel\n"
	                        +"3) Best Rated Hotel\n"
	                        +"4)exit");
		 option=sc.nextInt();
		 switch(option) {
		 case 1:do {
			 		System.out.println("enter hotel name");
			 		String name=sc.next();
			 		boolean isValid=valid.validate(name);
			 		while(!isValid) {
			 			System.out.println("enter hotel name again in proper valid format");
			 			name=sc.next();
			 			isValid=valid.validate(name);
			 		}
			 		System.out.println("enter the rate of the hotel for regular customer for week days");
			 		int rateWeekDayRegCust=sc.nextInt();
			 		System.out.println("enter the rate of the hotel for regular customer for weekend days");
			 		int rateWeekNdayRegCust=sc.nextInt();
			 		System.out.println("enter the rate of the hotel for reward customer for week days");
			 		int rateWeekDayRewdCust=sc.nextInt();
			 		System.out.println("enter the rate of the hotel for reward customer for weekend days");
			 		int rateWeekNdayRewdCust=sc.nextInt();
			 		System.out.println("Enter the hotel rating");
			 		int rating=sc.nextInt();
			 		f1.addHotel(name,rateWeekDayRegCust,rateWeekNdayRegCust
			 				    ,rateWeekDayRewdCust,rateWeekNdayRewdCust,rating);
			 		System.out.println("want to add more hotel Y/N");
					 char ch=sc.next().charAt(0);
					 if(ch=='Y')
						 continue;
					 else
						 break;
		         }while(true);
			 		break;
			 		
		 case 2: cheapestHotelfunc();
		         break;
		         
		 case 3: bestRatedHotel();
                  break;        
			 		
	     case 4:System.out.println("exit");
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
