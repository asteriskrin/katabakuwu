package com.katabakuwu;

import java.awt.EventQueue;

import com.katabakuwu.controller.Game;

public class Main {

	public static void main(String[] args) {
		System.out.println("Game is started.");
		
		Game game = new Game();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMainMenu frame = new FrameMainMenu(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
