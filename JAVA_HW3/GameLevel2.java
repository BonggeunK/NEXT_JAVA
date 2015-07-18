package gameleveling;

public class GameLevel2 extends GameLevel {

	private static GameLevel2 instance = new GameLevel2();
	
	private GameLevel2(){}
	
	public static GameLevel2 getLevel(){
		return instance;
	}
		
	
	@Override
	protected void simpleAttack() {
		System.out.println("메롱~메롱~");
	}

	@Override
	protected void turnAttack() {
		System.out.println("돌려차기 씽~");
	}

	@Override
	protected void flyingAttack() {
		System.out.println("이건 못하지롱~");
	}

}
