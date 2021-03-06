package com.ilad.datefinder;

public class DateFinder {
	private int m_year;
	private Month m_month;
	private int m_day;
	private boolean m_isGregorian;

	private static int i;
	private static int j;
	private final static int GREG_CALENDAR_CYCLE = 400;
	private final static int JULY_CALENDAR_CYCLE = 28;
	private final static int KINDS_OF_YEAR = 2; // non leap and leap year
	private final static int NUMBER_OF_MONTHS = 12;
	private final static int NUMBER_OF_WEEKDAYS = 7;
	
	private final static int[] GREG_CODE_OF_YEAR = new int[GREG_CALENDAR_CYCLE];
	private final static int[] JULY_CODE_OF_YEAR = new int[JULY_CALENDAR_CYCLE];
	private final static int[][] DAYS_IN_MONTH =
			new int[KINDS_OF_YEAR][NUMBER_OF_MONTHS];
	private final static int[][] CODE_OF_MONTH =
			new int[KINDS_OF_YEAR][NUMBER_OF_MONTHS];
	
	static {
		// initiate GREG_CODE_OF_YEAR LUT
		GREG_CODE_OF_YEAR[0] = 0;
		for(i = 1; i < GREG_CALENDAR_CYCLE; ++i) {
			GREG_CODE_OF_YEAR[i] =
					(GREG_CODE_OF_YEAR[i - 1] + remainder(i - 1, true))
					% NUMBER_OF_WEEKDAYS;
		}
		
		// initiate JULY_CODE_OF_YEAR LUT
		JULY_CODE_OF_YEAR[0] = 5;
		for(i = 1; i < JULY_CALENDAR_CYCLE; ++i) {
			JULY_CODE_OF_YEAR[i] =
					(JULY_CODE_OF_YEAR[i - 1] + remainder(i - 1, false)) %
					NUMBER_OF_WEEKDAYS;
		}
		
		// initiate DAYS_IN_MONTH LUT
		for(i = 1; i < 8; ++i) { // initiate January-July
			DAYS_IN_MONTH[0][i] = 30 + (i % 2);
			DAYS_IN_MONTH[1][i] = 30 + (i % 2);
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
	
	private static int remainder(int year_, boolean isGregorian_) {
		if(isGregorian_) {
			return (0 == year_ % 400 || (0 == year_ % 4 && 0 != year_ % 100) ?
					2 : 1);
		}
		return (0 == year_ % 4 ? 2 : 1);
	}
	
	private boolean isGregCalendar() {
		return (1582 < m_year ||
			   (1582 == m_year &&
			   (11 == m_month.value || 0 == m_month.value ||
			   (10 == m_month.value && 14 < m_day))));
	}
	
	private int kindOfYear() {
		return remainder(m_year, m_isGregorian) - 1;
	}

	// Constructors
	public DateFinder(int year_, Month month_, int day_, boolean isGregorian_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
		m_isGregorian = isGregorian_;
	}
	
	public DateFinder(int year_, Month month_, int day_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
		m_isGregorian = isGregCalendar();
	}
	
	// Setters
	public void setDate(int year_, Month month_, int day_, boolean isGregorian_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
		m_isGregorian = isGregorian_;
	}
	
	public void setDate(int year_, Month month_, int day_) {
		m_year = year_;
		m_month = month_;
		m_day = day_;
		m_isGregorian = isGregCalendar();
	}

	public boolean isLeapYear() {
		return (1 == kindOfYear());
	}

	public boolean isValidDate() {
		if(m_day < 1 || m_day > DAYS_IN_MONTH[kindOfYear()][m_month.value]) {
			return false;
		}
		return true;
	}

	public Day findDay() {
		if(!isValidDate()) {
			return null;
		}
		
		int codeOfYear = (m_isGregorian ?
				GREG_CODE_OF_YEAR[m_year % GREG_CALENDAR_CYCLE] :
				JULY_CODE_OF_YEAR[m_year % JULY_CALENDAR_CYCLE]);
		
		return Day.dayName
				((codeOfYear +
				CODE_OF_MONTH[kindOfYear()][m_month.value] + m_day - 1) %
				NUMBER_OF_WEEKDAYS);
	}	

	@Override
	public String toString() {
		String date = "[m_year = " + m_year + ", m_month = " + m_month +
				", m_day = " + m_day + ", m_isGregorian = " + m_isGregorian + "]";
		if(!isValidDate()) {
			date += " It's not a valid date!";
		}
		return date;
	}
	
	public enum Month {
		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7),
		AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(0);

		private int value;

		private Month(int value_) {
			value = value_;
		}
	};
	
	public enum Day {
		SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6),
		SATURDAY(0);
		private int value;

		private Day(int value_) {
			value = value_;
		}
		
		private static Day dayName(int value_) {
			for(Day d : Day.values()) {
				if(d.value == value_) {
					return d;
				}
			}
			return null;
		}
	};
}
