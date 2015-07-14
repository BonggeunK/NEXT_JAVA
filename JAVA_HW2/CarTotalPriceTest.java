package car_maker;

public class CarTotalPriceTest {

	public static void main(String[] args) {
		
		CarCompany hyundai = CarCompany.getInstance();
		
		System.out.println("자동차 회사가 가진 차의 전체 가격 =");
		System.out.println(hyundai.getTotalPrice());
		

	}

}
