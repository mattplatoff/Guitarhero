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
	  size(400, 400);

	  minim = new Minim(this);
	  player = minim.loadFile("H:\\git\\Guitarhero\\SteveGuitarHero\\Resources\\Vitamin String Quartet- Through The Fire And Flames (Dragonforce).mp3");
	  input = minim.getLineIn();
	}

<<<<<<< HEAD
	//test test
	public void draw(){ }
=======
	void draw(){ }
>>>>>>> branch 'master' of https://github.com/mattplatoff/Guitarhero.git

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
