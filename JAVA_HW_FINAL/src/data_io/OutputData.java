package data_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.Passenger;

public class OutputData {

	public void writeData(String fileName, ArrayList<Passenger> passengerList) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			
			bw.write("Id,Name,ArrivalAtTicketBox,WaitForTicketing,TicketingTime,WairForTrain,Departure,Arrival,ArrivalTime\n");
			
			int totalWaitForTicketing = 0;
			
			for (int i = 0; i < passengerList.size(); i++){
				Passenger passenger = passengerList.get(i);
				String str = passenger.getId() + "," + passenger.getName() + ","
							+ passenger.getArrivalTimeAtTicketBox() + ","
							+ passenger.getWaitingTimeInTicketing() + ","
							+ passenger.getTicketingTime() + ","
							+ passenger.getWaitingTimeOnPlatform() + ","
							+ passenger.getDeparture() + ","
							+ passenger.getArrival() + ","
							+ passenger.getArrivalTime() + "\n";
				bw.write(str);
				
				totalWaitForTicketing += passenger.getWaitingTimeInTicketing();
			}
			
			bw.write(", ,TotalWaitingForTicket,"+ totalWaitForTicketing + ", , , , , \n");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	
	
}
