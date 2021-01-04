package com.katabakuwu.mainmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.katabakuwu.FrameGame;
import com.katabakuwu.FrameScoreboard;
import com.katabakuwu.controller.Game;

/**
 * ButtonScoreboard class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonScoreboard extends JButton implements ActionListener {
	private Game game;
	
	public ButtonScoreboard(Game game, String text, int x, int y, int width, int height) {
		super(text);
		
		this.game = game;
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setBounds(x, y, width, height);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FrameScoreboard frame = new FrameScoreboard(this.game);
			frame.setVisible(true);
		} catch(Exception e2) {
			// do something here
		}
	}
	
}
