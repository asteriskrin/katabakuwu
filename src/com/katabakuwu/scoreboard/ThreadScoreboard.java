package com.katabakuwu.scoreboard;

import java.net.MalformedURLException;

import javax.swing.JList;

/**
 * Thread Scoreboard.
 * @author Ryan Garnet Andrianto
 */
public class ThreadScoreboard extends Thread {

	private ScoreboardList sl;
	private JList<String> list;
	
	/**
	 * Constructor
	 * @param list Scoreboard JList class instance
	 * @param sl Scoreboard List class instance
	 */
	public ThreadScoreboard(JList<String> list, ScoreboardList sl) {
		this.sl = sl;
		this.list = list;
	}
	
	/**
	 * Run
	 */
	public void run() {
		try {
			sl.updateData();
		} catch (MalformedURLException e) {
			sl.noConnection();
		}
		list.updateUI();
	}
}
