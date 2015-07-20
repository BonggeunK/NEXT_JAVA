// 연습문제 6-1, 6-2

package exercise_ch6;

public class SutdaCard {

	public int num;
	public boolean isKwang;
	
	
	public SutdaCard(){
		this(1, true);
	}
	
	public SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String info(){
		
		if (isKwang){
			return num + "K";
		} else{
			return num + "";
		}	
	}
	
		
}
