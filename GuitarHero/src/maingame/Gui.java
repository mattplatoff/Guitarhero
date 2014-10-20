package maingame;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Gui extends PApplet 
{
	
	private static Color LEFT_COLOR = new Color(255, 0, 103);
	private static Color CENTER_COLOR = new Color(0, 177, 177);
	private static Color RIGHT_COLOR = new Color(176, 241, 0);
	
	private static String songTextPath = "../Music/songGeneration.txt";
	private static boolean pause;
	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	private ScoreKeeper keeper = new ScoreKeeper(this);
	private String songPath = "../Music/test.mp3";
	private MusicPlayer mp=null;

	@SuppressWarnings("static-access")
	public void setup() 
	{
	//selectInput("Select a file to process: ", "fileSelected");
	//selectInput("select a song to play", "songSelected");
		saveBeats(songTextPath);
		mp = new MusicPlayer(songPath, this);
		size(500, 500);
		frameRate(50);
		pause=false;
		mp.startMusic();
	}

	public void songSelected(File song) {
		if (song == null) {
			println("Window was closed or the user hit cancel.");
		} else{

		songPath = song.getAbsolutePath();
		mp=new MusicPlayer(songPath,this);
		}
	}

	@SuppressWarnings("static-access")
	public void fileSelected(File fileSelected) {
		if (fileSelected == null) {
			println("Window was closed or the user hit cancel.");
		} else {
			songTextPath = fileSelected.getAbsolutePath();
			masterBeats = BeatHandler.getMasterBeatsWithParent(this, songTextPath);
			for (Beat beat : masterBeats) {
				beat.setParent(this);
			}
		}
		mp.startMusic();
	}
	
	public void saveBeats(String songTextFile)
	{
		masterBeats = BeatHandler.getMasterBeatsWithParent(this, songTextPath);
		for (Beat beat : masterBeats) {
			beat.setParent(this);
		}
	}

	public void draw() {
		this.background(0);
		keeper.draw();
		stroke(255);
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
		if(masterBeats.size() != 0 && !pause)
		{
			if(key == CODED)
			{
				boolean keyHit = keeper.updateScore(keyCode, masterBeats.get(0));
				if (keyHit)
					masterBeats.remove(0);
			}
		}
		
		if((key == 'p' || key== 'P') && !pause){
			pause=true;
			MusicPlayer.pauseMusic();
		}
		else
		if(key == 'p' && pause){
			pause=false;
			MusicPlayer.startMusic();
		}
	}
	
	public static boolean pauseState(){
		return pause;
	}
}
