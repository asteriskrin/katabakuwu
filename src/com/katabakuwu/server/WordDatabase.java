package com.katabakuwu.server;

import java.util.ArrayList;
import java.util.Random;

/**
 * Word Database.
 * This class stores words.
 * 
 * @author Ryan Garnet Andrianto
 */
public class WordDatabase {
	private ArrayList<String> words;
	
	/**
	 * Constructor
	 */
	public WordDatabase() {
		words = new ArrayList<String>();
		words.add("APEL");
		words.add("JERUK");
		words.add("PISANG");
	}
	
	/**
	 * Get random word.
	 * 
	 * @return Word as string
	 */
	public String getRandomWord() {
		Random rand = new Random();
		
		int pos = rand.nextInt(words.size());
		
		return words.get(pos);
	}
}
