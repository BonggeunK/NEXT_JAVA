package grading;

import strategy.IGrade;
import strategy.BasicGrade;
import strategy.MajorGrade;

public class GradeReport {

	public void printGradeReport(Session session) {
		
		System.out.println(session.getSessionName()+"과목의 점수 및 학점");
		System.out.println("학번, 이름, 전공, 점수, 학점");
		
		for (int i = 0; i < session.enrollList.size(); i++){
			
			Student student = session.enrollList.get(i);
			int score = session.scorePair.get(student);
			String grade = this.setGrade(session, student, score);
						
			System.out.println(student.getStudentId()+", "+student.getStudentName()+", "
								+student.getStudentMajor()+", "+score+", "+grade);
		}
	}
	
	public String setGrade(Session session, Student student, int score){
		
		if (student.getStudentMajor().equals(session.getSessionName())){
			IGrade grade = new MajorGrade();
			return grade.calcGrade(score);
		} else{
			IGrade grade = new BasicGrade();
			return grade.calcGrade(score);
		}
	
	}	
	
}
