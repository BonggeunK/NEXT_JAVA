// 연습문제 6-3, 6-4, 6-5

package exercise_ch6;

public class Student {

	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal(){
		return kor + eng + math;
	}
	
	public float getAverage(){
		return this.getTotal()/3.0f;
	}
	
	public String info(){
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
	
	
}
