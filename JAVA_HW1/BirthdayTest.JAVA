package check_birthday;

public class BirthdayTest {

	public static void main(String[] args) {
		
		Birthday b_day = new Birthday();

		b_day.setYear(2015);
		b_day.setMonth(2);
		b_day.setDay(29);

		System.out.println(b_day.getYear()+"년 "+b_day.getMonth()+"월 "
							+b_day.getDay()+"일 ");
	}

}
