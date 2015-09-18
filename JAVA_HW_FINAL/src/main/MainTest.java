package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import data_io.InputData;
import data_io.OutputData;
import main.Passenger;
import schedule_strategy.FIFO;
import schedule_strategy.RoundRobin;
import schedule_strategy.SJF;
import schedule_strategy.StrategyFlow;

public class MainTest {

	public static void main(String[] args) {

		// 승객 명단 읽기.
		InputData dataIn = new InputData();
		String fileName = "passenger_data.csv";		
		dataIn.readData(fileName);		
		
		// 스케줄링 정책 속성에 따라, 스케줄링 수행.
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("ScheduleStrategy.properties"));
			String strategy = prop.getProperty("Strategy");
			
			
			StrategyFlow scheduler = new FIFO(); // First In First Out 방식.
			
			if (strategy.equals("SJF")){ // Shortest Job First 방식.
				scheduler = new SJF();
			}
			else if (strategy.equals("RoundRobin")){ // Round Robin 방식.
				scheduler = new RoundRobin();
			}
			
			ArrayList<Passenger> scheduledPassengerList = scheduler.schedule(dataIn.getPassengerList());

			// 화면 출력.
			System.out.println(scheduler); 
			for (int i = 0; i < scheduledPassengerList.size(); i++){
				
				Passenger passenger = scheduledPassengerList.get(i);
				
				System.out.println("고객 id = " + passenger.getId() + " (티켓팅 소요 시간 = " + passenger.getTicketingTime()
								+ "), 티켓 창구 도착 시각 = " + passenger.getArrivalTimeAtTicketBox() + ", 티켓팅 시작 시각 = " + passenger.getTicketingStartTime()
								+ ", 발권 완료 시각 = " + passenger.getIssuingTime() + ", 티켓팅 대기 시간 = " + passenger.getWaitingTimeInTicketing()
								+ ", 열차 대기 시간 = " + passenger.getWaitingTimeOnPlatform() + ", 탑승 시각 = " + passenger.getDepartingTime()
								+ ", 도착 시각 = " + passenger.getArrivalTime() + ", 열차 소요 시간 = " + (passenger.getArrivalTime() - passenger.getDepartingTime()));
	
			}

			// 파일 출력.
			OutputData dataOut = new OutputData();
			String resultFileName = "passenger_data_scheduled_by_" + strategy + ".csv";
			dataOut.writeData(resultFileName, scheduledPassengerList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
