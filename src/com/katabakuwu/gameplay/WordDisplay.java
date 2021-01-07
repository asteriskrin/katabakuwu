package com.katabakuwu.gameplay;

import javax.swing.JTextField;

import com.katabakuwu.controller.Game;

public class WordDisplay {
	private JTextField field;
	private Word word;
	private Game game;
	
	/**
	 * Constructor
	 * @param value Value
	 */
	public WordDisplay(Game game) {
		this.game = game;
		this.word = game.getWordDatabase().getRandomWord();
	}
	
	/**
	 * Set text field.
	 * 
	 * @param field
	 */
	public void setField(JTextField field) {
		this.field = field;
	}
	
	/**
	 * Set text field text.
	 * 
	 * @param field
	 */
	public void setFieldText(Game game) {
		game.getUser().getPlayer().getGuessWord().setWord(game.getWordDatabase().getRandomWord());
		game.getUser().getPlayer().getGuessWord().updateWordDisplay(this.field);
	}
	
	/**
	 * Get Word.
	 * 
	 * @return Word
	 */
	public Word getWord() {
		return this.word;
	}
	
	/**
	 * Set Word
	 * @param Word
	 */
	public void setWord() {
		this.word = game.getWordDatabase().getRandomWord();
	}
	
	/**
	 * Update text field
	 */
	public void updateField() {
		game.getUser().getPlayer().getGuessWord().setWord(this.word);
		game.getUser().getPlayer().getGuessWord().updateWordDisplay(this.field);
		if(game.getUser().getPlayer().getGuessWord().wordGuessed(this.word)) {
			this.word.setStatus(true);
			setFieldText(game);
		}
	}
}
