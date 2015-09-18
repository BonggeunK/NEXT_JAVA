package main;

public class Train {
	
	public void onBoard(Passenger passenger){
		
		if (passenger != null) {
		
			Clock clock = Clock.getInstance();
		
			passenger.setDepartingTime(clock.getTime());
			passenger.setOnBoardFlag(true);
		}
	}
	
}
