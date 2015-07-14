package car_maker;

public class CarCompany {

	private static CarCompany instance = new CarCompany();
	private int totalPrice = 0;
	
	private CarCompany(){}
	
	public static CarCompany getInstance(){
		
		if (instance == null){
			instance = new CarCompany();
		}
		
		return instance;
	}
	
	public int getTotalPrice(){
		PriceCalc priceSum = new PriceCalc();
		totalPrice += priceSum.Sum();
		return totalPrice;
	}
	
}
