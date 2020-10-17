package com.workshop2;

import java.util.*;

public class HotelReservation {
	public static void main(String[] args) {
	System.out.println(" Welcome to hotel management system");
	Scanner sc=new Scanner(System.in);
	 int option=0;
	 do{
		 System.out.println("Enter the option to choose\n"+"1)add hotel\n"+"2)exit");
		 option=sc.nextInt();
		 switch(option) {
		 case 1: System.out.println("enter hotel name");
	         String name=sc.next();
	         System.out.println("enter the rate of the hotel for regular customer");
	         int rate=sc.nextInt();
	         HotelFuncs f1=new HotelFuncs();
	         f1.addHotel(name,rate);
	         break;
	     case 2:System.out.println("exit");
	 		break;
	 }	 
		 System.out.println("want to add more hotel Y/N");
		 char ch=sc.next().charAt(0);
		 if(ch=='Y')
			 continue;
		 else
			 break;
	 }while(true);
   }
}
