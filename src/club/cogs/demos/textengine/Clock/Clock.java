package club.cogs.demos.textengine.Clock;

public class Clock {
	
	private static final int DEFAULT_MINUTE_INTERVAL = 1; //minutes
	private static final int MAX_MINUTES = 60;
	private static final int MAX_HOURS = 24;
	
	private int day, hours, minute, interval;
	
	private boolean blockTick = false;
	
	public Clock(int h, int m){
		this(h, m, DEFAULT_MINUTE_INTERVAL);
	}

	public Clock(int h, int m, int i) {
		this(0, h, m, i);
	}
	
	public Clock(int d, int h, int m, int i){
		
		this.day=d;
		this.hours = h;
		this.minute=m;
		this.interval = i;
	}
	
	public void tick(){
		if(!this.blockTick)
			this.passTime(this.interval);
		this.blockTick = false;
	}
	
	public void passTime(int minutes){ //in minutes
		this.minute += minutes;
		
		while(this.minute >= MAX_MINUTES){
			this.minute -= MAX_MINUTES;
			this.hours++;
		}
		
		while(this.hours >= MAX_HOURS){
			this.hours -= MAX_HOURS;
			this.day++;
		}
		
		this.blockTick = true;
	}

}
