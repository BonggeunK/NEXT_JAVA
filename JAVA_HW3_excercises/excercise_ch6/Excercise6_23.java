// 연습문제 6-23
package exercise_ch6;

public class Excercise6_23 {

	static int max(int[] arr){
	
		if (arr == null || arr.length == 0){
			return -999999;
		}
		
		int max_val = arr[0];
		for (int i = 0; i < arr.length; i++){
			if (arr[i] > max_val){
				max_val = arr[i];
			}
		}
		return max_val;
	}
	
	public static void main(String[] args) {
		
		int[] data = {3, 2, 9, 4, 7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {}));
	}

}
