package com.katabakuwu;

import java.awt.Color;

import javax.swing.JProgressBar;

/**
 * HealthBar class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class HealthBar extends JProgressBar {
	private int value;
	private int x, y, width, height;
	
	/**
	 * Constructor
	 */
	public HealthBar(int initialValue, int x, int y, int width, int height) {
		value = initialValue;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setBackground(Color.LIGHT_GRAY);
		setForeground(new Color(51, 204, 0));
		setBarValue(initialValue);
		setBounds(this.x, this.y, this.width, this.height);
	}
	
	/**
	 * Set value
	 */
	public void setBarValue(int value) {
		this.value = value;
		setValue(this.value);
	}
}
