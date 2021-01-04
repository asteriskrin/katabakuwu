package com.katabakuwu.data;

import com.katabakuwu.gameplay.GuessWord;

/**
 * Player class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Player {
	private Health health;
	private Timer timer;
	private Hint hint;
	private int score;
	private GuessWord guessWord;
	
	/**
	 * Constructor
	 */
	public Player() {
		health = new Health();
		timer = new Timer(300);
		hint = new Hint((float) 100.0);
		this.score = 0;
		guessWord = new GuessWord();
	}
	
	/**
	 * Get score
	 * @return Score
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Get health
	 * @return Health
	 */
	public Health getHealth() {
		return this.health;
	}
	
	/**
	 * Get timer
	 * @return Timer
	 */
	public Timer getTimer() {
		return this.timer;
	}
	
	/**
	 * Get Hint
	 * @return Hint
	 */
	public Hint getHint() {
		return this.hint;
	}
	
	/**
	 * Get Guess Word.
	 * 
	 * @return Guess Word
	 */
	public GuessWord getGuessWord() {
		return guessWord;
	}
}
