package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.mainmenu.Cloud;
import com.katabakuwu.scoreboard.ScoreboardList;
import com.katabakuwu.scoreboard.ThreadScoreboard;
import com.katabakuwu.controller.*;
import com.katabakuwu.data.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FrameScoreboard class.
 * 
 * @author Farhan Arifandi
 * @author Ryan Garnet Andrianto
 */
public class PanelScoreboard extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelScoreboard(Game game) {
		setBackground(Color.decode("#87CEEB"));
		setBounds(new Rectangle(0,0,480,640));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		JLabel profileImg = new JLabel();
		profileImg.setLocation(10, 10);
		profileImg.setSize(50, 50);
		profileImg.setIcon(new ImageIcon(new ImageIcon("assets/profileimg-placeholder.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		add(profileImg);
		
		User user = game.getUser();
		String tempString = "Lv. " + user.getLevel() + " " + user.getName();
		
		JLabel playerName = new JLabel(tempString);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Arial", Font.BOLD, 18));
		playerName.setBounds(70, 23, 205, 24);
		add(playerName);
		
		JTextField titlePane = new JTextField();
		titlePane.setEditable(false);
		titlePane.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.setFont(new Font("Arial", Font.BOLD, 20));
		titlePane.setText("SCOREBOARD");
		titlePane.setBackground(Color.decode("#d5d5ff"));
		titlePane.setBounds(10, 70, 446, 39);
		add(titlePane);
		
		// Create Scoreboard List instance
		ScoreboardList sl = new ScoreboardList();
		
		JList<String> list = new JList<String>();
		list.setModel(sl);
		list.setSelectionModel(new DisabledItemSelectionModel());
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setVisibleRowCount(20);
		list.setBackground(Color.decode("#e8e8e8"));
		list.setBounds(10, 119, 446, 399);
		add(list);
		
		// Create Thread Scoreboard instance
		ThreadScoreboard ts = new ThreadScoreboard(list, sl);
		// Start the thread
		ts.start();

		/**
		 * Close button.
		 */
		JButton closeBtn = new JButton("Close");
		closeBtn.setForeground(Color.BLACK);
		closeBtn.setBackground(Color.decode("#dd55ff"));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeBtn.setBounds(10, 528, 446, 50);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Show main menu
				game.showMainMenu();
			}
		});
		add(closeBtn);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		add(cloud2);
		
	}
}
