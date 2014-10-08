package maingame;

import java.io.File;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer  {
	
	Minim minim;
	AudioPlayer player;

	String path;
	public MusicPlayer(String path){
		this.path=path;
		minim = new Minim(this);
		player = minim.loadFile(path);
		player.play();
	}
	public void startMusic()
	{ }


	public void setup()
	{


	  minim = new Minim(this);
	  player = minim.loadFile("../../Resources/test.mp3");

	  player.play();
	}

	
	public void pauseMusic()
	{
	  player.pause();
	}

	
}
