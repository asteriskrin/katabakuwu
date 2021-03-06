package com.katabakuwu.data;

import javax.swing.JLabel;

import com.katabakuwu.controller.Game;

public class User {
	private String name;
	private int level;
	private Player player;
	private JLabel levelLabel;
	private Game game;
	private String authKey;
	
	/**
	 * Constructor
	 */
	public User(Game game, String name, int level) {
		this.game = game;
		this.name = name;
		this.level = level;
	}

	/**
	 * Get name
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name New name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get level
	 * @return Level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Set level
	 * @param level New level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Increase level
	 * @param level New level
	 */
	public void increaseLevel() {
		this.level++;
	}
	
	/**
	 * Get player
	 * @return Player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Set player
	 * @param Player Player class
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setLevelLabel(JLabel label) {
		this.levelLabel = label;
	}
	
	public void updateLevel() {
		levelLabel.setText("Lv. " + getLevel() + " " + getName());
	}

	/**
	 * Start game.
	 */
	public void startGame() {
		player = new Player(this);
		player.startGame();
	}

	/**
	 * End game.
	 */
	public void endGame() {
		game.endGame();
	}

	public String getAuthKey() {
		return authKey;
	}
	
	public void setAuthKey(String key) {
		authKey = key;
	}

	/**
	 * Reset user data.
	 */
	public void resetData() {
		name = "no_name";
		level = 1;
		authKey = "no_key";
	}
}
