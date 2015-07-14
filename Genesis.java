package car_maker;

public class Genesis extends Sedan {

	public int getPrice(){
		super.setPrice(5000);
		return super.getPrice();
	}
	
	public int getNumber(){
		super.setNumber(1);
		return super.getNumber();
	}

}
