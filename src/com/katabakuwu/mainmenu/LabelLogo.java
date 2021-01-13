package com.katabakuwu.mainmenu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelLogo extends JLabel {

	private static final long serialVersionUID = 1L;
	private int x = 165, y = -100;
	public LabelLogo() {
		setLocation(x, y);
		setSize(150, 150);
		setIcon(new ImageIcon(new ImageIcon("assets/logo.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		
		Thread lt = new LabelThread();
		lt.start();
	}
	
	private class LabelThread extends Thread {
		public void run() {
			while(y < 100) {
				y += 1;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
