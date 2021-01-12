package com.katabakuwu.gameplay;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClueField extends JTextField {
	public ClueField(int x, int y, int width, int height) {

		setBounds(x, y, width, height);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.PLAIN, 16));
		setEditable(false);
		setText("");
		setForeground(Color.BLACK);
		setBackground(new Color(255, 255, 255));
		setOpaque(false);
	}
}
