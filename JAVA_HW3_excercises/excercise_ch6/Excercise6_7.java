// 연습문제 6-7
package exercise_ch6;

class MyPoint{
	
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x = this.y;
	}
	
	double getDistance(int x1, int y1){
		return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
	}
	
}

public class Excercise6_7 {

	public static void main (String[] args){
	
		MyPoint p = new MyPoint(1, 1);
		
		System.out.println(p.getDistance(2,2));
	}
	
}
