package com.katabakuwu.data;

/**
 * Player class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Player {
	private Health health;
	private Timer timer;
	private int score;
	
	/**
	 * Constructor
	 */
	public Player() {
		health = new Health();
		timer = new Timer(300);
		this.score = 0;
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
}
