package com.katabakuwu.gameplay;

/**
 * Letter
 * 
 * @author Ryan Garnet Andrianto
 */
public class Letter {
	private char letter;
	/**
	 * Letter status.
	 * True = Guessed
	 * False = Not guessed
	 */
	private boolean status;
	
	/**
	 * Constructor.
	 * 
	 * @param letter
	 * @param status
	 */
	public Letter(char letter, boolean status) {
		this.letter = letter;
		this.status = status;
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
	public char getLetter() {
		return this.letter;
	}
}
