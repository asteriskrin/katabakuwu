package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.controller.Game;
import com.katabakuwu.data.Player;
import com.katabakuwu.gameplay.*;
import com.katabakuwu.mainmenu.Cloud;

import java.awt.*;
import java.util.ArrayList;

/**
 * Gameplay panel.
 */
public class FrameGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<HintObject> hintObjects = new ArrayList<HintObject>();
	
	public FrameGame(Game game) {
		setBackground(Color.decode("#87CEEB"));
		setBounds(new Rectangle(0,0,480,640));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		JLabel profileImg = new JLabel();
		profileImg.setLocation(10, 10);
		profileImg.setSize(72, 72);
		profileImg.setIcon(new ImageIcon(new ImageIcon("assets/profileimg-placeholder.jpg").getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH)));
		add(profileImg);
		
		String tempString = "Lv. " + game.getUser().getLevel() + " " + game.getUser().getName();
		
		JLabel playerName = new JLabel(tempString);
		playerName.setVerticalAlignment(SwingConstants.TOP);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Arial", Font.BOLD, 18));
		playerName.setBounds(92, 10, 205, 23);
		add(playerName);
		
		Player player = game.getUser().getPlayer();
		
		game.getUser().setLevelLabel(playerName);
		game.getUser().updateLevel();
		
		HealthBar healthBar = new HealthBar(game.getUser().getPlayer().getHealth(), 92, 36, 146, 23);
		add(healthBar);
		player.getHealth().setBar(healthBar);
		
		HintBar hintBar = new HintBar(92, 63, 146, 11);
		add(hintBar);
		player.getHint().setBar(hintBar);
		
		TimerBar timerBar = new TimerBar(game.getUser().getPlayer().getTimer(), 0, 0, this.getWidth(), 6);
		add(timerBar);

		player.getHint().updateProgressBar();
		
		JLabel scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		scoreLabel.setBounds(307, 10, 149, 49);
		add(scoreLabel);
		
		player.getScore().setLabel(scoreLabel);
		player.getScore().updateScore();
		
		ButtonHint hintBtn = new ButtonHint(this, game, 10, 292, 60, 60);
		add(hintBtn);
		player.getHint().setButton(hintBtn);
		
		GuessTextField guessTextField = new GuessTextField(10, 362, 446, 50);
		guessTextField.setBounds(10, 362, 446, 50);
		add(guessTextField);
		
		ClueField clueField = new ClueField(196, 333, 260, 30);
		clueField.setBounds(290, 333, 166, 30);
		add(clueField);
		
		game.getUser().getPlayer().getGuessWord().setWord();
		game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessTextField, clueField);

		GameKeyboard gameKeyboard = new GameKeyboard(this, game, guessTextField, clueField);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		add(cloud2);
	}
	
	public void addHintObject(char hintChar) {
		HintObject ho = new HintObject(this, hintChar, -50, 100, 60, 60);
		hintObjects.add(ho);
		ho.startMoving();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(HintObject ho : hintObjects) {
			ho.draw(g);
		}
	}
}
