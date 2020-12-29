package com.katabakuwu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FrameMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Katabakuwu");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
		lblNewLabel.setBounds(125, 22, 147, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setBounds(10, 306, 376, 42);
		contentPane.add(btnNewButton);
	}
}
