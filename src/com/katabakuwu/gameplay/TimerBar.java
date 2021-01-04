package com.katabakuwu.gameplay;

import java.awt.Color;

import javax.swing.JProgressBar;

/**
 * Timer Bar
 * 
 * @author Ryan Garnet Andrianto
 */
public class TimerBar extends JProgressBar {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	private int value;
	private int max_value;
	/**
	 * By default, the decrement speed is 1/second
	 */
	private int decrementSpeed = 1;
	private int x, y, width, height;
	
	public TimerBar(int value, int max_value, int x, int y, int width, int height) {
		this.value = value;
		this.max_value = max_value;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.YELLOW);
		updateBarValue();
		setBounds(this.x, this.y, this.width, this.height);
		
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					decrementValue();
					updateBarValue();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// Do nothing
					}
				}
			}
		};
		thread.start();
	}
	
	/**
	 * Set progress bar value.
	 * @param value New value
	 */
	public void setBarValue(int value) {
		this.value = value;
	}
	
	/**
	 * Decrement progress bar value.
	 */
	public void decrementValue() {
		setBarValue((this.value > this.decrementSpeed) ? (this.value - this.decrementSpeed) : (0));
	}
	
	/**
	 * Update progress bar value.
	 */
	public void updateBarValue() {
		int barValue = (this.value)*(100)/(this.max_value);
		setValue(barValue);
	}
}
