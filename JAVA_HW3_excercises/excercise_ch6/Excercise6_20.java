// 연습문제 6-20
package exercise_ch6;

public class Excercise6_20 {

	public static int[] shuffle(int[] arr){
	
		for (int n = 0; n < arr.length; n++){
			
			int i = (int) (Math.random()*arr.length);
			int j = (int) (Math.random()*arr.length);
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		return arr; 
		
	}
		
	public static void main (String[] args){
	
		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		
	}
	
	
}
