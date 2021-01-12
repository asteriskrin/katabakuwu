package com.katabakuwu.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import com.katabakuwu.FrameMainMenu;
import com.katabakuwu.MainFrame;
import com.katabakuwu.data.User;
import com.katabakuwu.framework.ScoreboardControl;
import com.katabakuwu.server.WordDatabase;

/**
 * Game class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class Game implements ScoreboardControl {
	public MainFrame mf;
	private WordDatabase wordDatabase;
	private int state = 0;
	private User user;
	
	public Game() {
		wordDatabase = new WordDatabase();
		user = new User(this, "PlayerName", 1);
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
	public void endGame() {
		if(user.getPlayer().getHealth().getValue()<=0 || user.getPlayer().getTimer().getDuration()<=0) {
			JOptionPane.showMessageDialog(null, "Permainan selesai");
			try {
				sendScore(user.getName(), user.getPlayer().getScore().getScore());
			} catch (IOException e) {
				e.printStackTrace();
			}
			user.getPlayer().getHealth().setValue((Float)null);
			user.getPlayer().getTimer().setDuration((Integer) null);
			mf.getContentPane().removeAll();
			mf.setContentPane(new FrameMainMenu(this));
			mf.revalidate();
		}
	}
	
	public void setMainFrame(MainFrame mf) {
		this.mf = mf;
	}

	@Override
	public void sendScore(String name, int score) throws IOException {
		URL url = new URL("http://katabakuwu.asteriskrin.my.id/postScore.php?key=1234&name=" + name + "&score=" + score);
		System.out.println(url);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");
		OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
		System.out.println(httpCon.getResponseCode());
		System.out.println(httpCon.getResponseMessage());
		out.close();
	}
}
