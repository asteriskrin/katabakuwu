package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.controller.Game;
import com.katabakuwu.data.Player;
import com.katabakuwu.gameplay.*;
import com.katabakuwu.mainmenu.Cloud;

import java.awt.*;

public class FrameGame extends JFrame {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * 
	 */
	public FrameGame(Game game) {
		super("Katabakuwu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		
		// Create Player class instance
		Player player = new Player();
		game.getUser().setPlayer(player);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#87CEEB"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		HealthBar healthBar = new HealthBar(game.getUser().getPlayer().getHealth(), 92, 36, 146, 23);
		contentPane.add(healthBar);
		player.getHealth().setBar(healthBar);
		
		HintBar hintBar = new HintBar(92, 63, 146, 11);
		contentPane.add(hintBar);
		player.getHint().setBar(hintBar);
		
		TimerBar timerBar = new TimerBar(game.getUser().getPlayer().getTimer(), 0, 0, this.getWidth(), 6);
		contentPane.add(timerBar);

		player.getHint().updateProgressBar();
		game.getUser().getPlayer().getGuessWord().setWord(game.getWordDatabase().getRandomWord());
		String scoreText = Integer.toString(game.getUser().getPlayer().getScore());
		
		JLabel scoreLabel = new JLabel(scoreText);
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		scoreLabel.setBounds(307, 10, 149, 49);
		contentPane.add(scoreLabel);
		
		ButtonHint hintBtn = new ButtonHint(game, 10, 292, 60, 60);
		contentPane.add(hintBtn);
		
		JTextField guessTextPane = new JTextField();
		guessTextPane.setEditable(false);
		guessTextPane.setHorizontalAlignment(SwingConstants.CENTER);
		guessTextPane.setFont(new Font("Arial", Font.PLAIN, 24));
		
		guessTextPane.setText("");
		guessTextPane.setBackground(new Color(255, 0, 255, 50));
		guessTextPane.setBounds(10, 362, 446, 50);
		contentPane.add(guessTextPane);
		
		game.getUser().getPlayer().getGuessWord().updateWordDisplay(guessTextPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#89cc9b"));
		panel.setBounds(10, 436, 450, 135);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		ButtonKeyHandler buttonKeyHandler = new ButtonKeyHandler(game, guessTextPane);
		
		JPanel keyboardTop = new JPanel();
		GridBagConstraints gbc_keyboardTop = new GridBagConstraints();
		gbc_keyboardTop.insets = new Insets(0, 0, 5, 0);
		gbc_keyboardTop.fill = GridBagConstraints.BOTH;
		gbc_keyboardTop.gridx = 0;
		gbc_keyboardTop.gridy = 0;
		panel.add(keyboardTop, gbc_keyboardTop);
		keyboardTop.setLayout(new GridLayout(0, 10, 2, 0));
		
		char[] keyChars0 = {
			'Q','W','E','R','T','Y','U','I','O','P'	
		};
		
		for(char c : keyChars0) {
			JButton btnQ = new JButton(String.valueOf(c));
			btnQ.setFont(UIManager.getFont("Button.font"));
			btnQ.setMargin(new Insets(0, 0, 0, 0));
			keyboardTop.add(btnQ);
			btnQ.addActionListener(buttonKeyHandler);
		}
		
		JPanel keyboardMid = new JPanel();
		GridBagConstraints gbc_keyboardMid = new GridBagConstraints();
		gbc_keyboardMid.insets = new Insets(0, 0, 5, 0);
		gbc_keyboardMid.fill = GridBagConstraints.BOTH;
		gbc_keyboardMid.gridx = 0;
		gbc_keyboardMid.gridy = 1;
		panel.add(keyboardMid, gbc_keyboardMid);
		GridBagLayout gbl_keyboardMid = new GridBagLayout();
		gbl_keyboardMid.columnWidths = new int[] {45};
		gbl_keyboardMid.rowHeights = new int[]{40, 0};
		gbl_keyboardMid.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_keyboardMid.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		keyboardMid.setLayout(gbl_keyboardMid);
		
		char[] keyChars1 = {
			'A','S','D','F','G','H','J','K','L'	
		};
		
		for(int i = 0; i < keyChars1.length; i++) {
			JButton btnA = new JButton(String.valueOf(keyChars1[i]));
			btnA.setFont(UIManager.getFont("Button.font"));
			GridBagConstraints gbc_btnA = new GridBagConstraints();
			gbc_btnA.fill = GridBagConstraints.BOTH;
			gbc_btnA.insets = new Insets(0, 0, 0, 5);
			gbc_btnA.gridx = i;
			gbc_btnA.gridy = 0;
			keyboardMid.add(btnA, gbc_btnA);
			btnA.addActionListener(buttonKeyHandler);
			
		}
		
		JPanel keyboardBtm = new JPanel();
		GridBagConstraints gbc_keyboardBtm = new GridBagConstraints();
		gbc_keyboardBtm.fill = GridBagConstraints.BOTH;
		gbc_keyboardBtm.gridx = 0;
		gbc_keyboardBtm.gridy = 2;
		panel.add(keyboardBtm, gbc_keyboardBtm);
		GridBagLayout gbl_keyboardBtm = new GridBagLayout();
		gbl_keyboardBtm.columnWidths = new int[] {45};
		gbl_keyboardBtm.rowHeights = new int[]{40, 0};
		gbl_keyboardBtm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_keyboardBtm.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		keyboardBtm.setLayout(gbl_keyboardBtm);
		
		char[] keyChars2 = {
			'Z','X','C','V','B','N','M'	
		};
		
		for(int i = 0; i < keyChars2.length; i++) {
			JButton btnZ = new JButton(String.valueOf(keyChars2[i]));
			btnZ.setFont(UIManager.getFont("Button.font"));
			GridBagConstraints gbc_btnZ = new GridBagConstraints();
			gbc_btnZ.fill = GridBagConstraints.BOTH;
			gbc_btnZ.insets = new Insets(0, 0, 0, 5);
			gbc_btnZ.gridx = i;
			gbc_btnZ.gridy = 0;
			keyboardBtm.add(btnZ, gbc_btnZ);
			btnZ.addActionListener(buttonKeyHandler);
		}
		
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		contentPane.add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		contentPane.add(cloud2);
		
		KeyboardHandler keyboardHandler = new KeyboardHandler(game, guessTextPane);
		this.addKeyListener(keyboardHandler);
		this.setFocusable(true);
	}
}
