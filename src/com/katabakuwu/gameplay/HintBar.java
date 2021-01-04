package com.katabakuwu.gameplay;

import java.awt.Color;

import javax.swing.JProgressBar;

/**
 * Hint Bar
 * 
 * @author Ryan Garnet Andrianto
 */
public class HintBar extends JProgressBar {

	private static final long serialVersionUID = 1L;

	public HintBar(int x, int y, int width, int height) {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.ORANGE);
		setBounds(x, y, width, height);
	}
}
