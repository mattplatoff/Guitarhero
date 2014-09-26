package maingame;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;

public class Gui extends PApplet {
	
	//private ScoreKeeper keeper;
	//File song = new File("musicTextFiles/song1");
	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	
	public void setup()
	{
//		System.out.println(song.exists());
		size(500, 500);
		frameRate(30);
		masterBeats = BeatHandler.getMasterBeatsWithParent(this, "musicTextFiles/song1.txt");
	}
	
	public void draw()
	{
		background(255);
		for (Beat beat : masterBeats)
		{
			beat.setParent(this);
		}
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