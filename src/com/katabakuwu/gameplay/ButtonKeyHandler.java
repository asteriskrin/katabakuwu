package com.katabakuwu.gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.katabakuwu.controller.Game;
import com.katabakuwu.framework.SoundJLayer;
import com.katabakuwu.data.Player;

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
			game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText, clue, gameKeyboard);
			
			source.setEnabled(false);
			if(game.getUser().getPlayer().getGuessWord().isWordGuessed() && game.getUser().getPlayer().getTimer().getDuration()>0) {
				Thread thread = new Thread() {
					public void run() {
						SoundJLayer sound = new SoundJLayer("assets/sounds/word_finish.mp3");
						sound.play();
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							System.out.println("Error A01");
						}
						
						game.getUser().getPlayer().getGuessWord().getNewWord(guessText, clue);
						game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessText, clue, gameKeyboard);
						game.getUser().getPlayer().getBonus();
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
					Player p = game.getUser().getPlayer();
					p.getDamage();
					if(p.getHealth().getValue() <= 0) {
						p.endGame();
					}
				}
			};
			thread.start();

		}
		
	}

}
