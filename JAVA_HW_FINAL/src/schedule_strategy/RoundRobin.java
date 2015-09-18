package schedule_strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import main.Passenger;
import utils.Define;
import utils.ProgressTimeComparator;

public class RoundRobin extends StrategyFlow{

	// "티켓팅 진행 시간"을 기준으로 정렬되는 priority queue 타입의 티켓 대기 큐.
	private Comparator<Passenger> progressTimeComparator = new ProgressTimeComparator();
	private PriorityQueue<Passenger> ticketWaitQueue = 
			new PriorityQueue<Passenger>(Define.TOTAL_NUMBER_OF_PASSENGERS, progressTimeComparator);

	
	@Override
	protected void checkIfPassengerAppear(ArrayList<Passenger> passengerList) {
		
		// 직전 시각에서 담긴 티켓 대기 큐를 clear.
		if (ticketWaitQueue.size() > 0) {
			ticketWaitQueue.clear();
		}
		
		// 승객 명단을 읽어, 티켓 창구에 도착했으나 티켓 없는 승객을, 티켓 대기 큐에 인큐.
		for (int i = 0; i < passengerList.size(); i++) {
				
			Passenger passenger = passengerList.get(i);
				
			if ((passenger.arrivedAtTicketBox()) && (passenger.hasTicket() == false)){				
				ticketWaitQueue.add(passenger);
			}
		}
	}

	
	@Override
	protected void ticketerProcess() {

		// 티켓 대기 큐에 기다리는 사람 있으면, 티켓 창구의 업무를 중단시키고, 티켓 대기 큐에서 poll된 사람을 발권 처리 시작 or 재개.
		for (int n = 0; n < ticketer.length; n++){

			if (ticketWaitQueue.size() > 0) {
				
				Passenger passenger = ticketWaitQueue.poll();
				
// 처리되는 고객들 순서를 화면 출력.
//				System.out.println("시각 = " + clock.getTime() + ", 티켓팅 처리되는 고객 id = " + passenger.getId());
			
				if (ticketer[n].isBusy()){
					ticketer[n].stopIssue();					
				}
					
				if (passenger.getTicketingStartFlag()){
					ticketer[n].resumeIssue(passenger);						
				} else {
					ticketer[n].startIssue(passenger);
				}
			}		
		}
	}

}