package com.katabakuwu.gameplay;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTextField;
import com.katabakuwu.server.WordDatabase;

/**
 * Guess Word
 * Class that handles letters in guess word.
 * 
 * @author Ryan Garnet Andrianto
 * @author FARHAN
 */
public class GuessWord {
	public ArrayList<Letter> letters;
	private WordDatabase wordDb;
	public Word displayedWord;
	
	public GuessWord() {
		letters = new ArrayList<Letter>();
		wordDb = new WordDatabase();
	}
	
	/**
	 * Set word.
	 * 
	 * @param word
	 */
	public void setWord() {
		Word word = wordDb.getRandomWord();
		if(!word.getStatus()) {
			for(int i = 0; i < word.getWord().length(); i++) {
				if(word.getWord().charAt(i) >= 'A' && word.getWord().charAt(i) <= 'Z')
					letters.add(new Letter(word.getWord().charAt(i), false));
				else
					letters.add(new Letter(word.getWord().charAt(i), true));
			}

			this.displayedWord = word;
			
			if(letters.size() >= 5) {
				int rand = ThreadLocalRandom.current().nextInt(0, letters.size());
				letters.get(rand).setStatus(true);
				
				if(letters.size() >= 10) {
					int rand2 = ThreadLocalRandom.current().nextInt(0, letters.size());
					while (rand2 == rand) rand2 = ThreadLocalRandom.current().nextInt(0, letters.size());
					letters.get(rand2).setStatus(true);
				}
			}
		}
	}
	
	/**
	 * Build word display on text pane.
	 * 
	 * @return String
	 */
	public String buildWord() {
		StringBuilder word = new StringBuilder();
		
		for(int i = 0; i < letters.size(); i++) {
			Letter tempLetter = letters.get(i);
			
			if(!(letters.get(i).getLetter() >= 'A' && letters.get(i).getLetter() <= 'Z') || tempLetter.getStatus())
				if(letters.get(i).getLetter() != ' ')
					word.append(tempLetter.getLetter());
				else
					word.append("   ");
			else
				if (i == letters.size()-1) word.append("_");
				else word.append("_ ");
		}
		return word.toString();
	}

	
	/**
	 * Update word display.
	 * 
	 * @param textField
	 */
	public void updateWordDisplay(JTextField word, JTextField clue) {
		word.setText(buildWord());
		clue.setText(displayedWord.getClue());
	}
	
	/**
	 * Clear word display and letter array list, get new word.
	 * 
	 * @param textField
	 */
	public void getNewWord(JTextField textField, JTextField clue) {
		textField.setText("");
		clue.setText("");
	    for(Letter l : letters) l.setStatus(false);
	    letters.clear();
	    setWord();
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
	
	/**
	 * Check if all the letters in a word have been guessed.
	 * 
	 * @return boolean
	 */
	public boolean isWordGuessed() {
	    for(Letter l : letters) {
	        if(!l.getStatus())
	            return false;
	    }
	    this.displayedWord.setStatus(true);
	    return true;
	}
	
}