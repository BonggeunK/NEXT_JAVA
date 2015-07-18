package gameleveling;

public class GameLevel1 extends GameLevel {

	private static GameLevel1 instance = new GameLevel1();
	
	private GameLevel1(){}
	
	public static GameLevel1 getLevel(){
		return instance;
	}
	
	
	@Override
	protected void simpleAttack() {
		System.out.println("메롱~");		
	}

	@Override
	protected void turnAttack() {
		System.out.println("못하지롱~");		
	}

	@Override
	protected void flyingAttack() {
		System.out.println("이것도 못하지롱~");
	}

}
