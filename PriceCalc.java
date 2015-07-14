package car_maker;

public class PriceCalc {

	private Sedan[] car = {new Sonata(), new Grandeur(), new Genesis()};
	public int result = 0;
		
	public int Sum(){
		
		for (int i = 0; i < 3; i++){
			result += car[i].getPrice()*car[i].getNumber();
		}
				
		return result;
	}
	
}
