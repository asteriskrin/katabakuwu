package com.katabakuwu.framework;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import javax.sound.sampled.Line.Info;

import com.katabakuwu.framework.*;

public class SoundJLayer extends PlaybackListener implements Runnable {
    private String filePath;
    private AdvancedPlayer player;
    private Thread playerThread;
    private Info source = Port.Info.SPEAKER;
    public String status = "stop";
    public boolean loop;
    
    public SoundJLayer(String filePath) {
        this.filePath = filePath;
        this.loop = false;
    }
    
    public SoundJLayer(String filePath, boolean loop) {
        this.filePath = filePath;
        this.loop = loop;
    }

    public void play() {
        try {
        	String urlAsString =
                "file:///" +
                new java.io.File(".").getCanonicalPath() + "/" +
                this.filePath;

            this.player = new AdvancedPlayer(
                new java.net.URL(urlAsString).openStream(),
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
            );

            this.player.setPlayBackListener(this);

            this.playerThread = new Thread(this, "AudioPlayerThread");

            this.playerThread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playbackStarted(PlaybackEvent playbackEvent) {
    }

    public void playbackFinished(PlaybackEvent playbackEvent) {
    }

    public void run() {
        try {
        	status = "play";
            this.player.play();
            if(loop && status == "play") {
            	play();
            }
        } catch (javazoom.jl.decoder.JavaLayerException ex) {
            ex.printStackTrace();
        }

    }
    
    public void stop() {
    	this.player.stop();
    	status = "stop";
    }
    
    public void setVolume(float volume) {
    	if (AudioSystem.isLineSupported(source)) 
        {
            try 
            {
                Port outline = (Port) AudioSystem.getLine(source);
                outline.open();                
                FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);          
                volumeControl.setValue(volume);
            } 
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
    }
}