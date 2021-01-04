package com.katabakuwu.controller;

import com.katabakuwu.data.User;
import com.katabakuwu.server.WordDatabase;

/**
 * Game class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Game {
	private WordDatabase wordDatabase;
	private int state = 0;
	private User user;
	
	public Game() {
		wordDatabase = new WordDatabase();
		user = new User("PlayerName", 1);
	}
	
	/**
	 * Get user.
	 * 
	 * @return User class
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Get Word Database
	 */
	public WordDatabase getWordDatabase() {
		return wordDatabase;
	}
}
