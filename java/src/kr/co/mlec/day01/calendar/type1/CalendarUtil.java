package kr.co.mlec.day01.calendar.type1;

import java.util.Calendar;

public class CalendarUtil {

	public void showByYear(int year) {
		for (int month = 1; month < 12; month++) {
			/* this. */showByMonth(year, month);
		}
	}

	public void showByMonth(int year, int month) {
		System.out.println("\t\t<< " + year + "년" + month + "월 >>");

		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);
		int week = c.get(Calendar.DAY_OF_WEEK);

		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		showByDay(week, lastday);
	}

	/**
	 * 달력을 출력하는 진짜 기능
	 * 
	 * @param week
	 * @param lastday
	 */
	private void showByDay(int week, int lastday) {

		System.out.println("---------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("---------------------------------------------------");

		int lineCnt = 0;
		for (int i = 1; i < week; i++) {

			System.out.print("\t");
			lineCnt++;
		}
		for (int day = 1; day <= lastday; day++) {
			System.out.print(day + "\t");
			lineCnt++;
			if (lineCnt % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();
	}
}
