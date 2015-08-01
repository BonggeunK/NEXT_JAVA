package grading;

import java.util.Comparator;

public class Student {

	private String studentName;
	private String studentId;
	private String studentMajor;
	
	public static Comparator<Student> studentIdComp = new Comparator<Student>(){
		
		public int compare(Student s1, Student s2){
			int id1 = Integer.parseInt(s1.getStudentId());
			int id2 = Integer.parseInt(s2.getStudentId());
			return id1-id2;
		}
	};
	
	public Student(String name, String id, String major){
		this.studentName = name;
		this.studentId = id;
		this.studentMajor = major;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	@Override
	public int hashCode() {
		return studentId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Student){
			
			Student s = (Student) obj;
			
			if (s.getStudentId() == this.getStudentId())
				return true;
			else return false;
		}
		return false;
	}
	
}
