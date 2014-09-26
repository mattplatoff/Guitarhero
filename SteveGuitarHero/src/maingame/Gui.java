package maingame;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;

public class Gui extends PApplet {
	
	/* NOTE -------------------------------------- NOTE
	 * Change this path variable to the absolute path of the text file on your computer
	 * or else it doesn't work for some reason. I'm gonna ask Mr. Horn for some help on this. */
	private static final String PATH =
			"/home/steve/Programming/repositories/Guitarhero/SteveGuitarHero/musicTextFiles/song1.txt";
	
	//private ScoreKeeper keeper;
	//File song = new File("musicTextFiles/song1");
	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	
	public void setup()
	{
//		System.out.println(song.exists());
		size(500, 500);
		frameRate(30);
		masterBeats = BeatHandler.getMasterBeatsWithParent(this, PATH);
		for (Beat beat : masterBeats)
		{
			beat.setParent(this);
		}
	}
	
	public void draw()
	{
		background(170);
		
		for (Beat b : masterBeats)
		{
			b.draw();
		}
	}
	
//	public void mouseClicked()
//	{
//		
//	}
//	
//	public void keyPressed()
//	{
//		
//	}

}