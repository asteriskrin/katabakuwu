package com.katabakuwu;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

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
					
					String name = JOptionPane.showInputDialog("Masukkan nama: ");
					while(name == null || name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
						name = JOptionPane.showInputDialog("Masukkan nama: ");
					}
					game.getUser().setName(name);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
