package maze_setting;

public class PrintPath {

	public void pathPrint(boolean pathFound, Stack stack){
	
		Position exit = MazeMap.getMaze().getExit();
		
		if (pathFound == true){
			
			for (int i = 0; i <= stack.getTop(); i++){
				
				Position p = stack.getStack(i);
				int x = p.getXpos();
				int y = p.getYpos();
				
				System.out.println("["+ x + ", " + y +"], ");
			}
			System.out.println("["+ exit.getXpos()+", "+exit.getYpos()+"]");

		} else{
			System.out.println("경로가 없습니다.");
		}
				
	}
		
}
