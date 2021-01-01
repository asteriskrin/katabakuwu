package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class FrameMainMenu extends JFrame {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 */
	public FrameMainMenu() {
		super("Katabakuwu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnStartGame = new JButton("Start Game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 306, 446, 60);
		contentPane.add(btnNewButton);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 386, 446, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnSettings = new JButton("Settings");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(10, 466, 446, 60);
		contentPane.add(btnNewButton_1_1);
	}
}
