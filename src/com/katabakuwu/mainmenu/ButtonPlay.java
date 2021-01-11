package com.katabakuwu.mainmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.katabakuwu.FrameGame;
import com.katabakuwu.controller.Game;

/**
 * ButtonPlay class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonPlay extends JButton implements ActionListener {
	private Game game;
	
	public ButtonPlay(Game game, String text, int x, int y, int width, int height) {
		super(text);
		
		this.game = game;
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setBounds(x, y, width, height);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FrameGame frame = new FrameGame(this.game);
			game.mf.getContentPane().removeAll();
			game.mf.setContentPane(frame);
			game.mf.revalidate();
			game.getWordDatabase().clearStatus();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
