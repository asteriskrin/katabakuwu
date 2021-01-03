package com.katabakuwu.mainmenu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Cloud class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Cloud extends JLabel {
	private int x, y, width, height, max_x, max_y, speed_x, speed_y;
	private static final int REFRESH_RATE = 30;
	
	public Cloud(int x, int y, int width, int height, int speed_x, int speed_y, int max_x, int max_y) {
		this.x = x;
		this.y = y;
		this.speed_x = speed_x;
		this.speed_y = speed_y;
		this.width = width;
		this.height = height;
		this.max_x = max_x;
		this.max_y = max_y;
		
		this.setLocation(this.x, this.y);
		this.setSize(width, height);
		this.setIcon(new ImageIcon(new ImageIcon("assets/cloud.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					moveCloud();
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					} catch (InterruptedException e) {
						// do nothing
						System.out.println("ERROR");
					}
				}
			}
		};
		thread.start();
	}
	
	public void moveCloud() {
		this.x = x + this.speed_x;
		if(this.x > this.max_x) {
			this.x = (-1)*(this.speed_x)*this.width;
		}
		else if(this.x < (-1)*(this.speed_x)*this.width) {
			this.x = (-1)*(this.speed_x)*this.width;
		}
		this.y = y + this.speed_y;
		if(this.y > this.max_y) {
			this.y = (-1)*(this.speed_y)*this.height;
		}
		else if(this.y < (-1)*(this.speed_y)*this.height) {
			this.y = (-1)*(this.speed_y)*this.height;
		}
		this.setLocation(this.x, this.y);
	}
}
