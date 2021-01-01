package com.katabakuwu.data;

import javax.swing.JProgressBar;

/**
 * Hint class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Hint {
	private float value;
	
	/**
	 * Constructor
	 * @param value Value
	 */
	public Hint(float value) {
		this.value = value;
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
	 * Update progress bar
	 * 
	 * @param progressBar
	 */
	public void updateProgressBar(JProgressBar progressBar) {
		progressBar.setValue((int) this.value);
	}
}
