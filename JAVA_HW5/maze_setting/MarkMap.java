package maze_setting;

public class MarkMap {

	private int[][] map = new int[Define.MAX_ROW][Define.MAX_COL];
	
	public void initMap(){
		
		for (int i = 0; i < Define.MAX_ROW; i++){
			for (int j = 0; j < Define.MAX_COL; j++){
				map[i][j] = Define.NOT_VISIT;
			}
		}
	}
	
	public void setMark(int i, int j){
		map[i][j] = Define.VISIT;
	}
	
	public int getMark(int i, int j){
		return map[i][j];
	}

}
