package com.katabakuwu.gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.katabakuwu.controller.Game;

/**
 * Button Key Handler.
 * It handles player input through mouse click for guessing word.
 * 
 * @author Ryan Garnet Andrianto
 * @author Farhan Arifandi
 */

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
		JButton source = (JButton) e.getSource();
         
		boolean response = game.getUser().getPlayer().getGuessWord().guess(letter);
		
		if(response) {
			// Guess successful
			game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText);
			source.setEnabled(false);
		}
		else {
			// Guess failed
			System.out.println("Guess Failed");
			game.getUser().getPlayer().getGuessDamage();
			game.getUser().getPlayer().getHealth().updateProgressBar();
		}
	}

}
