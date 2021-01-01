package com.katabakuwu.controller;

import com.katabakuwu.data.User;

/**
 * Game class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Game {
	private int state = 0;
	private User user;
	
	public Game() {
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
}
