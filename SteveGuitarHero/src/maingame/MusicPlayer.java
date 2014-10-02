package maingame;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer extends PApplet {
	
	Minim minim;
	AudioPlayer player;
	AudioInput input;

	public void setup()
	{
	  //let's make the window a little bigger
	  size(400,400);

	  minim = new Minim(null);
	  player = minim.loadFile("../..//Resources//test.mp3");
	  input = minim.getLineIn();
	}

	public void draw(){ }

	public void mousePressed()
	{
	  player.play();
	}

	public void mouseReleased()
	{
	  player.close();

	  //since close closes the file, we'll load it again
	  player = minim.loadFile("song.mp3");
	}
}