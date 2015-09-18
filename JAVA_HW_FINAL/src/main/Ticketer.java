package main;

public class Ticketer {

	private int ticketingStart;
	private int ticketingTime;
	private Passenger customer = null;
	private boolean busyFlag = false;

	
	public boolean isBusy(){
		return busyFlag;
	}
	
	public Passenger getCustomer() {
		return customer;
	}

	/* 이하, FIFO, Shortest Job First 알고리즘에 적용되는 메소드들 */
	public void issueTicket(Passenger passenger){
		
		if (passenger == null) return;
		
		if (passenger.isTicketingStart() == false) {
		
			Clock clock = Clock.getInstance();
		
			customer = passenger;
			ticketingTime = passenger.getTicketingTime();
			passenger.setTicketingStartFlag(true);
			ticketingStart = clock.getTime();
			passenger.setTicketingStartTime(ticketingStart);
		
			busyFlag = true;
		}
	}
	
	
	public void checkIssueCompleted(){
		
		if (customer == null) return;
		
		if (customer.isTicketingStart()) {

			Clock clock = Clock.getInstance();
			
			int time = ticketingStart + ticketingTime;
			
			if (time > clock.getTime()){
				customer.reduceTicketingRemainTime();
			}
			if (time == clock.getTime()){
				customer.setIssuingTime(clock.getTime());
				customer.setTicketingEndFlag(true);

				busyFlag = false;
			}		
		}		
	}

	
	/* 이하, RoundRobin 알고리즘에서 사용되는 메소드들 */
	public void startIssue(Passenger passenger){
		
		if (passenger == null) return; 
		
		Clock clock = Clock.getInstance();
		
		customer = passenger;
		passenger.setTicketingStartFlag(true);
		ticketingStart = clock.getTime();
		passenger.setTicketingStartTime(ticketingStart);
		passenger.increaseTicketingProgressTime();

		if (customer.getTicketingRemainTime() > 1) {
			customer.reduceTicketingRemainTime();
		}
		else { // 티케팅 잔여 시간이 1인 경우, 다음 시각에서 티켓팅 완료되는 것으로 처리.
			customer.setIssuingTime(clock.getTime() + 1);
			customer.setTicketingEndFlag(true);
			customer.setTicketingStopFlag(false);
		}
		
		busyFlag = true;
	}
		
	public void stopIssue(){
		
		if (customer == null) return;
		
		if ((customer.getTicketingStartFlag()) 
				&& (customer.hasTicket() == false) 
				&& (customer.getTicketingStopFlag() == false)){

			customer.setTicketingStopFlag(true);
			
			busyFlag = false;
		}
	}
	
	public void resumeIssue(Passenger passenger){
		
		if (passenger == null) return;
		
		if (passenger.hasTicket() == false){

			Clock clock = Clock.getInstance();
			customer = passenger;
			customer.increaseTicketingProgressTime();
			
			if (customer.getTicketingRemainTime() > 1){
				customer.reduceTicketingRemainTime();
				customer.setTicketingStopFlag(false);				
			} 
			else { // 남은 티케팅 시간이 1인 경우, 바로 다음 시각에서 티켓팅 완료 처리.
				customer.setIssuingTime(clock.getTime() + 1);
				customer.setTicketingEndFlag(true);	
				customer.setTicketingStopFlag(false);
			}
		}
		
		busyFlag = true;
	}
	
}