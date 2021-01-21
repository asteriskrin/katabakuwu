package com.katabakuwu.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.katabakuwu.PanelMainMenu;
import com.katabakuwu.controller.Game;
import com.katabakuwu.framework.SoundJLayer;

/**
 * ButtonScoreboard class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonScoreboard extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Game game;
	private int x = 500, y = 386, width = 446, height = 60;
	
	/**
	 * Constructor
	 * 
	 * @param game Game class instance
	 * @param text Button text
	 * @param x Button position x
	 * @param y Button position y
	 * @param width Button width
	 * @param height Button height
	 */
	public ButtonScoreboard(Game game, PanelMainMenu frameMainMenu) {
		super("Scoreboard");
		
		this.game = game;
		this.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.setBounds(x, y, width, height);
		setBackground(Color.decode("#d5d5ff"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		this.addActionListener(this);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(frameMainMenu.enabled) {
					setBackground(Color.decode("#d5d5ff"));
					setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(frameMainMenu.enabled) {
					setBackground(Color.decode("#a8aaf6"));
					setBorder(BorderFactory.createLineBorder(Color.decode("#b4c6f0"), 3));
					
					Thread soundThread = new Thread() {
						public void run() {
							SoundJLayer sound = new SoundJLayer("assets/sounds/button_click.mp3");
							sound.play();
						}
					};
					soundThread.start();
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		ButtonThread bt = new ButtonThread();
		bt.start();
	}
	
	/**
	 * Button click action.
	 * 
	 * @param e Button action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread() {
			public void run() {
				SoundJLayer sound = new SoundJLayer("assets/sounds/button_secondary_click.mp3");
				sound.play();

				game.showScoreboard();
			}
		};
		t.start();
	}
	
	private class ButtonThread extends Thread {
		public void run() {
			while(x > 10) {
				x -= 5;
				setBounds(x, y, width, height);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
