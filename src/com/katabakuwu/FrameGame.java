package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FrameGame extends JFrame {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 */
	public FrameGame() {
		super("Katabakuwu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel profileImg = new JLabel();
		profileImg.setLocation(10, 10);
		profileImg.setSize(72, 72);
		profileImg.setIcon(new ImageIcon(new ImageIcon("assets/profileimg-placeholder.jpg").getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH)));
		contentPane.add(profileImg);
		
		JLabel playerName = new JLabel("Lv. 1 Developer");
		playerName.setVerticalAlignment(SwingConstants.TOP);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Arial", Font.BOLD, 18));
		playerName.setBounds(92, 10, 205, 23);
		contentPane.add(playerName);
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setBackground(Color.LIGHT_GRAY);
		healthBar.setForeground(new Color(51, 204, 0));
		healthBar.setValue(80);
		healthBar.setBounds(92, 36, 146, 23);
		contentPane.add(healthBar);
		
		JProgressBar hintBar = new JProgressBar();
		hintBar.setBackground(Color.LIGHT_GRAY);
		hintBar.setForeground(Color.ORANGE);
		hintBar.setValue(60);
		hintBar.setBounds(92, 63, 146, 11);
		contentPane.add(hintBar);
		
		JLabel scoreLabel = new JLabel("00123456");
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		scoreLabel.setBounds(307, 10, 149, 49);
		contentPane.add(scoreLabel);
		
		JButton hintBtn = new JButton("?");
		hintBtn.setForeground(Color.WHITE);
		hintBtn.setBackground(Color.MAGENTA);
		hintBtn.setFont(new Font("Tahoma", Font.PLAIN, 48));
		hintBtn.setBounds(10, 292, 60, 60);
		contentPane.add(hintBtn);
		
		JTextField guessTextPane = new JTextField();
		guessTextPane.setHorizontalAlignment(SwingConstants.CENTER);
		guessTextPane.setFont(new Font("Arial", Font.PLAIN, 24));
		guessTextPane.setText("A_PL_P S_R_T");
		guessTextPane.setBackground(new Color(255, 0, 255, 50));
		guessTextPane.setBounds(10, 362, 446, 50);
		contentPane.add(guessTextPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 436, 450, 135);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel keyboardTop = new JPanel();
		GridBagConstraints gbc_keyboardTop = new GridBagConstraints();
		gbc_keyboardTop.insets = new Insets(0, 0, 5, 0);
		gbc_keyboardTop.fill = GridBagConstraints.BOTH;
		gbc_keyboardTop.gridx = 0;
		gbc_keyboardTop.gridy = 0;
		panel.add(keyboardTop, gbc_keyboardTop);
		keyboardTop.setLayout(new GridLayout(0, 10, 2, 0));
		
		JButton btnQ = new JButton("Q");
		btnQ.setFont(UIManager.getFont("Button.font"));
		btnQ.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnQ);
		
		JButton btnW = new JButton("W");
		btnW.setFont(UIManager.getFont("Button.font"));
		btnW.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnW);
		
		JButton btnE = new JButton("E");
		btnE.setFont(UIManager.getFont("Button.font"));
		btnE.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnE);
		
		JButton btnR = new JButton("R");
		btnR.setFont(UIManager.getFont("Button.font"));
		btnR.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnR);
		
		JButton btnT = new JButton("T");
		btnT.setFont(UIManager.getFont("Button.font"));
		btnT.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnT);
		
		JButton btnY = new JButton("Y");
		btnY.setFont(UIManager.getFont("Button.font"));
		btnY.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnY);
		
		JButton btnU = new JButton("U");
		btnU.setFont(UIManager.getFont("Button.font"));
		btnU.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnU);
		
		JButton btnI = new JButton("I");
		btnI.setFont(UIManager.getFont("Button.font"));
		btnI.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnI);
		
		JButton btnO = new JButton("O");
		btnO.setFont(UIManager.getFont("Button.font"));
		btnO.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnO);
		
		JButton btnP = new JButton("P");
		btnP.setFont(UIManager.getFont("Button.font"));
		btnP.setMargin(new Insets(0, 0, 0, 0));
		keyboardTop.add(btnP);
		
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
		
		JButton btnA = new JButton("A");
		btnA.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnA = new GridBagConstraints();
		gbc_btnA.fill = GridBagConstraints.BOTH;
		gbc_btnA.insets = new Insets(0, 0, 0, 5);
		gbc_btnA.gridx = 0;
		gbc_btnA.gridy = 0;
		keyboardMid.add(btnA, gbc_btnA);
		
		JButton btnS = new JButton("S");
		btnS.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.fill = GridBagConstraints.BOTH;
		gbc_btnS.insets = new Insets(0, 0, 0, 5);
		gbc_btnS.gridx = 1;
		gbc_btnS.gridy = 0;
		keyboardMid.add(btnS, gbc_btnS);
		
		JButton btnD = new JButton("D");
		btnD.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.fill = GridBagConstraints.BOTH;
		gbc_btnD.insets = new Insets(0, 0, 0, 5);
		gbc_btnD.gridx = 2;
		gbc_btnD.gridy = 0;
		keyboardMid.add(btnD, gbc_btnD);
		
		JButton btnF = new JButton("F");
		btnF.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnF = new GridBagConstraints();
		gbc_btnF.fill = GridBagConstraints.BOTH;
		gbc_btnF.insets = new Insets(0, 0, 0, 5);
		gbc_btnF.gridx = 3;
		gbc_btnF.gridy = 0;
		keyboardMid.add(btnF, gbc_btnF);
		
		JButton btnG = new JButton("G");
		btnG.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnG = new GridBagConstraints();
		gbc_btnG.fill = GridBagConstraints.BOTH;
		gbc_btnG.insets = new Insets(0, 0, 0, 5);
		gbc_btnG.gridx = 4;
		gbc_btnG.gridy = 0;
		keyboardMid.add(btnG, gbc_btnG);
		
		JButton btnH = new JButton("H");
		btnH.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnH = new GridBagConstraints();
		gbc_btnH.fill = GridBagConstraints.BOTH;
		gbc_btnH.insets = new Insets(0, 0, 0, 5);
		gbc_btnH.gridx = 5;
		gbc_btnH.gridy = 0;
		keyboardMid.add(btnH, gbc_btnH);
		
		JButton btnJ = new JButton("J");
		btnJ.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnJ = new GridBagConstraints();
		gbc_btnJ.fill = GridBagConstraints.BOTH;
		gbc_btnJ.insets = new Insets(0, 0, 0, 5);
		gbc_btnJ.gridx = 6;
		gbc_btnJ.gridy = 0;
		keyboardMid.add(btnJ, gbc_btnJ);
		
		JButton btnK = new JButton("K");
		btnK.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnK = new GridBagConstraints();
		gbc_btnK.fill = GridBagConstraints.BOTH;
		gbc_btnK.insets = new Insets(0, 0, 0, 5);
		gbc_btnK.gridx = 7;
		gbc_btnK.gridy = 0;
		keyboardMid.add(btnK, gbc_btnK);
		
		JButton btnL = new JButton("L");
		btnL.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnL = new GridBagConstraints();
		gbc_btnL.fill = GridBagConstraints.BOTH;
		gbc_btnL.gridx = 8;
		gbc_btnL.gridy = 0;
		keyboardMid.add(btnL, gbc_btnL);
		
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
		
		JButton btnZ = new JButton("Z");
		btnZ.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnZ = new GridBagConstraints();
		gbc_btnZ.fill = GridBagConstraints.BOTH;
		gbc_btnZ.insets = new Insets(0, 0, 0, 5);
		gbc_btnZ.gridx = 0;
		gbc_btnZ.gridy = 0;
		keyboardBtm.add(btnZ, gbc_btnZ);
		
		JButton btnX = new JButton("X");
		btnX.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.fill = GridBagConstraints.BOTH;
		gbc_btnX.insets = new Insets(0, 0, 0, 5);
		gbc_btnX.gridx = 1;
		gbc_btnX.gridy = 0;
		keyboardBtm.add(btnX, gbc_btnX);
		
		JButton btnC = new JButton("C");
		btnC.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 0, 5);
		gbc_btnC.gridx = 2;
		gbc_btnC.gridy = 0;
		keyboardBtm.add(btnC, gbc_btnC);
		
		JButton btnV = new JButton("V");
		btnV.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnV = new GridBagConstraints();
		gbc_btnV.fill = GridBagConstraints.BOTH;
		gbc_btnV.insets = new Insets(0, 0, 0, 5);
		gbc_btnV.gridx = 3;
		gbc_btnV.gridy = 0;
		keyboardBtm.add(btnV, gbc_btnV);
		
		JButton btnB = new JButton("B");
		btnB.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnB = new GridBagConstraints();
		gbc_btnB.fill = GridBagConstraints.BOTH;
		gbc_btnB.insets = new Insets(0, 0, 0, 5);
		gbc_btnB.gridx = 4;
		gbc_btnB.gridy = 0;
		keyboardBtm.add(btnB, gbc_btnB);
		
		JButton btnN = new JButton("N");
		btnN.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnN = new GridBagConstraints();
		gbc_btnN.fill = GridBagConstraints.BOTH;
		gbc_btnN.insets = new Insets(0, 0, 0, 5);
		gbc_btnN.gridx = 5;
		gbc_btnN.gridy = 0;
		keyboardBtm.add(btnN, gbc_btnN);
		
		JButton btnM = new JButton("M");
		btnM.setFont(UIManager.getFont("Button.font"));
		GridBagConstraints gbc_btnM = new GridBagConstraints();
		gbc_btnM.fill = GridBagConstraints.BOTH;
		gbc_btnM.insets = new Insets(0, 0, 0, 5);
		gbc_btnM.gridx = 6;
		gbc_btnM.gridy = 0;
		keyboardBtm.add(btnM, gbc_btnM);
	}
}
