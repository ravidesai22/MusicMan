package org.protech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class MusicMan implements Runnable{
	
	InputStreamReader input;
	
	// default voice is kevin16, may have to
	//private static final String VOICENAME = "kevin16";
	private static final String VOICENAME = "kevin";
	
	MusicMan(InputStreamReader ir){
		this.input = ir;
	}
	
	MusicMan(){}
	
	@Override
	public void run() {
		textToSpeech(input);
	}	

	void textToSpeech(InputStreamReader ir) {

		VoiceManager voiceManager = VoiceManager.getInstance();
		
		Voice voice = voiceManager.getVoice(VOICENAME);
		voice.allocate();

		// word per minute
		//voice.setRate(120);
		voice.setRate(240);
		
		//voice.setPitch(100);
		voice.setPitch(100);
		
		//Sets the voice style. This parameter is designed for human interpretation.
		//Values might include "business", "casual", "robotic", "breathy"
		voice.setStyle("breathy");

		
		BufferedReader br = new BufferedReader(ir);
		try {
			// Ready to speak
			voice.speak(br.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

	// do both simuntanously
	/*
	void textToSong(InputStreamReader ir) {
		VoiceManager voiceManager = VoiceManager.getInstance();
		SimplePlayer sp = new SimplePlayer();

		Voice voice = voiceManager.getVoice(VOICENAME);
		voice.allocate();

		// word per minute
		//voice.setRate(120);
		voice.setRate(240);
		
		
		voice.setPitch(100);

		System.out.print("Enter your text: ");
		// open up standard input
		BufferedReader br = new BufferedReader(ir);
		try {
			// Ready to speak
			voice.speak(br.readLine());
			sp.play();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	
	
	// getter-setter
	/*
	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	*/
}
