package utils;

import java.util.Comparator;

import main.Passenger;

public class ProgressTimeComparator implements Comparator<Passenger> {

	@Override
	public int compare(Passenger p1, Passenger p2) {

		if (p1.getTicketingProgressTime() < p2.getTicketingProgressTime()){
			return -1;
		} 
		else if (p1.getTicketingProgressTime() > p2.getTicketingProgressTime()) {
			return 1;
		} 
		else { // 티켓팅 진행된 시간이 동일한 경우, 티켓 창구에 일찍 도착한 사람이 우선순위 높음.
		
			if (p1.getArrivalTimeAtTicketBox() < p2.getArrivalTimeAtTicketBox()){
				return -1;
			} else if (p1.getArrivalTimeAtTicketBox() > p2.getArrivalTimeAtTicketBox()) {
				return 1;
				
			} else { // 티켓 창구에 도착한 시각이 동일한 경우, id가 낮은 사람이 우선순위 높음.
				
				if (Integer.parseInt(p1.getId()) < Integer.parseInt(p2.getId())){
					return -1;
				} else {
					return 1;
				}
			}
		}
			
	}
	
}
