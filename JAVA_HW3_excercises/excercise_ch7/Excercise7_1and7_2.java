//연습문제 7-1, 7-2
package excercise_ch7;

class SutdaDeck {
	
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck(){		
		for (int i = 0; i < cards.length; i++){
			cards[i] = new SutdaCard();
			
			int idx = i+1;
			
			cards[i].num = (idx <= 10? idx : idx-10);
			
			if (idx == 1 || idx == 3 || idx == 8){
				cards[i].isKwang = true;
			} else{
				cards[i].isKwang = false;
			}
		}
	}
	
	void shuffle() {
		
		for (int n = 0; n < cards.length; n++){
			
			int i = (int) (Math.random()*cards.length);
			int j = (int) (Math.random()*cards.length);
			
			SutdaCard temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;		
		}
	}
	
	SutdaCard pick (int index){
		
		if (index < 0 || index > cards.length)
			return null;
		
		return cards[index];
	}
	
	SutdaCard pick (){
		int i = (int) (Math.random()*cards.length);
		return cards[i];
	}
}

class SutdaCard { 
	
	int num;
	boolean isKwang;
	
	SutdaCard(){
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString(){
		return num + (isKwang? "K":"");
	}
}


public class Excercise7_1and7_2 {

// 연습문제 7-1 main 메소드
//		public static void main(String[] args) {
//			SutdaDeck deck = new SutdaDeck();
//			
//			for (int i = 0; i < deck.cards.length; i++){
//				System.out.println(deck.cards[i]+ ",");
//			}
//		}
//	}
	
// 연습문제 7-2 main 메소드
	public static void main(String[] args) {

		SutdaDeck deck = new SutdaDeck();
	    
		System.out.println(deck.pick(0));
	    System.out.println(deck.pick());
	    deck.shuffle();
	
	    for(int i=0; i < deck.cards.length;i++)
	    	System.out.print(deck.cards[i]+",");
	    
	    System.out.println();
	    System.out.println(deck.pick(0));

	}

}
