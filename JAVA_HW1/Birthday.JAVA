package check_birthday;

public class Birthday {

	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {

		if (month == 2){
		
			if (((year%4 == 0)&&(year%100 != 0))||(year%400 == 0)){
				dayCheck(day, 1, 29);
			} else {
				dayCheck(day, 1, 28);
			}

		} else if ((month == 4)||(month == 6)||(month == 9)||(month == 11)){
			dayCheck(day, 1, 30);

		} else{
			dayCheck(day, 1, 31);
		}

		this.day = day;

	}

	public void dayCheck(int day, int dayMin, int dayMax){

		if ((day < dayMin)||(day > dayMax)){
			System.out.println("출생 일이 잘못 입력되었습니다.");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {

		if ((month < 1) || (month > 12)){
			System.out.println("출생 월이 잘못 입력되었습니다.");
		}

		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 0){
			System.out.println("출생 연도가 잘못 입력되었습니다.");
		}
		
		this.year = year;
	}
	
}
