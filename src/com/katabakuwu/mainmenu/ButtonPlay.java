package com.katabakuwu.mainmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.katabakuwu.FrameGame;
import com.katabakuwu.controller.Game;
import com.katabakuwu.framework.SoundJLayer;

/**
 * ButtonPlay class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonPlay extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Game game;
	
	public ButtonPlay(Game game, String text, int x, int y, int width, int height) {
		super(text);
		
		this.game = game;
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setBounds(x, y, width, height);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread = new Thread() {
			public void run() {
				try {
					SoundJLayer sound = new SoundJLayer("assets/sounds/button_click.mp3");
					sound.play();
				} catch(Exception e2) {
					System.out.println("Error while playing button click sound.");
				}
			}
		};

		thread.start();
		
		Thread thread2 = new Thread() {
			public void run() {
				try {
					FrameGame panel = new FrameGame(game);
					game.mf.getContentPane().removeAll();
					game.mf.setContentPane(panel);
					game.mf.revalidate();
					game.getWordDatabase().clearStatus();
				} catch(Exception e2) {
					System.out.println("Error while loading panel game.");
				}
			}
		};
		
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e1) {
			System.out.println("Error while joining thread 2 in ButtonPlay class.");
		}
	}
}
