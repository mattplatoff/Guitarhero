package randomExperimentClasses;

import java.io.IOException;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class MusicPlayerTest extends PApplet{
	
	private String songPath = "../Music/test.mp3";
	MusicPlayer mp = new MusicPlayer(songPath, this);
	
	public void setup()
	{
		size(200, 200);
		mp.startMusic();
		try
		{
			mp.generateTextFile("../Music/generationTest.txt");
		}
		catch (IOException e) {}
	}
	
	public void draw()
	{
		background(1, 52, 64);
		
	}

}
