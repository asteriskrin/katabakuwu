package com.katabakuwu.data;

/**
 * Timer class.
 * @author Ryan Garnet Andrianto
 *
 */
public class Timer {
	private int duration;
	private int maxDuration;

	/**
	 * Constructor
	 * 
	 * @param duration
	 */
	public Timer(int duration) {
		this.duration = duration;
		this.maxDuration = duration;
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
	
	/**
	 * Get max duration
	 * 
	 * @return maxDuration in seconds
	 */
	public int getMaxDuration() {
		return this.maxDuration;
	}
	
	/**
	 * Set max duration
	 * 
	 * @param maxDuration Duration in seconds
	 */
	public void setMaxDuration(int duration) {
		this.maxDuration = duration;
	}
}
