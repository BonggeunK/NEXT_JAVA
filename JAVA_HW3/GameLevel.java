package gameleveling;

public abstract class GameLevel {

	protected abstract void simpleAttack();
	protected abstract void turnAttack();
	protected abstract void flyingAttack();
	
	protected final void play(){
		
		System.out.print("기본 공격: ");
		simpleAttack();
		
		System.out.print("특수 공격 1: ");
		turnAttack();
		
		System.out.print("특수 공격 2: ");
		flyingAttack();
	}

	
}
