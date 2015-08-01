package strategy;

public class MajorGrade implements IGrade {

	@Override
	public String calcGrade(int number) {
		
		String grade;
		
		if (number >= 95 && number <= 100 ){
			grade = "S";
		} else if (number >= 90 && number <= 94){
			grade = "A";
		} else if (number >= 80 && number <= 89){
			grade = "B";
		} else if (number >= 70 && number <= 79){
			grade = "C";
		} else if (number >= 60 && number <= 69){
			grade = "D";
		} else if (number >= 0 && number <= 59){
			grade = "F";
		} else {
			System.out.println("점수가 잘못 입력되었습니다.");
			grade = "NA";
		}
		
		return grade;
	}

}
