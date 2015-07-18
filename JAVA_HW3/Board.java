package gameleveling;

public class Board {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		
		GameLevel level1 = GameLevel1.getLevel();
		GameLevel level2 = GameLevel2.getLevel();
		GameLevel level3 = GameLevel3.getLevel();
		
		player1.upgradeLevel(level1);
		player1.attack();
		
		player1.upgradeLevel(level2);
		player1.attack();
		
		player1.upgradeLevel(level3);
		player1.attack();

	}

}
