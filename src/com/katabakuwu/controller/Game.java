package com.katabakuwu.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.katabakuwu.PanelGameplay;
import com.katabakuwu.PanelMainMenu;
import com.katabakuwu.PanelScoreboard;
import com.katabakuwu.MainFrame;
import com.katabakuwu.PanelMainMenuLoading;
import com.katabakuwu.data.User;
import com.katabakuwu.framework.ScoreboardControl;
import com.katabakuwu.framework.SoundJLayer;
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
	private float volume = 0.5f;
	
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
		stopBGM();
		JOptionPane.showMessageDialog(null, "Permainan selesai, skormu sedang dikirimkan...\r\nHarap tunggu...");

		Thread thread = new Thread() {
			public void run() {
				try {
					sendScore(user.getAuthKey(), user.getPlayer().getScore().getScore(), user.getLevel());
					System.out.println("Skor berhasil dikirimkan.");
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
	public void sendScore(String authKey, int score, int level) throws IOException {
		URL url = new URL("https://katabakuwu.asteriskrin.my.id/api/scoreboard/post/?auth_key=" + authKey + "&score=" + score + "&level=" + level);
		System.out.println(url);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setRequestProperty("Accept-Charset", "UTF-8");
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");
		OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
		System.out.println(httpCon.getResponseCode());
		System.out.println(httpCon.getResponseMessage());
		out.close();
	}
	
	@SuppressWarnings("resource")
	public boolean loadData() {
		File saveFile = new File("./data/key.uwu");
		
		try {
			Scanner reader = new Scanner(saveFile);
			
			if(reader.hasNextLine()) {
				String key = reader.nextLine();
				
				return loadDataKey(key);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public boolean loadDataKey(String authKey) {
		
		String sURL = "https://katabakuwu.asteriskrin.my.id/api/validate/" + authKey;
		
		try {
			URL url = new URL(sURL);
		    URLConnection request = url.openConnection();
		    request.connect();
		    
		    // Convert to a JSON object
			JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		    JsonObject rootobj = root.getAsJsonObject();
		    String name = rootobj.get("name").getAsString();
		    int level = rootobj.get("level").getAsInt();
		    
		    user.setName(name);
		    user.setLevel(level);
		    user.setAuthKey(authKey);
		    return true;
		    
		} catch (IOException e) {
			return false;
		}
	    
	}
	
	@SuppressWarnings("deprecation")
	public boolean register(String name) {
		String sURL = "https://katabakuwu.asteriskrin.my.id/api/register?name=" + name;
		
		try {
			URL url = new URL(sURL);
		    URLConnection request = url.openConnection();
		    request.connect();
		    
		    // Convert to a JSON object
			JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		    JsonObject rootobj = root.getAsJsonObject();
		    String authKey = rootobj.get("auth_key").getAsString();
		    
		    return writeAuthKey(authKey);
		    
		} catch (IOException e) {
			return false;
		}
	}
	
	public boolean writeAuthKey(String authKey) {
		try {
			FileWriter myWriter = new FileWriter("./data/key.uwu");
			myWriter.write(authKey);
			myWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public void showMainMenuLoading() {
		try {
			PanelMainMenuLoading panel = new PanelMainMenuLoading();
			mf.getContentPane().removeAll();
			mf.setContentPane(panel);
			mf.revalidate();
		} catch (Exception e2) {
			System.out.println("Error while trying to show scoreboard panel.");
		}
	}
	
	public void startDataLoad() {
		Thread t = new Thread() {
			public void run() {
				if(!loadData()) {
					String name = JOptionPane.showInputDialog("Halo!\r\nSelamat datang di KatabakUWU.\n\nHarap tulis nama kamu di bawah ini!");
					while(name == null || name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
						name = JOptionPane.showInputDialog("Masukkan nama: ");
					}
					user.setName(name);
					if(!register(name)) {
						JOptionPane.showMessageDialog(null, "Terjadi error saat mencoba untuk mendaftarkan akun.\n\rCoba cek koneksi internetmu.\n\rPastikan kamu mempunyai koneksi internet ya..\n\rData bermainmu tidak akan disimpan.", "Pesan", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Selamat datang kembali, " + user.getName() + "!", "Sapaan", JOptionPane.INFORMATION_MESSAGE);
				}
				showMainMenu();
			}
		};
		t.start();
	}

	/**
	 * Show scoreboard panel.
	 */
	@Override
	public void showScoreboard() {
		try {
			PanelScoreboard panel = new PanelScoreboard(this);
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
			PanelMainMenu panel = new PanelMainMenu(this);
			mf.getContentPane().removeAll();
			mf.setContentPane(panel);
			mf.revalidate();
			
			playBGM("assets/sounds/main_theme1.mp3");
		} catch (Exception e2) {
			System.out.println("Error while trying to show main menu panel.");
		}
	}

	/**
	 * Play BGM.
	 * 
	 * @param string File path
	 */
	private void playBGM(String filePath) {
		Thread thread = new Thread() {
			public void run() {
				if(bgm != null && bgm.status.equals("play")) {
					bgm.stop();
				}
				bgm = new SoundJLayer(filePath, true);
				bgm.setVolume(volume);
				bgm.play();
			}
		};
		thread.start();
	}
	
	/**
	 * Stop BGM.
	 */
	private void stopBGM() {
		if(bgm != null && bgm.status.equals("play")) {
			bgm.stop();
		}
	}
	
	/**
	 * Set BGM volume.
	 * 
	 * @param string File path
	 */
	public void setVolume(float volume) {
		bgm.setVolume(volume);
		this.volume = volume;
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
		PanelGameplay panel = new PanelGameplay(this);
		mf.getContentPane().removeAll();
		mf.setContentPane(panel);
		mf.revalidate();
	}

	/**
	 * Reset saved game data.
	 */
	public void resetData() {
		// delete save key
		try {
			File file = new File("./data/key.uwu");
			file.delete();
		} catch (Exception e) {
			System.out.println("Error while deleting key.uwu");
		}
		// reset user instance data
		user.resetData();
		// restart game
		showMainMenuLoading();
		startDataLoad();
	}

}
