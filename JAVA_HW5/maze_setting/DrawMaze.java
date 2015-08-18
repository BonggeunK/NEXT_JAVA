package maze_setting;

public class DrawMaze {

	private StringBuffer buffer = new StringBuffer();
	
	public void Draw(){

		System.out.println("  0  1 2  3 4 5  6 7  8 9");
		
		for (int i = 0; i < Define.MAX_ROW; i++){
			buffer.append(String.valueOf(i)+" ");
			
			for (int j = 0; j < Define.MAX_COL; j++){
				MazeMap maze = MazeMap.getMaze();

				if (maze.getMap(i, j) == Define.WALL){
					buffer.append(Define.FILL);
				}
				else{
					buffer.append(Define.BLANK);
				}
			}
			buffer.append("\n");
		}
		
		System.out.println(buffer);

	}
	
}
