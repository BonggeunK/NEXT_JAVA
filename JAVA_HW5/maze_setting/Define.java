package maze_setting;

public class Define {

	public static final int WALL = 1;
	public static final int PATH = 0;
	public static final int VISIT = 1;
	public static final int NOT_VISIT = 0;
	public static final int MAX_ROW = 10;
	public static final int MAX_COL = 10;
	public static final int CAPACITY = MAX_ROW * MAX_COL;
	public static final String FILL = "國 ";
	public static final String BLANK = "口 ";
	
	public static final int NORTH = 0;
	
	public static final int NORTHEAST_8 = 1;
	public static final int EAST_8 = 2;
	public static final int SOUTHEAST_8 = 3;
	public static final int SOUTH_8 = 4;
	public static final int SOUTHWEST_8 = 5;
	public static final int WEST_8 = 6;
	public static final int NORTHWEST_8 = 7;

	public static final int EAST_4 = 1;
	public static final int SOUTH_4 = 2;
	public static final int WEST_4 = 3;
	
}
