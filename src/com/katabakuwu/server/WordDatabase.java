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
		words.add(new Word("APEL", "buah-buahan"));
		words.add(new Word("JERUK", "buah-buahan"));
		words.add(new Word("PISANG", "buah-buahan"));
		words.add(new Word("SEMANGKA", "buah-buahan"));
		words.add(new Word("PEPAYA", "buah-buahan"));
		words.add(new Word("JAMBU", "buah-buahan"));
		words.add(new Word("MANGGA", "buah-buahan"));
		words.add(new Word("RAMBUTAN", "buah-buahan"));
		words.add(new Word("DURIAN", "buah-buahan"));
		words.add(new Word("MELON", "buah-buahan"));
		words.add(new Word("SALAK", "buah-buahan"));
		words.add(new Word("NANAS", "buah-buahan"));
		words.add(new Word("TOMAT", "buah-buahan"));
		words.add(new Word("CABAI", "buah-buahan"));
		words.add(new Word("TERUNG", "buah-buahan"));
		
		words.add(new Word("KUBIS", "sayur-sayuran"));
		words.add(new Word("WORTEL", "sayur-sayuran"));
		words.add(new Word("SELADA", "sayur-sayuran"));
		words.add(new Word("ASPARAGUS", "sayur-sayuran"));
		words.add(new Word("BROKOLI", "sayur-sayuran"));
		words.add(new Word("SELEDRI", "sayur-sayuran"));
		words.add(new Word("SAWI", "sayur-sayuran"));
		words.add(new Word("BAYAM", "sayur-sayuran"));
		words.add(new Word("BAWANG MERAH", "sayur-sayuran"));
		words.add(new Word("BAWANG PUTIH", "sayur-sayuran"));
		words.add(new Word("BAWANG BOMBAI", "sayur-sayuran"));
		words.add(new Word("DAUN BAWANG", "sayur-sayuran"));
		words.add(new Word("BAWANG MERAH", "sayur-sayuran"));
		words.add(new Word("JAMUR", "sayur-sayuran"));
		words.add(new Word("JAGUNG", "sayur-sayuran"));
		words.add(new Word("LOBAK", "sayur-sayuran"));
		words.add(new Word("KENTANG", "sayur-sayuran"));
		
		words.add(new Word("MOTOR", "transportasi"));
		words.add(new Word("MOBIL", "transportasi"));
		words.add(new Word("BUS", "transportasi"));
		words.add(new Word("TRUK", "transportasi"));
		words.add(new Word("KERETA API", "transportasi"));
		words.add(new Word("BECAK", "transportasi"));
		words.add(new Word("HALTE", "transportasi"));
		words.add(new Word("PELABUHAN", "transportasi"));
		words.add(new Word("STASIUN", "transportasi"));
		words.add(new Word("KAPAL", "transportasi"));
		words.add(new Word("PESAWAT", "transportasi"));
		words.add(new Word("TAKSI", "transportasi"));
		words.add(new Word("ANGKOT", "transportasi"));
		words.add(new Word("BANDAR UDARA", "transportasi"));
		
		words.add(new Word("AYAH", "keluarga"));
		words.add(new Word("IBU", "keluarga"));
		words.add(new Word("KAKEK", "keluarga"));
		words.add(new Word("NENEK", "keluarga"));
		words.add(new Word("PAMAN", "keluarga"));
		words.add(new Word("BIBI", "keluarga"));
		words.add(new Word("KAKAK", "keluarga"));
		words.add(new Word("ADIK", "keluarga"));
		words.add(new Word("SEPUPU", "keluarga"));
		words.add(new Word("IPAR", "keluarga"));
		words.add(new Word("CUCU", "keluarga"));
		words.add(new Word("SUAMI", "keluarga"));
		words.add(new Word("ISTRI", "keluarga"));
		words.add(new Word("ANAK", "keluarga"));
		words.add(new Word("KEPONAKAN", "keluarga"));
		
		words.add(new Word("ROTI", "makanan"));
		words.add(new Word("NASI PUTIH", "makanan"));
		words.add(new Word("SATE", "makanan"));
		words.add(new Word("BURGER", "makanan"));
		words.add(new Word("AYAM GORENG", "makanan"));
		words.add(new Word("PIZA", "makanan"));
		words.add(new Word("TELUR", "makanan"));
		words.add(new Word("AYAM BAKAR", "makanan"));
		words.add(new Word("BAKSO", "makanan"));
		words.add(new Word("SOTO", "makanan"));
		words.add(new Word("MI AYAM", "makanan"));
		words.add(new Word("SEREAL", "makanan"));
		words.add(new Word("ES KRIM", "makanan"));
		words.add(new Word("SOSIS", "makanan"));
		
		words.add(new Word("PENSIL", "alat tulis"));
		words.add(new Word("PULPEN", "alat tulis"));
		words.add(new Word("KERTAS", "alat tulis"));
		words.add(new Word("SPIDOL", "alat tulis"));
		words.add(new Word("PENGGARIS", "alat tulis"));
		words.add(new Word("PENGHAPUS", "alat tulis"));
		words.add(new Word("LEM", "alat tulis"));
		words.add(new Word("BUKU TULIS", "alat tulis"));
		words.add(new Word("PAPAN TULIS", "alat tulis"));
		
		words.add(new Word("AMPLOP SURAT", "perkantoran"));
		words.add(new Word("METERAI", "perkantoran"));
		words.add(new Word("KOMPUTER", "perkantoran"));
		words.add(new Word("PAPAN TIK", "perkantoran"));
		words.add(new Word("MEJA KERJA", "perkantoran"));
		words.add(new Word("STEMPEL", "perkantoran"));
		words.add(new Word("FOTOKOPI", "perkantoran"));
		words.add(new Word("TELEPON", "perkantoran"));
		words.add(new Word("KALKULATOR", "perkantoran"));
		words.add(new Word("ARSIP", "perkantoran"));
		words.add(new Word("STAPLER", "perkantoran"));
		words.add(new Word("PEMINDAI", "perkantoran"));
		
		words.add(new Word("KUCING", "hewan"));
		words.add(new Word("ANJING", "hewan"));
		words.add(new Word("ULAR", "hewan"));
		words.add(new Word("KUDA", "hewan"));
		words.add(new Word("SAPI", "hewan"));
		words.add(new Word("AYAM", "hewan"));
		words.add(new Word("KAMBING", "hewan"));
		words.add(new Word("DOMBA", "hewan"));
		words.add(new Word("NYAMUK", "hewan"));
		words.add(new Word("LALAT", "hewan"));
		words.add(new Word("BABI", "hewan"));
		words.add(new Word("KECOA", "hewan"));
		words.add(new Word("KATAK", "hewan"));
		words.add(new Word("IKAN", "hewan"));
		words.add(new Word("KUDA LAUT", "hewan"));
		words.add(new Word("UBUR-UBUR", "hewan"));
		words.add(new Word("ANJING LAUT", "hewan"));
		words.add(new Word("SINGA", "hewan"));
		words.add(new Word("HARIMAU", "hewan"));
		words.add(new Word("PAUS", "hewan"));
		words.add(new Word("BELUT", "hewan"));
		words.add(new Word("BUAYA", "hewan"));
		words.add(new Word("KOMODO", "hewan"));
		words.add(new Word("CICAK", "hewan"));
		words.add(new Word("KADAL", "hewan"));
		words.add(new Word("LUMBA-LUMBA", "hewan"));
		words.add(new Word("JERAPAH", "hewan"));
		words.add(new Word("BADAK", "hewan"));
		words.add(new Word("PENGUIN", "hewan"));
		words.add(new Word("BURUNG", "hewan"));
		words.add(new Word("RUSA", "hewan"));
		words.add(new Word("KIJANG", "hewan"));
		words.add(new Word("BERUANG", "hewan"));
		words.add(new Word("GAJAH", "hewan"));
		words.add(new Word("KELELAWAR", "hewan"));
	}
	
	/**
	 * Get random word from database.
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
	
	/**
	 * Clear word status.
	 */
	public void clearStatus() {
		for(Word w : words) w.setStatus(false);
	}
}