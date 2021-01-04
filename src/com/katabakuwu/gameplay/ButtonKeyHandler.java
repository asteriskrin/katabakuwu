package com.katabakuwu.gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.katabakuwu.controller.Game;

public class ButtonKeyHandler implements ActionListener {
	private Game game;
	private JTextField guessText;
	
	public ButtonKeyHandler(Game game, JTextField guessText) {
		this.game = game;
		this.guessText = guessText;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		char letter = Character.toUpperCase((char) e.getActionCommand().charAt(0));
		
		boolean response = game.getUser().getPlayer().getGuessWord().guess(letter);
		
		if(response) {
			// Guess successful
			game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText);
		}
		else {
			// Guess failed
			System.out.println("Guess Failed");
		}
	}

}
