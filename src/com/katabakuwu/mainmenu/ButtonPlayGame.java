package com.katabakuwu.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.katabakuwu.controller.Game;

public class ButtonPlayGame extends JButton {

	private static final long serialVersionUID = 1L;
	private int x = -500, y = 306, width = 446, height = 60;
	public ButtonPlayGame(Game game) {
		super("Start Game");
		setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBounds(x, y, width, height);
		setForeground(Color.decode("#333333"));
		setBackground(Color.decode("#d5d5ff"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.startGame();
			}
		});
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
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		Thread thread = new Thread() {
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
		};
		thread.start();
	}
}
