package schedule_common_process;

import main.Clock;
import main.Passenger;
import main.Train;
import utils.Define;
import utils.MyQueue;

public class TrainProcess {

	public void Depart(MyQueue trainWaitQueue){
		
		Clock clock = Clock.getInstance();
		
		// 열차 출발 시각인 경우, 열차를 생성해서 열차 대기 큐에 있는 승객을 모두 탑승시킴.
		if (clock.getTime() % Define.TRAIN_DEPART_INTERVAL == 0){
					
			Train train = new Train();

			while (trainWaitQueue.getSize() > 0){
				Passenger passenger = trainWaitQueue.poll();
				train.onBoard(passenger);
			}
		}
	}
	
}
