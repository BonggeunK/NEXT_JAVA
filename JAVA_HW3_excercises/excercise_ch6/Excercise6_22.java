// 연습문제 6-22
package exercise_ch6;

public class Excercise6_22 {

	static boolean isNumber(String str){
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			
			if (Character.isDigit(c) == false){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? "+ isNumber(str));
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? "+ isNumber(str));
	}

}
