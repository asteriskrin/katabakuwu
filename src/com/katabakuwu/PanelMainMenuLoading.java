package com.katabakuwu;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.katabakuwu.controller.Game;

public class PanelMainMenuLoading extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Verdana", Font.BOLD, 24));
		g.drawString("Loading...", 270, 210);
	}
}
