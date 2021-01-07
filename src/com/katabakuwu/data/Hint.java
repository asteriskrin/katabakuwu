package com.katabakuwu.data;

import javax.swing.JProgressBar;

/**
 * Hint class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Hint {
	private JProgressBar bar;
	private float value;
	
	/**
	 * Constructor
	 * @param value Value
	 */
	public Hint(float value) {
		this.value = value;
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
	 * Get value.
	 * 
	 * @return Value
	 */
	public float getValue() {
		return this.value;
	}
	
	/**
	 * Set value
	 * @param value Value
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
		setValue(getValue() - value);
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
