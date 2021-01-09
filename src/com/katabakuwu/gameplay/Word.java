package com.katabakuwu.gameplay;

/**
 * Word
 * 
 * @author Farhan Arifandi
 */
public class Word {
	private String word;
	/**
	 * Word status.
	 * True = Guessed
	 * False = Not guessed
	 */
	private boolean status;
	private String clue;
	
	/**
	 * Constructor.
	 * 
	 * @param word
	 */
	public Word(String word, String clue) {
		this.word = word;
		this.status = false;
		this.clue = clue;
	}
	
	/**
	 * Set word status.
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * Get word status.
	 * 
	 * @return Status
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	/**
	 * Get word string.
	 * 
	 * @return String word
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Get clue.
	 * 
	 * @return String clue
	 */
	public String getClue() {
		return this.clue;
	}
}
