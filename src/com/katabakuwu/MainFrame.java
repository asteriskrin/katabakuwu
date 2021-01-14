package com.katabakuwu;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import com.katabakuwu.controller.Game;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public MainFrame(Game game) {
		game.setMainFrame(this);
		
		setTitle("Katabakuwu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(100,100,480,640));
		
		// Start at center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		game.showMainMenu();
	}
}
