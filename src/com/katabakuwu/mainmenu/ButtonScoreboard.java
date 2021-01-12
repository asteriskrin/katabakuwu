package com.katabakuwu.mainmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.katabakuwu.controller.Game;

/**
 * ButtonScoreboard class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonScoreboard extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Game game;
	
	/**
	 * Constructor
	 * 
	 * @param game Game class instance
	 * @param text Button text
	 * @param x Button position x
	 * @param y Button position y
	 * @param width Button width
	 * @param height Button height
	 */
	public ButtonScoreboard(Game game, String text, int x, int y, int width, int height) {
		super(text);
		
		this.game = game;
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setBounds(x, y, width, height);
		this.addActionListener(this);
	}
	
	/**
	 * Button click action.
	 * 
	 * @param e Button action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		game.showScoreboard();
	}
	
}
