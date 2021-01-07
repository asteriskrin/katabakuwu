package com.katabakuwu.data;

import com.katabakuwu.gameplay.GuessWord;

/**
 * Player class.
 * 
 * @author Ryan Garnet Andrianto
 * @author FARHAN
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
		timer = new Timer(150);
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
	public boolean isEnoughHintValue() {
		float cost = (float) timer.getDuration()/timer.getMaxDuration()*75;
		if(cost < hint.getValue()) return true;
		return false;
	}
	
	/**
	 * Use hint.
	 */
	public void useHint() {
		if(this.isEnoughHintValue()) {
			hint.reduceValue(((float)timer.getDuration()/timer.getMaxDuration())*75);
			hint.updateProgressBar();
			System.out.println("USE HINT: " + guessWord.getUnguessedLetter());
		}
		else {
			System.out.println("Insufficient hint point.");
		}
	}
	
	/*
	 * Reduce player's HP on wrong guess.
	 */
	public void getGuessDamage() {
		float damage = (float) Math.min(30, timer.getDuration())/timer.getMaxDuration()*25;
		health.reduceValue(damage);
	}
	
	/*
	 * Get hint & health bonus on correct guess
	 */
	public void getBonus() {
		float bonus = (float) timer.getDuration()/timer.getMaxDuration()*30;
		
		hint.increaseValue(bonus);
		health.increaseValue(bonus);
		//timer.increaseDuration(10);
		
		hint.updateProgressBar();
		health.updateProgressBar();
		score += timer.getDuration();
	}
}
