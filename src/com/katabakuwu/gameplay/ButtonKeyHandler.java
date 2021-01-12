package com.katabakuwu.gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.katabakuwu.GameKeyboard;
import com.katabakuwu.controller.Game;
import com.katabakuwu.framework.SoundJLayer;

/**
 * Button Key Handler.
 * It handles player input through mouse click for guessing word.
 * 
 * @author Ryan Garnet Andrianto
 * @author Farhan Arifandi
 */

public class ButtonKeyHandler implements ActionListener {
	private Game game;
	private JTextField guessText, clue;
	private GameKeyboard gameKeyboard;
	
	public ButtonKeyHandler(Game game, JTextField guessText, JTextField clue, GameKeyboard gameKeyboard) {
		this.game = game;
		this.guessText = guessText;
		this.clue = clue;
		this.gameKeyboard = gameKeyboard;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		char letter = Character.toUpperCase((char) e.getActionCommand().charAt(0));
		JButton source = (JButton) e.getSource();
         
		boolean response = game.getUser().getPlayer().getGuessWord().guess(letter);
		
		if(response) {
			// Guess successful
			
			if(game.getUser().getPlayer().getGuessWord().isWordGuessed() && game.getUser().getPlayer().getTimer().getDuration()>0) {
				Thread thread = new Thread() {
					public void run() {
						SoundJLayer sound = new SoundJLayer("assets/sounds/word_finish.mp3");
						sound.play();
						
						for(JButton j : gameKeyboard.keyboard) j.setEnabled(true);
						
						game.getUser().getPlayer().getBonus();
						game.getUser().getPlayer().getGuessWord().getNewWord(guessText, clue);
						game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText, clue);
						
						game.getUser().increaseLevel();
						game.getUser().updateLevel();
					}
				};
				thread.start();
			}
			else {
				Thread thread = new Thread() {
					public void run() {
						SoundJLayer sound = new SoundJLayer("assets/sounds/guess_correct.mp3");
						sound.play();
						
						game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText, clue);
						
						source.setEnabled(false);
					}
				};
				thread.start();
			}
		}
		
		else {
			// Guess failed
			Thread thread = new Thread() {
				public void run() {
					SoundJLayer sound = new SoundJLayer("assets/sounds/guess_wrong.mp3");
					sound.play();
					

					source.setEnabled(false);
					game.getUser().getPlayer().getGuessDamage();
					game.getUser().getPlayer().getHealth().updateProgressBar();
				}
			};
			thread.start();

		}
		
	}

}
