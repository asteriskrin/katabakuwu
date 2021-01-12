package com.katabakuwu.gameplay;

import java.awt.Color;

import javax.swing.JProgressBar;

import com.katabakuwu.data.*;

/**
 * HealthBar class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class HealthBar extends JProgressBar {

	private static final long serialVersionUID = 1L;
	private int value;
	private int x, y, width, height;
	
	/**
	 * Constructor
	 */
	public HealthBar(Health health, int x, int y, int width, int height) {
		value = (int) health.getValue();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setBackground(Color.LIGHT_GRAY);
		setForeground(new Color(51, 204, 0));
		setValue(this.value);
		setBounds(this.x, this.y, this.width, this.height);
	}
}
