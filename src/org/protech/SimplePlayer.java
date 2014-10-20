package org.protech;

import java.io.FileInputStream;

//import javax.sound.sampled.AudioFormat;
//import javazoom.jl.player.Player;

import sun.audio.*;

public class SimplePlayer implements Runnable {

	@Override
	public void run() {
		play();		
	}
	
	public void play(){
		try {
			//FileInputStream fis = new FileInputStream("D:\\Eclipse_WS\\MusicMan\\testMusic.wav");
			//Player playMP3 = new Player(fis);
			//playMP3.play();
			
			AudioPlayer ap = AudioPlayer.player;
			AudioStream BGM;
			AudioData ad;

			ContinuousAudioDataStream loop = null; 
			
			//BGM = new AudioStream(new FileInputStream("D:\\Eclipse_WS\\MusicMan\\testMusic.wav"));
			BGM = new AudioStream(new FileInputStream("testMusic.wav"));
			//ad = BGM.getData();
			//loop = new ContinuousAudioDataStream(ad);
			
			
			//ap.start(loop);
			ap.start(BGM);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
