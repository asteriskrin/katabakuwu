package com.katabakuwu.data;

import java.awt.Color;
import javax.swing.*;;

/**
 * Hint class.
 * 
 * @author Ryan Garnet Andrianto
 * @author FARHAN
 */
public class Hint {
	private JProgressBar bar;
	private JButton button;
	private float value;
	private float maxValue;
	
	/**
	 * Constructor
	 * @param value Value
	 */
	public Hint(float value) {
		this.value = value;
		this.maxValue = value;
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
	 * Set hint progress bar.
	 * 
	 * @param bar
	 */
	public void setButton(JButton button) {
		this.button = button;
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
	 * Get maxValue.
	 * 
	 * @return maxValue
	 */
	public float getMaxValue() {
		return maxValue;
	}
	
	/**
	 * Set maxValue
	 * @param maxValue
	 */
	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	
	/**
	 * Reduce value
	 * 
	 * @param value Value
	 */
	public void reduceValue(float value) {
		float newValue =  this.value - value;
		if(newValue < 0.0) newValue = (float) 0.0;
		setValue(newValue);
		updateProgressBar();
	}
	
	/**
	 * Increase value
	 * 
	 * @param value Value
	 */
	public void increaseValue(float value) {
		float newValue =  this.value + value;
		if(newValue > getMaxValue()) newValue = getMaxValue();
		setValue(newValue);
		updateProgressBar();
	}
	
	/**
	 * Update progress bar
	 */
	public void updateProgressBar() {
		bar.setValue((int) this.value);
	}
	
	/**
	 * Enable button
	 */
	public void enableButton() {
		this.button.setEnabled(true);
		this.button.setForeground(Color.WHITE);
		this.button.setBackground(Color.MAGENTA);
	}
	
	/**
	 * Disable button
	 */
	public void disableButton() {
		this.button.setEnabled(false);
		this.button.setBackground(Color.LIGHT_GRAY);
	}
}
