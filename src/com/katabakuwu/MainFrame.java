package com.katabakuwu;

import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.katabakuwu.controller.Game;

public class MainFrame extends JFrame{

	public MainFrame(Game game) {
		game.setMainFrame(this);
		this.setTitle("Katabakuwu");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(new Rectangle(100,100,480,640));
		this.setVisible(true);
		
		FrameMainMenu menuPanel = new FrameMainMenu(game);
		this.add(menuPanel);
		this.setContentPane(menuPanel);
		menuPanel.setVisible(true);
	}
}
