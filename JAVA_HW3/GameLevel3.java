package gameleveling;

public class GameLevel3 extends GameLevel {

	private static GameLevel3 instance = new GameLevel3();
	
	private GameLevel3(){}
	
	public static GameLevel3 getLevel(){
		return instance;
	}
	
	
	@Override
	protected void simpleAttack() {
		System.out.println("메롱~메롱~메롱~");
	}

	@Override
	protected void turnAttack() {
		System.out.println("뒤돌려차기~ 앞돌려차기~");
	}

	@Override
	protected void flyingAttack() {
		System.out.println("날라차기 휙~");
	}

}
