package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.controller.Game;
import com.katabakuwu.data.Player;
import com.katabakuwu.gameplay.*;
import com.katabakuwu.mainmenu.Cloud;

import java.awt.*;

public class FrameGame extends JPanel {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * 
	 */
	public FrameGame(Game game) {
		//super();
		//setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		
		// Create Player class instance
		Player player = new Player();
		game.getUser().setPlayer(player);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#87CEEB"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel profileImg = new JLabel();
		profileImg.setLocation(10, 10);
		profileImg.setSize(72, 72);
		profileImg.setIcon(new ImageIcon(new ImageIcon("assets/profileimg-placeholder.jpg").getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH)));
		contentPane.add(profileImg);
		
		String tempString = "Lv. " + game.getUser().getLevel() + " " + game.getUser().getName();
		
		JLabel playerName = new JLabel(tempString);
		playerName.setVerticalAlignment(SwingConstants.TOP);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Arial", Font.BOLD, 18));
		playerName.setBounds(92, 10, 205, 23);
		contentPane.add(playerName);
		
		game.getUser().setLevelLabel(playerName);
		game.getUser().updateLevel();
		
		HealthBar healthBar = new HealthBar(game.getUser().getPlayer().getHealth(), 92, 36, 146, 23);
		contentPane.add(healthBar);
		player.getHealth().setBar(healthBar);
		
		HintBar hintBar = new HintBar(92, 63, 146, 11);
		contentPane.add(hintBar);
		player.getHint().setBar(hintBar);
		
		TimerBar timerBar = new TimerBar(game.getUser().getPlayer().getTimer(), 0, 0, this.getWidth(), 6);
		contentPane.add(timerBar);

		player.getHint().updateProgressBar();
		
		JLabel scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		scoreLabel.setBounds(307, 10, 149, 49);
		contentPane.add(scoreLabel);
		
		player.getScore().setLabel(scoreLabel);
		player.getScore().updateScore();
		
		ButtonHint hintBtn = new ButtonHint(game, 10, 292, 60, 60);
		contentPane.add(hintBtn);
		
		GuessTextField guessTextField = new GuessTextField(10, 362, 446, 50);
		contentPane.add(guessTextField);
		
		ClueField clueField = new ClueField(10, 170, 446, 50);
		contentPane.add(clueField);
		
		game.getUser().getPlayer().getGuessWord().setWord();
		game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessTextField, clueField);

		GameKeyboard gameKeyboard = new GameKeyboard(contentPane, game, guessTextField, clueField);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		contentPane.add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		contentPane.add(cloud2);

	}
}
