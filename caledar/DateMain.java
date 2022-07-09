package kr.co.mlec.day01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
/*		Date d = new Date(); 
		System.out.println(d); 
		
		int year = d.getYear() + 1900; 
		int month = d.getMonth() + 1; 
		int date = d.getDate(); 

		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일 입니다.");
*/
//		System.out.println(Calendar.YEAR);// 객체를 만들지 않아도 static 이니까 만들 수 있다.

		Calendar c= Calendar.getInstance();
		System.out.println(c);
		
		int year = c.get(Calendar.YEAR); // 숫자 1 쓰는 것보다 훨씬 직관적인 방법.
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE); //DATE 대신 DAY_OF_MONTH 쓸 수도 있다.
		int day = c.get(Calendar.DAY_OF_WEEK); //1이 일요일 7이 토요일로 숫자 출력
				
		String[] week = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		//week[0] 일요일이고 week[6] 토요일이다.
		//그러니까 출력할 때는 day 값에서 1을 빼고 써야 위치가 일치한다.
		//만약 그게 귀찮으면 배열의 맨 앞에 공백 문자 배열 하나 추가하면 순서가 일요일이 1번째 배열로 되어서 맞는다.
		
		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일 ( "  + week[day] + " ) 입니다.");

		//현재 날짜 12월에 마지막 날 이 언제인지 알고 싶을 때.
		
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(month + "월의 마지막 날은 " + lastday + "일입니다.");
		
		//현재 calendar는 현재 시간에 설정되어 있는데 
		//2019년 5월 15일로 날짜 변경하고 싶다.
		//그리고 그 날이 무슨 요일인지 알고 싶었다.
		
		c.set(2019, 5-1, 15);
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("2019년 5월 15일은 " + week[day] + "입니다.");
		
		//지금 시간으로 돌아가고 싶을 때
		c = Calendar.getInstance();
		System.out.println(c);
		c.setTime(new Date());
		
	String pattern = "yyyy-MM-dd HH:mm:ss(E)";
	pattern = "오늘은 yyyy년 MM월 dd일 E요일입니다. 현재 시간 : hh시 mm분 ss초";
	System.out.println(pattern);
//	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	
	String str =sdf.format(new Date());
	//String str = sdf.format(c.set(2019, 5-1, 15)); //이렇게 하면 위에서 설정한 getTime의 날짜를 가져올 수 있다.
	
	System.out.println(str);
		
	}

}
