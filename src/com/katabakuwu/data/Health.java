package com.katabakuwu.data;

import javax.swing.JProgressBar;

/**
 * Health class.
 * @author Ryan Garnet Andrianto
 * @author FARHAN
 */
public class Health {

	private JProgressBar bar;
	private float value;
	
	/**
	 * Constructor
	 */
	public Health() {
		this.value = (float) 100.0;
	}
	
	/**
	 * Set hint progress bar.
	 * 
	 * @param bar
	 */
	public void setBar(JProgressBar bar) {
		this.bar = bar;
	}
	
	/**
	 * Get health.
	 * 
	 * @return Health
	 */
	public float getValue() {
		return this.value;
	}
	
	/**
	 * Set health.
	 * 
	 * @param value Health
	 */
	public void setValue(float value) {
		this.value = value;
	}
	
	/**
	 * Reduce value
	 * 
	 * @param value Value
	 */
	public void reduceValue(float value) {
		setValue(this.value - value);
	}
	
	/**
	 * Increase value
	 * 
	 * @param value Value
	 */
	public void increaseValue(float value) {
		setValue(this.value + value);
		if(this.value > 100) this.value = 100;
	}
	
	/**
	 * Update progress bar
	 */
	public void updateProgressBar() {
		bar.setValue((int) this.value);
	}
}
