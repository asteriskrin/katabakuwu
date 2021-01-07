package com.katabakuwu.scoreboard;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractListModel;

/**
 * Scoreboard List class.
 * @author Ryan Garnet Andrianto
 */
public class ScoreboardList extends AbstractListModel<String> {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> items;
	
	/**
	 * Constructor
	 */
	public ScoreboardList() {
		items = new ArrayList<String>();
		items.add("Loading the scoreboard data...");
	}
	
	/**
	 * Update scoreboard data
	 * @throws MalformedURLException Exception when the user is not accessible
	 */
	public void updateData() throws MalformedURLException {
		URL url = new URL("https://katabakuwu.asteriskrin.my.id/getScoreboard.php");

		try {
			Scanner sc = new Scanner(url.openStream());
			items.clear();
			while (sc.hasNext()) {
				items.add(sc.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * In case, no connection.
	 */
	public void noConnection() {
		items.clear();
		items.add("No connection.");
	}

	@Override
	public int getSize() {
		return items.size();
	}

	@Override
	public String getElementAt(int index) {
		return items.get(index);
	}
}
