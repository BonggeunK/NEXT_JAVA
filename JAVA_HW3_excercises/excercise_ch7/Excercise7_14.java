// 연습문제 7-14
package excercise_ch7;

class SutdaCard_ {
	final int num;
	final boolean isKwang;
	
	SutdaCard_() {
		this(1, true);
	}
	
	SutdaCard_(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString(){
		return num + (isKwang? "K": "");
	}
	
}

public class Excercise7_14 {

	public static void main(String[] args) {
		SutdaCard_ card = new SutdaCard_(1, true);

	}

}
