package com.katabakuwu.data;

import javax.swing.JProgressBar;

/**
 * Timer class.
 * @author Ryan Garnet Andrianto
 * @author FARHAN
 */
public class Timer {
	private int duration;
	private int maxDuration;
	private JProgressBar bar;

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
	 * Set timer progress bar.
	 * 
	 * @param bar
	 */
	public void setBar(JProgressBar bar) {
		this.bar = bar;
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
	
	/**
	 * Increase duration
	 * 
	 * @param value Value
	 */
	public void increaseDuration(int value) {
		setDuration(this.duration + value);
		updateProgressBar();
	}
	
	/**
	 * Update progress bar
	 */
	public void updateProgressBar() {
		int barValue = (this.duration)*(100)/(this.maxDuration);
		if(barValue > 100) barValue = 100;
		bar.setValue(barValue);
	}
}
