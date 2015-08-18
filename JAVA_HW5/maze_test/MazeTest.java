package maze_test;

import java.io.IOException;

import maze_setting.DrawMaze;
import maze_setting.FindPath;

public class MazeTest {

	public static void main(String[] args) throws IOException {
		
		DrawMaze maze = new DrawMaze();
		
		maze.Draw();
		
		FindPath path = new FindPath();
		path.pathFind();
				
	}

}
