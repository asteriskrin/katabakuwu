package com.katabakuwu.gameplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Hint object (ball).
 * 
 */
public class HintObject {
	
	private static final int speedX = 1, finishX = 500;
	private JPanel gamePanel;
	private char hintChar;
	private int x, y, width, height;
	
	public HintObject(JPanel gamePanel, char hintChar, int x, int y, int width, int height) {
		this.gamePanel = gamePanel;
		this.hintChar = hintChar;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void startMoving() {
		Thread t = new MovementThread();
		t.start();
	}
	
	public void draw(Graphics g) {
		// draw circle
		g.setColor(Color.decode("#00a6ff"));
		g.fillOval(x, y, width, height);
		
		// draw character
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 48));
		g.drawString(String.valueOf(hintChar), x + width/4, y + 4*height/5);
	}
	
	private class MovementThread extends Thread {
		public void run() {
			// move the ball from left to right
			while(x < finishX) {
				x += speedX;
				gamePanel.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
