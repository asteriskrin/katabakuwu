package com.katabakuwu;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		System.out.println("Game is started.");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMainMenu frame = new FrameMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
