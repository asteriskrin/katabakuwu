package com.katabakuwu.mainmenu;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.katabakuwu.framework.WAVController;
/**
 * BGM for Main Menu.
 * @author Ryan Garnet Andrianto
 * 
 * Music Source
 * @see https://orangefreesounds.com/dramatic-mystery-theme-song/
 */
public class BGM_MainMenu extends Thread {
	private WAVController mc;
	
	public void run() {
		try {
			mc = new WAVController("./assets/sounds/main_theme.wav");
			mc.play();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
