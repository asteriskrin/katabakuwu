package com.katabakuwu.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.setBounds(x, y, width, height);
		setBackground(Color.decode("#d5d5ff"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		this.addActionListener(this);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(Color.decode("#d5d5ff"));
				setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(Color.decode("#a8aaf6"));
				setBorder(BorderFactory.createLineBorder(Color.decode("#b4c6f0"), 3));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
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
