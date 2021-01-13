package com.katabakuwu.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import com.katabakuwu.FrameGame;
import com.katabakuwu.FrameMainMenu;
import com.katabakuwu.FrameScoreboard;
import com.katabakuwu.MainFrame;
import com.katabakuwu.data.Player;
import com.katabakuwu.data.User;
import com.katabakuwu.framework.ScoreboardControl;
import com.katabakuwu.framework.SoundJLayer;
import com.katabakuwu.framework.WAVController;
import com.katabakuwu.server.WordDatabase;

/**
 * Game class.
 * 
 * @author Ryan Garnet Andrianto
 * @author Farhan Arifandi
 */
public class Game implements ScoreboardControl, ScreenController {
	public MainFrame mf;
	private WordDatabase wordDatabase;
	private User user;
	private SoundJLayer bgm;
	
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
		JOptionPane.showMessageDialog(null, "Permainan selesai, skormu sedang dikirimkan...\r\nHarap tunggu...");

		Thread thread = new Thread() {
			public void run() {
				try {
					sendScore(user.getName(), user.getPlayer().getScore().getScore());
				} catch (IOException e) {
					System.out.println("Error while trying to send player score to server.");
				}
				JOptionPane.showMessageDialog(null, "Skor telah berhasil dikirimkan...");
				
				showScoreboard();
			}
		};
		thread.start();
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

	/**
	 * Show scoreboard panel.
	 */
	@Override
	public void showScoreboard() {
		try {
			FrameScoreboard panel = new FrameScoreboard(this);
			mf.getContentPane().removeAll();
			mf.setContentPane(panel);
			mf.revalidate();
		} catch (Exception e2) {
			System.out.println("Error while trying to show scoreboard panel.");
		}
	}
	
	/**
	 * Show main menu panel.
	 */
	@Override
	public void showMainMenu() {
		try {
			FrameMainMenu panel = new FrameMainMenu(this);
			mf.getContentPane().removeAll();
			mf.setContentPane(panel);
			mf.revalidate();
			
			playBGM("assets/sounds/main_theme1.mp3");
		} catch (Exception e2) {
			System.out.println("Error while trying to show main menu panel.");
		}
	}

	/**
	 * Play BGM..
	 * 
	 * @param string File path
	 */
	private void playBGM(String filePath) {
		Thread thread = new Thread() {
			public void run() {
				
				bgm = new SoundJLayer(filePath);
				bgm.play();
			}
		};
		thread.start();
	}

	/**
	 * Start game.
	 */
	public void startGame() {
		user.startGame();
		getWordDatabase().clearStatus();
		showGameplayPanel();
	}

	/**
	 * Show gameplay panel.
	 */
	@Override
	public void showGameplayPanel() {
		FrameGame panel = new FrameGame(this);
		mf.getContentPane().removeAll();
		mf.setContentPane(panel);
		mf.revalidate();
	}
}
