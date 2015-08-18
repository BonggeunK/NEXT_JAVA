package maze_setting;

public class Position {

	private int xPos;
	private int yPos;
	private int dirNum;
	private int vert = 0;	// 다음 번 위치로 나아갈 세로 방향
	private int horiz = 0;	// 다음 번 위치로 나아갈 가로 방향

	public Position(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public int getXpos() {
		return xPos;
	}
	public int getYpos() {
		return yPos;
	}

	public void movePosition(int xPos, int yPos){
		this.xPos += xPos;
		this.yPos += yPos;
	}

	public int getVert() {
		return vert;
	}
	public int getHoriz() {
		return horiz;
	}
	
	private void setDirection(int horiz, int vert){
		this.horiz = horiz;
		this.vert = vert;
	}

	
	public int getDirNum(){
		return dirNum;
	}
	public void setDirNum(int dirNum, int maxDirection){

		this.dirNum = dirNum;
		
		if (maxDirection == 4){
			this.setFourDirection(dirNum);
		} else if (maxDirection == 8){
			this.setEightDirection(dirNum);
		}
	}
	
	public void setFourDirection(int dirNum){
		
		if (dirNum == Define.NORTH){
			this.setDirection(0, -1);
		} else if (dirNum == Define.EAST_4){
			this.setDirection(1, 0);
		} else if (dirNum == Define.SOUTH_4){
			this.setDirection(0, 1);
		} else if (dirNum == Define.WEST_4){
			this.setDirection(-1, 0);
		}
	}	

	public void setEightDirection(int dirNum){
		
		if (dirNum == Define.NORTH){
			this.setDirection(0, -1);
		} else if (dirNum == Define.NORTHEAST_8){
			this.setDirection(1, -1);
		} else if (dirNum == Define.EAST_8){
			this.setDirection(1, 0);
		} else if (dirNum == Define.SOUTHEAST_8){
			this.setDirection(1, 1);
		} else if (dirNum == Define.SOUTH_8){
			this.setDirection(0, 1);
		} else if (dirNum == Define.SOUTHWEST_8){
			this.setDirection(-1, 1);
		} else if (dirNum == Define.WEST_8){
			this.setDirection(-1, 0);
		} else if (dirNum == Define.NORTHWEST_8){
			this.setDirection(-1, -1);
		}
	}
	
}
