package com.katabakuwu.gameplay;

import java.util.ArrayList;

import javax.swing.JTextField;

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
	 * @param word
	 */
	public void setWord(String word) {
		for(int i = 0; i < word.length(); i++) {
			letters.add(new Letter(word.charAt(i), false));
		}
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
}
