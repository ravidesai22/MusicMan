package org.protech;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		// open up standard input
		// InputStreamReader ir = new InputStreamReader(System.in);
		InputStreamReader ir;

		try {
			ir = new InputStreamReader(new FileInputStream("input.txt"));

			MusicMan mm = new MusicMan(ir);
			// mm.textToSpeech(ir);
			Thread sing = new Thread(mm);

			SimplePlayer sp = new SimplePlayer();
			Thread music = new Thread(sp);

			music.start();
			sing.start();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
