package com.katabaku.mainmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.katabakuwu.FrameGame;

/**
 * ButtonPlay class.
 * 
 * @author Ryan Garnet Andrianto
 */
public class ButtonPlay extends JButton implements ActionListener {
	public ButtonPlay(String text, int x, int y, int width, int height) {
		super(text);
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setBounds(x, y, width, height);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FrameGame frame = new FrameGame();
			frame.setVisible(true);
		} catch(Exception e2) {
			// do something here
		}
		
	}
}
