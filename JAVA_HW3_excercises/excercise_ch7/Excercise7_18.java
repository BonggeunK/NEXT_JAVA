// 연습문제 7-18
package excercise_ch7;

public class Excercise7_18 {

	static void action(Robot r){
		
		if (r instanceof DanceRobot){
			((DanceRobot) r).Dance();
		} else if (r instanceof SingRobot){
			((SingRobot) r).Sing();
		} else if (r instanceof DrawRobot){
			((DrawRobot) r).Draw();
		}
	}
	
	public static void main(String[] args) {

		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
		
		for (int i = 0; i<arr.length; i++){
			action(arr[i]);
		}

	}
}

class Robot {}

class DanceRobot extends Robot{
	void Dance(){
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot{
	void Sing(){
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot{
	void Draw(){
		System.out.println("그림을 그립니다.");
	}
}