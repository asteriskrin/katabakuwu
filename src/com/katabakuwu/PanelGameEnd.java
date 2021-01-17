package com.katabakuwu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class PanelGameEnd extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelGameEnd() {
		setBounds(new Rectangle(0, 0, 480, 640));
		setVisible(false);
		setLayout(null);
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0, 0, 0, 100));
		g.fillRect(0, 0, 480, 640);
		
		g.setColor(Color.decode("#6bcaf2"));
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.drawString("GAME OVER", 135, 290);

		g.setColor(Color.decode("#ffffff"));
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Skor sedang dikirimkan...", 135, 320);
	}
}
