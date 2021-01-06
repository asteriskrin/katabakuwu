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
		this.hint = new Hint((float)100.0);
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
	
	/**
	 * Use hint.
	 */
	public void useHint() {
		if(hint.getValue() >= ((float)timer.getDuration()/timer.getMaxDuration())*75) {
			hint.reduceValue(((float)timer.getDuration()/timer.getMaxDuration())*75);
			hint.updateProgressBar();
			System.out.println("USE HINT: " + guessWord.getUnguessedLetter());
		}
		else {
			System.out.println("Insufficient hint point.");
		}
	}
	
	public void getGuessDamage() {
		float damage = Math.min(30, timer.getDuration())/timer.getMaxDuration()*25;
		health.reduceValue(damage);
	}
}
