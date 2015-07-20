// 연습문제 7-10, 7-11
package excercise_ch7;

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void setIsPowerOn(boolean onoff){
		this.isPowerOn = onoff;
	}
	public boolean getIsPowerOn(){
		return isPowerOn;
	}
	
	public void setChannel(int channel){
		if (channel < MIN_CHANNEL || channel > MAX_CHANNEL)
			System.out.println("채널 입력이 잘못되었습니다.");
		
		prevChannel = this.channel;
		this.channel = channel;
	}
	public int getChannel(){
		return channel;
	}
	
	public void setVolume(int volume){
		if (volume < MIN_VOLUME || volume > MAX_VOLUME)
			System.out.println("음량 입력이 잘못되었습니다.");
		
		this.volume = volume;
	}
	public int getVolume(){
		return volume;
	}
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
	}
}

public class Excercise7_10and7_11 {

	public static void main(String[] args) {
		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());

		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}

}
