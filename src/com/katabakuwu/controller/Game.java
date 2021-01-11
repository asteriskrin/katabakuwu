package com.katabakuwu.controller;

import javax.swing.JOptionPane;

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
	
	/*
	 * End game.
	 */
	public boolean endGame() {
		if(user.getPlayer().getHealth().getValue()<=0 || user.getPlayer().getTimer().getDuration()<=0) {
			JOptionPane.showMessageDialog(null, "Permainan selesai");
			return true;
		}
		return false;
	}
}
