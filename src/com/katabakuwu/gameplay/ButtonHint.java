package com.katabakuwu.gameplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.katabakuwu.controller.Game;
import com.katabakuwu.data.Hint;


/**
 * Button Hint
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonHint extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Game game;
	private int x, y, width, height;
	
	public ButtonHint(Game game, int x, int y, int width, int height) {
		super("?");
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
		
		setForeground(Color.WHITE);
		setBackground(Color.MAGENTA);
		setFont(new Font("Tahoma", Font.PLAIN, 48));
		setBounds(this.x, this.y, this.width, this.height);
		addActionListener(this);
		setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.getUser().getPlayer().isEnoughHintValue()) {
			game.getUser().getPlayer().useHint();
		}
		else {
			this.setBackground(Color.LIGHT_GRAY);
			this.setEnabled(false);
		}
	}
	
}
