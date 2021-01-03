package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.mainmenu.Cloud;
import com.katabakuwu.controller.*;

import java.awt.*;

public class FrameScoreboard extends JFrame {

	private static final long serialVersionUID = 2883848038660074213L;
	private JPanel contentPane;

	public FrameScoreboard(Game game) {
		super("Katabakuwu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#87CEEB"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel profileImg = new JLabel();
		profileImg.setLocation(10, 10);
		profileImg.setSize(50, 50);
		profileImg.setIcon(new ImageIcon(new ImageIcon("assets/profileimg-placeholder.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		contentPane.add(profileImg);
		
		String tempString = "Lv. " + game.getUser().getLevel() + " " + game.getUser().getName();
		
		JLabel playerName = new JLabel(tempString);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Arial", Font.BOLD, 18));
		playerName.setBounds(70, 23, 205, 24);
		contentPane.add(playerName);
		
		JTextField titlePane = new JTextField();
		titlePane.setEditable(false);
		titlePane.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.setFont(new Font("Arial", Font.BOLD, 20));
		titlePane.setText("SCOREBOARD");
		titlePane.setBackground(new Color(255, 0, 255, 50));
		titlePane.setBounds(10, 70, 446, 39);
		contentPane.add(titlePane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"#1  Player", "#2  Player", "#3  Player", "#4  Player"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionModel(new DisabledItemSelectionModel());
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setVisibleRowCount(20);
		list.setBackground(new Color(192, 192, 192, 100));
		list.setBounds(10, 119, 446, 399);
		contentPane.add(list);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setBackground(Color.MAGENTA);
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeBtn.setBounds(10, 528, 446, 50);
		contentPane.add(closeBtn);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		contentPane.add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		contentPane.add(cloud2);
		
	}
}
