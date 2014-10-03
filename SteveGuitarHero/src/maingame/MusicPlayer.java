package maingame;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer extends PApplet {
	
	Minim minim;
	AudioPlayer player;

	public void setup()
	{
	  size(400,400);

	  minim = new Minim(this);
	  player = minim.loadFile("../../Resources/test.mp3");
	  player.play();
	}

	public void draw()
	{ 
		background(0);
		stroke(255);
		  
		  // draw the waveforms
		  // the values returned by left.get() and right.get() will be between -1 and 1,
		  // so we need to scale them up to see the waveform
		  // note that if the file is MONO, left.get() and right.get() will return the same value
		  for(int i = 0; i < player.bufferSize() - 1; i++)
		  {
		    float x1 = map( i, 0, player.bufferSize(), 0, width );
		    float x2 = map( i+1, 0, player.bufferSize(), 0, width );
		    line( x1, 50 + player.left.get(i)*50, x2, 50 + player.left.get(i+1)*50 );
		    line( x1, 150 + player.right.get(i)*50, x2, 150 + player.right.get(i+1)*50 );
		  }
	}

	public void mousePressed()
	{
	  player.pause();
	}

	public void mouseReleased()
	{
	  player.play();
	}
}