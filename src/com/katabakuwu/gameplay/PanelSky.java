package com.katabakuwu.gameplay;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel Sky.
 */
public class PanelSky extends JPanel {

	private static final long serialVersionUID = 1L;
	private int currentColor = 0;
	private static Color[] colorTransition = {
		Color.decode("#87CEEB"),
		Color.decode("#FCF187"),
		Color.decode("#FFBB21"),
		Color.decode("#2E4482")
	};
	
	public PanelSky() {
		setBackground(Color.decode("#87CEEB"));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					switchSkyColor();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
	
	public void switchSkyColor() {
		if(++currentColor >= colorTransition.length)
			currentColor = 0;
		setBackground(colorTransition[currentColor]);
	}
}
