package maze_setting;

public class MazeMap {

	private int[][] map = {
			{Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL},
			{Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.WALL},
			{Define.WALL, Define.PATH, Define.PATH, Define.PATH, Define.WALL, Define.PATH, Define.PATH, Define.PATH, Define.PATH, Define.WALL},
			{Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.PATH, Define.PATH, Define.WALL, Define.PATH, Define.WALL, Define.WALL},
			{Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL},
			{Define.WALL, Define.WALL, Define.PATH, Define.PATH, Define.WALL, Define.PATH, Define.PATH, Define.PATH, Define.PATH, Define.WALL},
			{Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.WALL},
			{Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.PATH, Define.PATH, Define.PATH, Define.PATH, Define.WALL},
			{Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.PATH, Define.WALL, Define.WALL, Define.WALL, Define.PATH, Define.WALL},
			{Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL, Define.WALL}
	};
	
	private Position Start = new Position(1, 1);
	private Position Exit = new Position(8, 8);
	
	private static MazeMap instance = new MazeMap();
	
	private MazeMap(){}
	
	public static MazeMap getMaze(){
		
		if (instance == null){
			instance = new MazeMap();
		}
		
		return instance;
	}

	public int getMap(int xPos, int yPos){
		
		if ((xPos < Define.MAX_ROW) && (yPos < Define.MAX_COL)){
			return map[xPos][yPos];
		}
		return Define.WALL;
	}

	public Position getStart(){
		return Start;
	}
	
	public Position getExit(){
		return Exit;
	}
	
}
