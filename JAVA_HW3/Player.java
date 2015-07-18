package gameleveling;

import java.util.ArrayList;

public class Player {
	
	private int level;
	
	ArrayList<GameLevel> levelList = new ArrayList<GameLevel>();
	
	public void upgradeLevel(GameLevel gameLevel){

		levelList.add(gameLevel);
		
		level = levelList.size();
	}
	
	public GameLevel getGameLevel(){
		return levelList.get(level-1); // levelList의 인덱스는 0부터 시작.
	}
	
	public void attack(){
		System.out.println("현재 플레이어의 레벨 = " + level);
		this.getGameLevel().play();
	}
	
	
}
