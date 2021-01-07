package com.katabakuwu.gameplay;

import java.util.ArrayList;

import javax.swing.JTextField;

import com.katabakuwu.controller.Game;
import com.katabakuwu.server.WordDatabase;

/**
 * Guess Word
 * Class that handles letters in guess word.
 * 
 * @author Ryan Garnet Andrianto
 */
public class GuessWord {
	private ArrayList<Letter> letters;
	
	public GuessWord() {
		letters = new ArrayList<Letter>();
	}
	
	/**
	 * Set word.
	 * 
	 * @param word.
	 */
	public void setWord(Word word) {
		for(int i = 0; i < word.getWord().length() ; i++) {
			letters.add(new Letter(word.getWord().charAt(i), false));
		}
		isWordGuessed();
	}
	
	/**
	 * Get word.
	 * 
	 * @return String
	 */
	public String getWord() {
		StringBuilder word = new StringBuilder();
		for(int i = 0; i < letters.size(); i++) {
			Letter tempLetter = letters.get(i);
			if(tempLetter.getStatus()) {
				word.append(tempLetter.getLetter());
			}
			else {
				word.append('_');
			}
		}
		return word.toString();
	}
	
	/**
	 * Update word display.
	 * 
	 * @param textField
	 */
	public void updateWordDisplay(JTextField textField) {
		textField.setText(getWord());
	}
	
	/**
	 * Guess the word.
	 * 
	 * @param letter
	 * @return true success
	 * @return false fail
	 */
	public boolean guess(char letter) {
		boolean isFound = false;
		for(int i = 0; i < letters.size(); i++) {
			// If the letter has been guessed, skip
			if(letters.get(i).getStatus())
				continue;
			
			// If the guess is correct
			if(letters.get(i).getLetter() == letter) {
				letters.get(i).setStatus(true);
				
				isFound = true;
			}
		}
		return isFound;
	}
	
	/**
	 * Get unguessed letter.
	 * 
	 * @return char
	 */
	public char getUnguessedLetter() {
		for(int i = 0; i < letters.size(); i++) {
			// If the letter has been guessed, skip
			if(letters.get(i).getStatus())
				continue;
			
			return letters.get(i).getLetter();
		}
		return '\0';
	}
	
	public boolean isWordGuessed() {
	    for(Letter l : letters) {
	        if(!l.getStatus())
	            return false;
	    }
	    return true;
	}
}
