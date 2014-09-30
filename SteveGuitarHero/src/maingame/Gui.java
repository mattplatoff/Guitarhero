package maingame;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;

public class Gui extends PApplet {
	
	/* NOTE -------------------------------------- NOTE
	 * Change this path variable to the absolute path of the text file on your computer
	 * or else it doesn't work for some reason. I'm gonna ask Mr. Horn for some help on this. */
	private static final String PATH =
			"C:/Users/Chiru/Desktop/song1.txt";
	
	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	private ScoreKeeper keeper = new ScoreKeeper(this);
	
	public void setup()
	{
		size(500, 500);
		frameRate(60);
		masterBeats = BeatHandler.getMasterBeatsWithParent(this, PATH);
		for (Beat beat : masterBeats)
		{
			beat.setParent(this);
		}
	}
	
	public void draw()
	{
		background(170);
		keeper.draw();
		line(0, 400, 500, 400);
		
		for(int i = masterBeats.size() - 1; i >= 0; i--)
		{
			Beat b = masterBeats.get(i);
			b.draw();
			if(b.getPosition() > 400)
				masterBeats.remove(i);
		}
	}
	
	public void keyPressed()
	{
		if(masterBeats.size() != 0)
		{
			if(key == CODED)
			{
				keeper.updateScore(keyCode, masterBeats.get(masterBeats.size() - 1));
			}
		}
	}
}