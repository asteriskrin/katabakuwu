package com.katabakuwu.data;

import javax.swing.JLabel;

/**
 * Score class.
 * 
 * @author FARHAN
 */
public class Score {
	private JLabel label;
	private int score;
	
	/**
	 * Constructor
	 * @param value Value
	 */
	public Score(int value) {
		this.score = value;
	}
	
	/**
	 * Set score JLabel.
	 * 
	 * @param bar
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	/**
	 * Get score.
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Set score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Reduce score
	 * 
	 * @param score
	 */
	public void reduceScore(int value) {
		setScore(getScore() - value);
	}
	
	/**
	 * Increase value
	 * 
	 * @param value Value
	 */
	public void increaseScore(int value) {
		setScore(this.score + value);
		updateScore();
	}
	
	/**
	 * Update progress bar
	 */
	public void updateScore() {
		label.setText(String.format("%06d", this.score));
	}
}

