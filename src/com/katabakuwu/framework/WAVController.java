package com.katabakuwu.framework;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * WAV Controller
 * @author Ryan Garnet Andrianto
 */
public class WAVController {
	Long currentFrame;
	Clip clip;
	
	String status;
	
	AudioInputStream audioInputStream;
	
	String filePath;
	
	public WAVController(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.filePath = filePath;
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void play() {
		clip.start();
		status = "play";
	}
	
	public void pause() {
		if (status.equals("pause"))
			return;
		
		this.currentFrame = this.clip.getMicrosecondPosition();
		clip.stop();
		status = "pause";
	}
	
	public void resume() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (status.equals("play"))
			return;
		
		clip.close();
		resetAudioStream();
		clip.setMicrosecondPosition(currentFrame);
		play();
	}
	
	public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
