package car_maker;

public class Grandeur extends Sedan{

	public int getPrice(){
		super.setPrice(4000);
		return super.getPrice();
	}
	
	public int getNumber(){
		super.setNumber(2);
		return super.getNumber();
	}
	
}
