package maingame;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import processing.core.PApplet;
//test
public class Gui extends PApplet {
 
	/*
	 * NOTE -------------------------------------- NOTE Change this path
	 * variable to the absolute path of the text file on your computer or else
	 * it doesn't work for some reason. I'm gonna ask Mr. Horn for some help on
	 * this.
	 */
	private static String PATH = null;

	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	private ScoreKeeper keeper = new ScoreKeeper(this);
	private String songPath;
	private MusicPlayer mp=null;

	public void setup() {
		selectInput("select a song to play", "songSelected");
		selectInput("Select a file to process: ", "fileSelected");
		size(500, 500);
		frameRate(60);

	}

	public void songSelected(File song) {
		if (song == null) {
			println("Window was closed or the user hit cancel.");
		} else{

		songPath = song.getAbsolutePath();
		
		mp=new MusicPlayer(songPath);
		}
	}

	public void fileSelected(File fileSelected) {
		if (fileSelected == null) {
			println("Window was closed or the user hit cancel.");
		} else {
			PATH = fileSelected.getAbsolutePath();
			masterBeats = BeatHandler.getMasterBeatsWithParent(this, PATH);
			for (Beat beat : masterBeats) {
				beat.setParent(this);
			}
		}
	}

	public void draw() {
		this.background(255, 158, 38);
		keeper.draw();
		line(0, 400, 500, 400);

		for (int i = masterBeats.size() - 1; i >= 0; i--) {
			Beat b = masterBeats.get(i);
			b.draw();
			if (b.getPosition() > 400)
				masterBeats.remove(i);
		}
	}


	
	
	public void keyPressed()
	{
		if(masterBeats.size() != 0)
		{
			if(key == CODED)
			{
				boolean keyHit = keeper.updateScore(keyCode, masterBeats.get(masterBeats.size() - 1));
				if (keyHit)
					masterBeats.remove(masterBeats.size() - 1);

			}
		}
	}
}
