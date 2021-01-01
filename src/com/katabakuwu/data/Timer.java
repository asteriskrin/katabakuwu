package com.katabakuwu.data;

/**
 * Timer class.
 * @author Ryan Garnet Andrianto
 *
 */
public class Timer {
	private int duration;

	/**
	 * Constructor
	 * 
	 * @param duration
	 */
	public Timer(int duration) {
		this.duration = duration;
	}
	
	/**
	 * Get duration
	 * 
	 * @return Duration in seconds
	 */
	public int getDuration() {
		return this.duration;
	}
	
	/**
	 * Set duration
	 * 
	 * @param duration Duration in seconds
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
