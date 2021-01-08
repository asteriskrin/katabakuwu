package com.katabakuwu.server;

import java.util.ArrayList;
import java.util.Random;

import com.katabakuwu.gameplay.Word;

/**
 * Word Database.
 * This class stores words.
 * @author Ryan Garnet Andrianto
 * @author FARHAN
 */
public class WordDatabase {
	private ArrayList<Word> words;
	
	/**
	 * Constructor
	 */
	public WordDatabase() {
		words = new ArrayList<Word>();
		words.add(new Word("APEL"));
		words.add(new Word("JERUK"));
		words.add(new Word("PISANG"));
		words.add(new Word("SEMANGKA"));
		words.add(new Word("PEPAYA"));
		words.add(new Word("JAMBU"));
		words.add(new Word("MANGGA"));
	}
	
	/**
	 * @return Word as string
	 */
	public Word getRandomWord() {
		Random rand = new Random();
		
		while(true) {
			int pos = rand.nextInt(words.size());
			if(!words.get(pos).getStatus()) {
				return words.get(pos);
			}
		}
	}
	
	public void clearStatus() {
		for(Word w : words) w.setStatus(false);
	}
}