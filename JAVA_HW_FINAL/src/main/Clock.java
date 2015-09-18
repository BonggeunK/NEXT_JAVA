package main;

public class Clock {

	private static Clock instance = new Clock();
	private int time = 0;
	
	private Clock(){}
	
	public static Clock getInstance(){
		if (instance == null)
			instance = new Clock();
		return instance;
	}	
	
	public void timeFlows(){
		time++;
	}
	
	public int getTime(){
		return time;
	}
	
}
