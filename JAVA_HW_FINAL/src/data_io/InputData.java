package data_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.Passenger;

public class InputData {

	private String seperator = ",";
	private String line = "";
	private String[] passengerInfo;
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	
	public void readData(String passengerFile) {
	
		BufferedReader br = null;	
		
		try {

			br = new BufferedReader(new FileReader(passengerFile));
			
			while ((line = br.readLine()) != null){

				passengerInfo = line.split(seperator);

				if (passengerInfo.length == 7){
				
					Passenger passenger = new Passenger(passengerInfo[0], passengerInfo[1], passengerInfo[2],
											passengerInfo[3], passengerInfo[4], passengerInfo[5], passengerInfo[6]);
				
					passengerList.add(passenger);
				}								
			}			
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}
		
}
