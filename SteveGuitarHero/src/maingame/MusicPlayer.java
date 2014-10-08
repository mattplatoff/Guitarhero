package maingame;

import java.io.File;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer  {
	
	Minim minim;
	AudioPlayer player;


	public MusicPlayer(String path){
		
		minim = new Minim(this);
		player = minim.loadFile(path);
		player.play();
	}
	

	public void startMusic(){
		player.play();
	}
	
	public void pauseMusic()
	{
	  player.pause();
	}

	
}
