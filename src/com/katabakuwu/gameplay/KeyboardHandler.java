package com.katabakuwu.gameplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	private JTextField clue;
	/**
	 * Constructor
	 */
	public KeyboardHandler(Game game, JTextField guessText, JTextField clue) {
		this.game = game;
		this.guessText = guessText;
		this.clue = clue;
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
			game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText, clue);
		}
		else {
			// Guess failed
			System.out.println("Guess Failed");
			game.getUser().getPlayer().getGuessDamage();
			game.getUser().getPlayer().getHealth().updateProgressBar();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
