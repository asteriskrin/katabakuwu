package com.katabakuwu.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.katabakuwu.FrameMainMenu;
import com.katabakuwu.controller.Game;
import com.katabakuwu.framework.SoundJLayer;

public class ButtonSetting extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int x = -1000, y = 466, width = 446, height = 60;
	
	public ButtonSetting(Game game, FrameMainMenu frameMainMenu) {
		super("Setting");
		
		setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBackground(Color.decode("#d5d5ff"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		setBounds(x, y, width, height);
		addActionListener(this);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(Color.decode("#d5d5ff"));
				setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
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
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frameMainMenu.showSetting();
			}
		});
		
		ButtonThread bt = new ButtonThread();
		bt.start();
	}
	
	private class ButtonThread extends Thread {
		public void run() {
			while(x < 10) {
				x += 5;
				setBounds(x, y, width, height);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread() {
			public void run() {
				SoundJLayer sound = new SoundJLayer("assets/sounds/button_secondary_click.mp3");
				sound.play();

//				game.showSetting();
			}
		};
		t.start();
	}
}
