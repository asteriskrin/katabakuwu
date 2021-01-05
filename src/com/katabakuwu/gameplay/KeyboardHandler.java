package com.katabakuwu.gameplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.katabakuwu.controller.Game;

/**
 * Keyboard Handler.
 * It handles player input through keyboard for guessing word.
 * 
 * @author Ryan Garnet Andrianto
 * @author Farhan Arifandi
 */
public class KeyboardHandler implements KeyListener {
	private Game game;
	private JTextField guessText;
	/**
	 * Constructor
	 */
	public KeyboardHandler(Game game, JTextField guessText) {
		this.game = game;
		this.guessText = guessText;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char letter = Character.toUpperCase(e.getKeyChar());
		
		boolean response = game.getUser().getPlayer().getGuessWord().guess(letter);
		
		if(response) {
			// Guess successful
			game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText);
		}
		else {
			// Guess failed
			System.out.println("Guess Failed");
			game.getUser().getPlayer().getHealth().reduceValue(
				((float)Math.min(30, game.getUser().getPlayer().getTimer().getDuration())/game.getUser().getPlayer().getTimer().getMaxDuration())*25
			);
			game.getUser().getPlayer().getHealth().updateProgressBar();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
