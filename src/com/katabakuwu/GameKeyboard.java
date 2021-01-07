package com.katabakuwu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.katabakuwu.controller.Game;
import com.katabakuwu.gameplay.ButtonKeyHandler;
import com.katabakuwu.gameplay.KeyboardHandler;
import com.katabakuwu.gameplay.Word;

public class GameKeyboard extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3469049637633070238L;
	public ArrayList<JButton> keyboard;
	
	public GameKeyboard(JPanel contentPane, Game game, JTextField guessTextPane) {
		
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
		
		ButtonKeyHandler buttonKeyHandler = new ButtonKeyHandler(game, guessTextPane, this);
		
		keyboard = new ArrayList<JButton>();
		
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
			keyboard.add(btnQ);
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
			keyboard.add(btnA);
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
			keyboard.add(btnZ);
		}
		
		KeyboardHandler keyboardHandler = new KeyboardHandler(game, guessTextPane);
		this.addKeyListener(keyboardHandler);
		this.setFocusable(true);
	}
}