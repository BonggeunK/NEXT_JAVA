package grading;

import java.util.ArrayList;
import java.util.HashMap;

public class Session {
	
	private String sessionName;

	public ArrayList<Student> enrollList = new ArrayList<Student>();
	HashMap<Student, Integer> scorePair = new HashMap<Student, Integer>();
	
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	
	
	public void addStudent(Student student){
		enrollList.add(student);
	}
	
	
	public void setScore(String studentId, int number){
		
		Score score = new Score();
		score.setSession(this);
		
		for (int i = 0; i < enrollList.size(); i++){
			
			Student student = enrollList.get(i);
			String id = student.getStudentId();
			
			if (id.equals(studentId)){
				score.setStudentId(id);
				scorePair.put(student, number);
			}
		}
	}
	
}
