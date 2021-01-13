package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.mainmenu.ButtonScoreboard;
import com.katabakuwu.mainmenu.Cloud;
import com.katabakuwu.controller.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * FrameMainMenu class.
 * 
 * @author Farhan Arifandi
 * @author Ryan Garnet Andrianto
 */
public class FrameMainMenu extends JPanel {

	private static final long serialVersionUID = 2883848038660074213L;
	/**
	 * Create the frame.
	 * 
	 */
	public FrameMainMenu(Game game) {
		setBackground(Color.decode("#87CEEB"));
		setBounds(new Rectangle(0,0,480,640));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		JLabel picLabel = new JLabel();
		picLabel.setLocation(165, 100);
		picLabel.setSize(150, 150);
		picLabel.setIcon(new ImageIcon(new ImageIcon("assets/logo.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		add(picLabel);
		
		JLabel lblNewLabel = new JLabel("Katabakuwu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 35, 456, 36);
		add(lblNewLabel);
		
		/**
		 * Start game button.
		 */
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnStartGame.setBounds(10, 306, 446, 60);
		btnStartGame.setForeground(Color.decode("#333333"));
		btnStartGame.setBackground(Color.decode("#d5d5ff"));
		btnStartGame.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		btnStartGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.startGame();
			}
		});
		btnStartGame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnStartGame.setBackground(Color.decode("#d5d5ff"));
				btnStartGame.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStartGame.setBackground(Color.decode("#a8aaf6"));
				btnStartGame.setBorder(BorderFactory.createLineBorder(Color.decode("#b4c6f0"), 3));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		add(btnStartGame);
		
		JButton btnScoreboard = new ButtonScoreboard(game, "Scoreboard", 10, 386, 446, 60);
		add(btnScoreboard);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSettings.setBackground(Color.decode("#d5d5ff"));
		btnSettings.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
		btnSettings.setBounds(10, 466, 446, 60);
		btnSettings.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSettings.setBackground(Color.decode("#d5d5ff"));
				btnSettings.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 3));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSettings.setBackground(Color.decode("#a8aaf6"));
				btnSettings.setBorder(BorderFactory.createLineBorder(Color.decode("#b4c6f0"), 3));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		add(btnSettings);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		add(cloud2);
	}
}
