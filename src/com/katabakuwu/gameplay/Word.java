package com.katabakuwu.gameplay;

/**
 * Letter
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
	
	/**
	 * Constructor.
	 * 
	 * @param word
	 */
	public Word(String word) {
		this.word = word;
		this.status = false;
	}
	
	/**
	 * Set letter status.
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * Get letter status.
	 * 
	 * @return Status
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	/**
	 * Get letter.
	 * 
	 * @return Letter
	 */
	public String getWord() {
		return this.word;
	}
}
