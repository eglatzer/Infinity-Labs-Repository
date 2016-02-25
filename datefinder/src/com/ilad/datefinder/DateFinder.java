package com.ilad.datefinder;

public class DateFinder {
	private int m_year;
	private Month m_month;
	private int m_day;

	private static int i;
	private static int j;
	private final static int GREG_CALENDAR_CYCLE = 400;
//	private final static int JULY_CALENDAR_CYCLE = 28;
	private final static int KINDS_OF_YEAR = 2; // non leap and leap year
	private final static int NUMBER_OF_MONTHS = 12;
	private final static int NUMBER_OF_WEEKDAYS = 7;
	
	private final static int[] GREG_CODE_OF_YEAR = new int[GREG_CALENDAR_CYCLE];
//	private final static int[] JULY_CODE_OF_YEAR = new int[JULY_CALENDAR_CYCLE];
	private final static int[][] DAYS_IN_MONTH =
			new int[KINDS_OF_YEAR][NUMBER_OF_MONTHS];
	private final static int[][] CODE_OF_MONTH =
			new int[KINDS_OF_YEAR][NUMBER_OF_MONTHS];
	
	static {
		// initiate GREG_CODE_OF_YEAR LUT
		GREG_CODE_OF_YEAR[0] = 0;
		for(i = 1; i < GREG_CALENDAR_CYCLE; ++i) {
			GREG_CODE_OF_YEAR[i] =
					(GREG_CODE_OF_YEAR[i - 1] + gregRemainder(i - 1))
					% NUMBER_OF_WEEKDAYS;
		}
		
		// initiate JULY_CODE_OF_YEAR LUT
/*		JULY_CODE_OF_YEAR[0] = 5;
		for(i = 1; i < JULY_CALENDAR_CYCLE; ++i) {
			JULY_CODE_OF_YEAR[i] =
					(JULY_CODE_OF_YEAR[i - 1] + julyRemainder(i - 1)) %
					NUMBER_OF_WEEKDAYS;
		}*/
		
		// initiate DAYS_IN_MONTH LUT
		for(i = 1; i < 8; ++i) { // initiate January-July except February
			if(i != 2) {
				DAYS_IN_MONTH[0][i] = 30 + (i % 2);
				DAYS_IN_MONTH[1][i] = 30 + (i % 2);
			}
		}
		for(i = 8; i <= NUMBER_OF_MONTHS; ++i) { // initiate August-December
			DAYS_IN_MONTH[0][i % NUMBER_OF_MONTHS] = 31 - (i % 2);
			DAYS_IN_MONTH[1][i % NUMBER_OF_MONTHS] = 31 - (i % 2);
		}
		DAYS_IN_MONTH[0][2] = 28; // initiate February in non leap year
		DAYS_IN_MONTH[1][2] = 29; // initiate February in leap year
		
		// initiate CODE_OF_MONTH LUT
		CODE_OF_MONTH[0][1] = 0; // CODE_OF_MONTH of January in non leap year
		CODE_OF_MONTH[1][1] = 0; // CODE_OF_MONTH of January in leap year
		for(i = 0; i < KINDS_OF_YEAR; ++i) { // CODE_OF_MONTH of other months
			for(j = 2; j <= NUMBER_OF_MONTHS; ++j) {
				CODE_OF_MONTH[i][j % NUMBER_OF_MONTHS] =
					(CODE_OF_MONTH[i][j - 1] + DAYS_IN_MONTH[i][j - 1]) %
					NUMBER_OF_WEEKDAYS;
			}
		}
	}

	// Constructor
	public DateFinder(int year_, Month month_, int day_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
	}
	
	@Override
	public String toString() {
		return "[m_year = " + m_year + ", m_month = " + m_month +
				", m_day = " + m_day + "]";
	}

	private static int gregRemainder(int year_) {
		return (0 == year_ % 400 || (0 == year_ % 4 && 0 != year_ % 100) ? 2 : 1);
	}
	
/*	private static int julyRemainder(int year_) {
		return (0 == year_ % 4 ? 2 : 1);
	}
*/
	public boolean isLeapYear() {
		return (0 == m_year % 400 || (0 == m_year % 4 && 0 != m_year % 100));
		// Has to be modified for Julian Celander
	}

	public boolean isValidDate() {
		int code = (isLeapYear() ? 1 : 0);
		if(m_day < 1 || m_day > DAYS_IN_MONTH[code][m_month.value]) {
			return false;
		}
		return true;
	}

	public Day findDay() throws Exception {
		if(!isValidDate()) {
			throw new Exception("It's invalid date!");
		}
		int code = (isLeapYear() ? 1 : 0);
		return Day.dayName
				((GREG_CODE_OF_YEAR[m_year % GREG_CALENDAR_CYCLE] +
				CODE_OF_MONTH[code][m_month.value] + m_day - 1) %
				NUMBER_OF_WEEKDAYS);
	}

	public void setDate(int year_, Month month_, int day_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
	}

	public enum Day {
		SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6),
		SATURDAY(0);
		private int value;

		private Day(int value_) {
			value = value_;
		}
		
		public static Day dayName(int value_) {
			for(Day d : Day.values()) {
				if(d.value == value_) {
					return d;
				}
			}
			return null;
		}
	};

	public enum Month {
		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7),
		AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(0);

		private int value;

		private Month(int value_) {
			value = value_;
		}
		
		public static Month monthName(int value_) {
			for(Month m : Month.values()) {
				if(m.value == value_) {
					return m;
				}
			}
			return null;
		}
	};
}
