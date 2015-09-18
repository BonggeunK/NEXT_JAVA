package utils;

import java.util.Comparator;

import main.Passenger;

public class RemainTimeComparator implements Comparator<Passenger>{

	@Override
	public int compare(Passenger p1, Passenger p2) {
		
		if (p1.getTicketingRemainTime() < p2.getTicketingRemainTime())
			return -1;
		else if (p1.getTicketingRemainTime() > p2.getTicketingRemainTime())
			return 1;
		else
			return 0;
	}
	
}