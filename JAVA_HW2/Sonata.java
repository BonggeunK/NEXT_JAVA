package car_maker;

public class Sonata extends Sedan {
	
	public int getPrice(){
		super.setPrice(3000);
		return super.getPrice();
	}
	
	public int getNumber(){
		super.setNumber(3);
		return super.getNumber();
	}

}
