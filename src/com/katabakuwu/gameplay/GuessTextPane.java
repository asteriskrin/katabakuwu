package com.katabakuwu.gameplay;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessTextPane extends JTextField{
	public GuessTextPane(int x, int y, int width, int height) {
		
		setBounds(x, y, width, height);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.PLAIN, 24));
		setEditable(false);
		
		setText("");
		setForeground(Color.BLACK);
		setBackground(new Color(255, 0, 255, 50));
	}
}
