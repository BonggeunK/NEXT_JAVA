package schedule_strategy;

import java.util.ArrayList;

import main.Passenger;
import utils.MyQueue;

public class FIFO extends StrategyFlow {

	// 티켓 대기 큐
	private MyQueue ticketWaitQueue = new MyQueue();

	@Override
	protected void checkIfPassengerAppear(ArrayList<Passenger> passengerList) {

		// 승객 명단 순서대로 승객 정보 확인해서, 티켓 창구에 도착한 경우, 티켓 대기 큐에 인큐.
		for (int i = 0; i < passengerList.size(); i++) {
			
			Passenger passenger = passengerList.get(i);

			if (passenger.getArrivalTimeAtTicketBox() == clock.getTime()) {
				ticketWaitQueue.add(passenger);
			}			
		}
	}


	@Override
	protected void ticketerProcess() {
		
		// 각 티켓 창구의 발권 업무 끝났는지 확인하고, 비어 있는 티켓 창구가 있는데 티켓 대기 큐에 기다리는 사람 있으면, 발권 시작.
		for (int n = 0; n < ticketer.length; n++){
			
			ticketer[n].checkIssueCompleted();
			
			if ((ticketer[n].isBusy() == false) && (ticketWaitQueue.getSize() > 0)) {				
				Passenger passenger = ticketWaitQueue.poll();
				ticketer[n].issueTicket(passenger);
			}
		}
	}
	
}
