package com.katabakuwu.mainmenu;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameTitle extends JLabel {

	private static final long serialVersionUID = 1L;
	private int x = 10, y = -500, width = 456, height = 36;
	public GameTitle() {
		super("KatabakUWU");
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.BOLD, 32));
		setBounds(x, y, width, height);
		
		LogoThread lt = new LogoThread();
		lt.start();
	}
	
	private class LogoThread extends Thread {
		public void run() {
			while(y < 220) {
				y += 5;
				setBounds(x, y, width, height);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
