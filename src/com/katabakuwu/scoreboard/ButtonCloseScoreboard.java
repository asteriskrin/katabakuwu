package com.katabakuwu.scoreboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.katabakuwu.FrameGame;
import com.katabakuwu.FrameScoreboard;
import com.katabakuwu.controller.Game;

/**
 * ButtonCloseScoreboard class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonCloseScoreboard extends JButton implements ActionListener {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	private FrameScoreboard frameScoreboard;
	
	public ButtonCloseScoreboard(FrameScoreboard frameScoreboard, String text, int x, int y, int width, int height) {
		super(text);
		
		this.frameScoreboard = frameScoreboard;
		
		setForeground(Color.WHITE);
		setBackground(Color.MAGENTA);
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setBounds(x, y, width, height);
		
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameScoreboard.setVisible(false);
	}
}
