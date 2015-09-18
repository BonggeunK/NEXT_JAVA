package main;

public class Passenger {

	/* 입력 데이터로 읽어들이는 속성 */
	private String id;			// 승객 아이디
	private String name;		// 승객 이름
	private int arrivalTimeAtTicketBox;	// 티켓 창구 도착 시각
	private int ticketingTime;			// 티켓팅 소요 시간
	private String departure;			// 출발지
	private String arrival;				// 도착지
	private int movingTime;				// 열차 소요 시간
	
	/* 계산되는 속성 */
	private int waitingTimeInTicketing;	// 티켓팅 대기 시간
	private int ticketingStartTime;		// 티켓팅 시작 시각
	private int ticketingProgressTime;  // 티켓팅 진행된 누적 시간
	private int ticketingRemainTime;	// 티켓팅 완료까지 남은 시간
	private int issuingTime;			// 발권 시각
	private int waitingTimeOnPlatform; 	// 열차 대기 시간
	private int departingTime;			// 열차 출발 시각
	private int arrivalTime;			// 열차 도착 시각

	private boolean arrivalAtTicketBoxFlag;
	private boolean ticketingStartFlag;
	private boolean ticketingStopFlag;
	private boolean ticketingEndFlag;
	private boolean onBoardFlag;
	private boolean arrivalFlag;

	
	public Passenger (String id, String name, String arrivalAtTicketBox, 
				String ticketingTime, String departure, String arrival, String movingTime){
		this.id = id;
		this.name = name;
		this.arrivalTimeAtTicketBox = Integer.parseInt(arrivalAtTicketBox);
		this.ticketingTime = Integer.parseInt(ticketingTime);
		this.departure = departure;
		this.arrival = arrival;
		this.movingTime = Integer.parseInt(movingTime);
		this.ticketingRemainTime = this.ticketingTime;
	}
	
	public int getTicketingTime(){
		return ticketingTime;
	}
	
	public String getId(){
		return id;
	}
		
	
	public boolean isTicketingStart(){
		return ticketingStartFlag;
	}	
	
	public boolean hasTicket(){
		return ticketingEndFlag;
	}	
	
	public boolean isOnBoard(){
		return onBoardFlag;
	}
	
	public boolean hasArrived(){
	
		if (onBoardFlag) {		
			Clock clock = Clock.getInstance();
			
			int time = departingTime + movingTime;
			
			if (time == clock.getTime()){
				arrivalTime = time;
				arrivalFlag = true;
			}
		}
		
		return arrivalFlag;
	}
	
	
	public void updateInfo(){
				
		if ( ((arrivalAtTicketBoxFlag) && (ticketingStartFlag == false)) || 
				((ticketingStartFlag) && (ticketingStopFlag) && (ticketingEndFlag == false)) ) {
			waitingTimeInTicketing++;
		}
		
		if ((ticketingEndFlag) && (onBoardFlag) && (waitingTimeOnPlatform == 0)){
			waitingTimeOnPlatform = departingTime - issuingTime;
		}
	}
	
	
	
	public void setTicketingStartFlag(boolean ticektingStartFlag) {
		this.ticketingStartFlag = ticektingStartFlag;
	}

	public void setTicketingEndFlag(boolean ticketingEndFlag) {
		this.ticketingEndFlag = ticketingEndFlag;
	}

	public void setOnBoardFlag(boolean onBoardFlag) {
		this.onBoardFlag = onBoardFlag;
	}

	public int getMovingTime() {
		return movingTime;
	}

	public int getArrivalTimeAtTicketBox() {
		return arrivalTimeAtTicketBox;
	}

	public int getWaitingTimeInTicketing() {
		return waitingTimeInTicketing;
	}

	public int getIssuingTime() {
		return issuingTime;
	}
	public void setIssuingTime(int issuingTime) {
		this.issuingTime = issuingTime;
	}

	public int getWaitingTimeOnPlatform() {
		return waitingTimeOnPlatform;
	}

	public int getDepartingTime() {
		return departingTime;
	}
	public void setDepartingTime(int departingTime) {
		this.departingTime = departingTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getTicketingStartTime() {
		return ticketingStartTime;
	}

	public void setTicketingStartTime(int ticketingStartTime) {
		this.ticketingStartTime = ticketingStartTime;
	}

	public String getName() {
		return name;
	}

	public String getDeparture() {
		return departure;
	}

	public String getArrival() {
		return arrival;
	}

	public int getTicketingRemainTime() {
		return ticketingRemainTime;
	}
	public void reduceTicketingRemainTime(){
		ticketingRemainTime--;
	}

	public boolean isTicketingStopped() {
		return ticketingStopFlag;
	}
	public void setTicketingStopFlag(boolean ticketingStopFlag) {
		this.ticketingStopFlag = ticketingStopFlag;
	}

	public int getTicketingProgressTime() {
		return ticketingProgressTime;
	}
	public void increaseTicketingProgressTime() {
		ticketingProgressTime++;
	}

	public boolean arrivedAtTicketBox(){
		return arrivalAtTicketBoxFlag;
	}
	public void setArrivalAtTicketBoxFlag(boolean arrivalAtTicketBoxFlag) {
		this.arrivalAtTicketBoxFlag = arrivalAtTicketBoxFlag;
	}

	public boolean getTicketingStartFlag(){
		return ticketingStartFlag;
	}
	public boolean getTicketingStopFlag(){
		return ticketingStopFlag;
	}
	
	
}
