package test;

import java.util.Collections;
import grading.School;
import grading.Session;
import grading.Student;

public class StudentGradeTest {

	public static void main(String[] args) {
		
		School school = School.getSchool();
		
		Student student1 = new Student("이승기", "141213", "math");
		Student student2 = new Student("김수현", "141518", "english");
		Student student3 = new Student("주원", "141230", "math");
		Student student4 = new Student("김우빈", "141255", "math");
		Student student5 = new Student("이민호", "141590", "english");
		
		Session math = new Session();
		Session english = new Session();
		math.setSessionName("math");
		english.setSessionName("english");
		
		math.enrollList.add(student1);
		math.enrollList.add(student2);
		math.enrollList.add(student3);
		math.enrollList.add(student4);
		math.enrollList.add(student5);
		Collections.sort(math.enrollList, Student.studentIdComp);
		
		english.enrollList.add(student1);
		english.enrollList.add(student2);
		english.enrollList.add(student3);
		english.enrollList.add(student4);
		english.enrollList.add(student5);
		Collections.sort(english.enrollList, Student.studentIdComp);
		
		math.setScore("141213", 95);
		math.setScore("141518", 90);
		math.setScore("141230", 76);
		math.setScore("141255", 85);
		math.setScore("141590", 90);
		
		english.setScore("141213", 20);
		english.setScore("141518", 100);
		english.setScore("141230", 60);
		english.setScore("141255", 89);
		english.setScore("141590", 95);
		
		System.out.println("============================");
		school.printReport(math);
		System.out.println("============================");
		school.printReport(english);
		

	}

}
