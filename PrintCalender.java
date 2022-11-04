/**
 * Author: Dien Mai 
 * File: PrintCalender.java
 * Date: 11/2/2022
 * Description: Print Calendar for user
 */

import java.util.Scanner;
public class PrintCalender {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter full year (e.g., 2001): ");
		int year = input.nextInt();
		
		System.out.print("Enter month as number between 1 and 12: ");
		int month = input.nextInt();
		
		
		printMonth(year,month);
		
	}
	
	public static void printMonth(int year, int month) {
		printMonthTitle(year,month);
		printMonthBody(year,month);
	}
	
	public static void printMonthBody(int year, int month) {
		int startDay = getStartDay(year,month);
		int numbOfMonth = getNumberOfDayInMonth(year,month); 
		
		int i = 0;
		for(i = 0; i < startDay; i++) {
			System.out.print("     ");
		}
		
		for(i = 1; i <= numbOfMonth; i++) {
			System.out.printf("%5d",i);
			if ((i + startDay) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void printMonthTitle(int year, int month) {
		System.out.println("\t\t" + getMonthName (month)+ " " + year );
		System.out.println("-------------------------------------");
		System.out.println("  Sun  Mon  Tue  Wed  Thu  Fri  Sat");
	}
	
	public static String getMonthName (int month) {
		String monthString ="";
		switch(month){
		case 1: monthString = "January";
		break;
		case 2: monthString = "February";
		break;
		case 3: monthString = "March";
		break;
		case 4: monthString = "April";
		break;
		case 5: monthString = "May";
		break;
		case 6: monthString = "June";
		break;
		case 7: monthString = "July";
		break;
		case 8: monthString = "August";
		break;
		case 9: monthString = "September";
		break;
		case 10:monthString = "October";
		break;
		case 11:monthString = "November";
		break;
		case 12: monthString = "December";
		break;
		default: monthString = "Invalid months";
		
		}
		return monthString;
	}
	
	public static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;
		
		int totalNumberOfDays = getTotalNummberOfDays(year,month);
		
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
	}
	
	public static int getNumberOfDayInMonth(int year, int month) {
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if( month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		
		if(month == 2) {
			return isLeapYear(year)? 29 : 28;
		}
		return 0;
	}
	
	public static int getTotalNummberOfDays(int year, int month) {
		int total =0;
		
		for(int i = 1800 ; i < year; i++) {
			if (isLeapYear(i)) {
				total += 366;
			} else {
				total += 365;
			}
		}
		for(int i = 1; i < month; i++) {
			total += getNumberOfDayInMonth(year,i);	
		}
		return total;
	}
	
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	
}
		

	

