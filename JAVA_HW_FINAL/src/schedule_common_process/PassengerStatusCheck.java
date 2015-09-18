package schedule_common_process;

import java.util.ArrayList;

import main.Clock;
import main.Passenger;
import utils.MyQueue;

public class PassengerStatusCheck {


	public int checkStatus(ArrayList<Passenger> passengerList, MyQueue trainWaitQueue) {
		
		int arrivedPassenger = 0;
		
		// 승객 명단 순서대로 승객 정보 확인.
		for (int i = 0; i < passengerList.size(); i++) {
		
			Passenger passenger = passengerList.get(i);
					
			// 티켓이 있고 탑승 안한 승객은 열차 대기 큐에 인큐.
			if (passenger.hasTicket() && (passenger.isOnBoard() == false)){
				trainWaitQueue.add(passenger);
			}
			
			// 목적지 도착한 승객인지 확인.
			if (passenger.hasArrived()){
				arrivedPassenger++;
			}
			
			// waiting 시간 계산.
			passenger.updateInfo();
				
			// 티켓 창구에 도착했으면, 창구에 도착함 표시.
			Clock clock = Clock.getInstance();
			if ((passenger.arrivedAtTicketBox() == false) && (passenger.getArrivalTimeAtTicketBox() == clock.getTime())) {
				passenger.setArrivalAtTicketBoxFlag(true);
			}			
		}
		
		return arrivedPassenger;
	}

	
}
