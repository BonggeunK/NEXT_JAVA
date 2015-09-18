package schedule_strategy;

import java.util.ArrayList;

import main.Clock;
import main.Passenger;
import main.Ticketer;
import schedule_common_process.PassengerStatusCheck;
import schedule_common_process.TrainProcess;
import utils.Define;
import utils.MyQueue;

public abstract class StrategyFlow {

	Clock clock = Clock.getInstance();
	Ticketer[] ticketer = new Ticketer[Define.NUMBER_OF_TICKET_BOX];
	MyQueue trainWaitQueue = new MyQueue();
	
	/* ****** 스케줄 메소드 ***** */
	public final ArrayList<Passenger> schedule(ArrayList<Passenger> passengerList){
		
		/* 티켓팅 창구 생성 */
		for (int i = 0; i < Define.NUMBER_OF_TICKET_BOX; i++){
			ticketer[i] = new Ticketer();
		}
		
		/* 스케줄링 프로세스 */
		for (int t = 0; t < Define.MAX__CLOCK_TIME; t++){

			// 승객 정보 확인.
			PassengerStatusCheck psc = new PassengerStatusCheck();		
			int arrivedPassenger = psc.checkStatus(passengerList, trainWaitQueue);
		
			// 모든 승객이 목적지에 도착하면 스케줄 프로세스 종료
			if (arrivedPassenger == Define.TOTAL_NUMBER_OF_PASSENGERS) {
				break;
			}

			// 티켓 창구에 나타난 승객 확인.(구현 필요)
			checkIfPassengerAppear(passengerList);
			
			// 스케줄링 정책에 따라 티켓 창구 처리.(구현 필요)
			ticketerProcess();	
			
			// 열차 출발 프로세스
			TrainProcess tp = new TrainProcess();
			tp.Depart(trainWaitQueue);
			
			// 현재 시각 +1
			clock.timeFlows();
		}
		
		return passengerList;
	}
	
	
	protected abstract void checkIfPassengerAppear(ArrayList<Passenger> passengerList);
	
	protected abstract void ticketerProcess();
	

	public String toString(){
		return this.getClass().getName();
	}
	
}