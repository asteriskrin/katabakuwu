package com.katabakuwu.gameplay;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreLabel extends JLabel {
	
	public ScoreLabel(JPanel contentPane, String scoreText) {
		
		JLabel scoreLabel = new JLabel(scoreText);
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		scoreLabel.setBounds(307, 10, 149, 49);
		contentPane.add(scoreLabel);
	}
}
