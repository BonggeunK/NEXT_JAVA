package maze_setting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FindPath {

	private int maxDirection;
	public static boolean pathFound = false;
	
	public void setMaxDirection(int maxDirection) {
		this.maxDirection = maxDirection;
	}
	
	public void pathFind() throws IOException{

		// 미로 불러오기
		MazeMap maze = MazeMap.getMaze();
		Position start = maze.getStart();
		Position exit = maze.getExit();
		
		// 방문 여부 확인하는 맵을 생성해서 초기화
		MarkMap mark = new MarkMap();
		mark.initMap();
		mark.setMark(start.getXpos(), start.getYpos()); // 시작점을 방문한 것으로 체크

		// 환경 파일 읽어서 탐색 방향 설정
		FileInputStream fis = new FileInputStream("MazeStrategy.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String srchDir = prop.getProperty("SearchDirection");

		if (srchDir.equals("4")){
			this.setMaxDirection(4);			
		} else {
			this.setMaxDirection(8);
		}
		start.setDirNum(Define.NORTH, maxDirection); // 시작 방향 초기화

		// 스택 생성 후 현재 위치를 푸쉬
		Stack stack = new Stack();
		stack.push(start);
		
		// 경로 탐색 시작
		while((stack.isEmpty() == false) && (pathFound == false)){
			
			Position pos = stack.pop();
			
			while ((pos.getDirNum() < maxDirection) && (pathFound == false)){

				Position nextPos = new Position(pos.getXpos(), pos.getYpos());
				nextPos.movePosition(pos.getHoriz(), pos.getVert());

				int i = nextPos.getXpos();
				int j = nextPos.getYpos();
				
				if ((i == exit.getXpos()) && (j == exit.getYpos())){
					stack.push(pos);
					pathFound = true;
					
				} else if ((maze.getMap(i, j) == Define.PATH) && (mark.getMark(i, j) == Define.NOT_VISIT)){
					pos.setDirNum(pos.getDirNum() + 1, maxDirection);
					stack.push(pos);					
					mark.setMark(i, j);
					
					pos = nextPos;
					pos.setDirNum(Define.NORTH, maxDirection);
					
				} else {
					pos.setDirNum(pos.getDirNum() + 1, maxDirection);
				}
			}
		}
		
		PrintPath print = new PrintPath();
		print.pathPrint(pathFound, stack);
		
	}
	
}
