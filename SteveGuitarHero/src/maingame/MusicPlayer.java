package maingame;

import java.io.File;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer
{
	
	Minim minim;
	private static AudioPlayer player;
	PApplet parent;

	public MusicPlayer(String path,PApplet parent)
	{
		this.parent=parent;
		minim = new Minim(parent);
		player = minim.loadFile(path);
	}
	

	public static void startMusic()
	{
		player.play();
	}
	
	public static void pauseMusic()
	{
	  player.pause();
	}
	public void generateTextFile(){
		
		double adv;
		char arrow;
		for(int i = 0; i < player.bufferSize() - 1; i++)
			
		  {
			adv=(player.left.get(i)+player.right.get(i))/2;
			if (adv<-.33)
				arrow='l';
				else if (adv<.33)
					arrow='m';
					else 
						arrow='r';
				
		  }
		
	}
	
}
