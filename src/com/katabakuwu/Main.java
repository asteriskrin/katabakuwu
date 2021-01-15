package com.katabakuwu;

import java.awt.EventQueue;

import com.katabakuwu.controller.Game;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Game game = new Game();
				try {
					MainFrame frame = new MainFrame(game);
					frame.setVisible(true);
					game.showMainMenuLoading();
					game.startDataLoad();
				} catch(Exception e) {
					System.out.println("Error while showing main frame.");
				}
			}
		});
	}
}
