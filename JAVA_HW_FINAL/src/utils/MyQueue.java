package utils;

import java.util.LinkedList;
import java.util.Queue;

import main.Passenger;

public class MyQueue {

	private Queue<Passenger> passengerList = new LinkedList<Passenger>();
	
	public void add(Passenger passenger){
		passengerList.offer(passenger);
	}
	
	public Passenger poll(){
		return passengerList.poll();
	}
	
	public int getSize(){
		if (passengerList == null)
			return 0;
		
		return passengerList.size();
	}
	
}
