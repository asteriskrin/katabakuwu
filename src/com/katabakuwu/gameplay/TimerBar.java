package com.katabakuwu.gameplay;

import java.awt.Color;

import javax.swing.JProgressBar;

import com.katabakuwu.data.*;

/**
 * Timer Bar
 * 
 * @author Ryan Garnet Andrianto
 * @author Farhan Arifandi
 */
public class TimerBar extends JProgressBar {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer;
	/**
	 * By default, the decrement speed is 1/second
	 */
	private int decrementSpeed = 1;
	private int x, y, width, height;
	
	public TimerBar(Timer timer, int x, int y, int width, int height) {
		this.timer = timer;
		this.x = x;
		this.y = y;
		this.width = width-20;
		this.height = height;
		
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.YELLOW);
		timer.setBar(this);
		timer.updateProgressBar();
		setBounds(this.x, this.y, this.width, this.height);
		
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					timer.decrementValue();
					timer.updateProgressBar();
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
}
