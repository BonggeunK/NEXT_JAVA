package grading;

public class School {

	private static School school = new School();
	
	private School(){}
	
	public static School getSchool(){
		return school;
	}

	public void printReport(Session session) {
		GradeReport report = new GradeReport();
		report.printGradeReport(session);
	}
	
}
