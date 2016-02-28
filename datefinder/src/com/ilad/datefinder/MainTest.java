package com.ilad.datefinder;

import com.ilad.datefinder.DateFinder.Month;

public class MainTest {

	public static void main(String[] args) throws Exception {
		DateFinder date1 = new DateFinder(1983, Month.OCTOBER, 17);
		DateFinder date2 = new DateFinder(1983, Month.OCTOBER, 17, true);
		DateFinder date3 = new DateFinder(1983, Month.OCTOBER, 17, false);
		
		System.out.println("date1 = " + date1);
		System.out.println("date1.findDay() = " + date1.findDay());
		System.out.println("date1.isLeapYear() = " + date1.isLeapYear());
		System.out.println("date1.isValidDate() = " + date1.isValidDate());
		System.out.println("date2 = " + date2);
		System.out.println("date2.findDay() = " + date2.findDay());
		System.out.println("date2.isLeapYear() = " + date2.isLeapYear());
		System.out.println("date2.isValidDate() = " + date2.isValidDate());
		System.out.println("date3 = " + date3);
		System.out.println("date3.findDay() = " + date3.findDay());
		System.out.println("date3.isLeapYear() = " + date3.isLeapYear());
		System.out.println("date3.isValidDate() = " + date3.isValidDate());
		
		date1 = new DateFinder(2015, Month.NOVEMBER, 27);
		date2 = new DateFinder(2015, Month.NOVEMBER, 27, true);
		date3 = new DateFinder(2015, Month.NOVEMBER, 27, false);
		
		System.out.println("date1 = " + date1);
		System.out.println("date1.findDay() = " + date1.findDay());
		System.out.println("date1.isLeapYear() = " + date1.isLeapYear());
		System.out.println("date1.isValidDate() = " + date1.isValidDate());
		System.out.println("date2 = " + date2);
		System.out.println("date2.findDay() = " + date2.findDay());
		System.out.println("date2.isLeapYear() = " + date2.isLeapYear());
		System.out.println("date2.isValidDate() = " + date2.isValidDate());
		System.out.println("date3 = " + date3);
		System.out.println("date3.findDay() = " + date3.findDay());
		System.out.println("date3.isLeapYear() = " + date3.isLeapYear());
		System.out.println("date3.isValidDate() = " + date3.isValidDate());
	}
}
