package com.katabakuwu;

import javax.swing.*;
import javax.swing.border.*;

import com.katabakuwu.mainmenu.ButtonPlayGame;
import com.katabakuwu.mainmenu.ButtonScoreboard;
import com.katabakuwu.mainmenu.ButtonSetting;
import com.katabakuwu.mainmenu.Cloud;
import com.katabakuwu.mainmenu.GameTitle;
import com.katabakuwu.mainmenu.LabelLogo;
import com.katabakuwu.mainmenu.PanelSetting;
import com.katabakuwu.controller.Game;

import java.awt.*;

/**
 * FrameMainMenu class.
 * 
 * @author Farhan Arifandi
 * @author Ryan Garnet Andrianto
 */
public class PanelMainMenu extends JPanel {
	
	private PanelSetting panel;
	public boolean enabled;
	private JButton btnStartGame, btnScoreboard, btnSettings;
	
	private static final long serialVersionUID = 2883848038660074213L;
	/**
	 * Create the frame.
	 * 
	 */
	public PanelMainMenu(Game game) {
		setBackground(Color.decode("#87CEEB"));
		setBounds(new Rectangle(0,0,480,640));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		panel = new PanelSetting(this, game);
		add(panel);
		
		JLabel picLabel = new LabelLogo();
		add(picLabel);
		
		JLabel lblNewLabel = new GameTitle();
		add(lblNewLabel);
		
		/**
		 * Start game button.
		 */
		btnStartGame = new ButtonPlayGame(game, this);
		add(btnStartGame);
		
		btnScoreboard = new ButtonScoreboard(game, this);
		add(btnScoreboard);
		
		btnSettings = new ButtonSetting(game, this);
		add(btnSettings);
		
		JLabel cloud1 = new Cloud(50, 50, 200, 150, 1, 0, 480, 640);
		add(cloud1);
		
		JLabel cloud2 = new Cloud(-50, 250, 400, 250, 2, 0, 480, 640);
		add(cloud2);
		
		enabled = true;
	}
	
	public void showSetting() {
		setComponentZOrder(this.panel, 0);
		this.panel.setVisible(true);
		
		enabled = false;
		
		setButtonStatus();
	}
	
	public void setButtonStatus() {
		btnStartGame.setEnabled(enabled);
		btnScoreboard.setEnabled(enabled);
		btnSettings.setEnabled(enabled);
	}
}
