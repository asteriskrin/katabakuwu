package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.mainmenu.BGM_MainMenu;
import com.katabakuwu.mainmenu.ButtonPlay;
import com.katabakuwu.mainmenu.ButtonScoreboard;
import com.katabakuwu.mainmenu.Cloud;
import com.katabakuwu.controller.Game;

import java.awt.*;

/**
 * FrameMainMenu class.
 * 
 * @author Farhan Arifandi
 * @author Ryan Garnet Andrianto
 */
public class FrameMainMenu extends JPanel {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * 
	 */
	public FrameMainMenu(Game game) {
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#87CEEB"));
		contentPane.setBounds(new Rectangle(0,0,480,640));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel picLabel = new JLabel();
		picLabel.setLocation(165, 100);
		picLabel.setSize(150, 150);
		picLabel.setIcon(new ImageIcon(new ImageIcon("assets/logo.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		contentPane.add(picLabel);
		
		JLabel lblNewLabel = new JLabel("Katabakuwu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 35, 456, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnStartGame = new ButtonPlay(game, "Start Game", 10, 306, 446, 60);
		contentPane.add(btnStartGame);
		
		JButton btnScoreboard = new ButtonScoreboard(game, "Scoreboard", 10, 386, 446, 60);
		contentPane.add(btnScoreboard);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSettings.setBounds(10, 466, 446, 60);
		contentPane.add(btnSettings);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		contentPane.add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		contentPane.add(cloud2);
		
		BGM_MainMenu bgm = new BGM_MainMenu();
		bgm.start();
	}
}
