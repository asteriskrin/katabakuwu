package com.katabakuwu.data;

public class User {
	private String name;
	private int level;
	
	/**
	 * Constructor
	 */
	public User(String name, int level) {
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
	
	
}
