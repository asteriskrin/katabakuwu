package com.katabakuwu;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import com.katabakuwu.controller.Game;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Game game = new Game();
				try {
					MainFrame frame = new MainFrame(game);
					frame.setVisible(true);
				} catch(Exception e) {
					System.out.println("Error while showing main frame.");
				}
				String name = JOptionPane.showInputDialog("Halo!\r\nSelamat datang di KatabakUWU.\n\nHarap tulis nama kamu di bawah ini!");
				while(name == null || name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
					name = JOptionPane.showInputDialog("Masukkan nama: ");
				}
				game.getUser().setName(name);
			}
		});
	}

}
