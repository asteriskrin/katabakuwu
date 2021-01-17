package com.katabakuwu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelMainMenuLoading extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String[] loadingStr = {
		"Loading",
		"Loading.",
		"Loading..",
		"Loading..."
	};
	private int dotState = 0;
	
	public PanelMainMenuLoading() {
		setBackground(Color.decode("#FFFFFF"));
		startTimer();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Verdana", Font.BOLD, 24));
		
		g.drawString(loadingStr[dotState], 170, 300);
	}
	
	public void startTimer() {
		Thread timer = new DotTimer();
		timer.start();
	}
	private class DotTimer extends Thread {
		private int counter = 0;
		public void run() {
			while(++counter < 100) {
				dotState = (dotState + 1) % 4;
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
