package kr.co.mlec.day01.calendar.type1;

import java.util.Scanner;

public class CalendarView {
	private Scanner sc;

	public CalendarView() {
		sc = new Scanner(System.in);
	}

	public void process() {

		CalendarUtil util = new CalendarUtil();

		while (true) {
			System.out.print("항목을 선택하세요. (1. 특정 년도 2. 특정월 3. 종료)");

			int type = sc.nextInt();

			int year = 0, month = 0;

			switch (type) {
			case 1:
				System.out.print("년도를 입력하세요. : ");
				year = sc.nextInt();
				util.showByYear(year);
				break;

			case 2:
				System.out.print("년도를 입력하세요. : ");
				year = sc.nextInt();
				System.out.print("월을 입력하세요. : ");
				month = sc.nextInt();
				util.showByMonth(year, month);
				break;

			case 3:
				System.out.println("==================================");
				System.out.println("\t 프로그램을 종료합니다.");
				System.out.println("==================================");
				System.exit(0);
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 1-3번 사이만 입력하세요.");
				break;
			}
		}
	}

}
