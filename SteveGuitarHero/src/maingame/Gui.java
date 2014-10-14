package maingame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Gui extends PApplet 
{
 
	
	private static String PATH = null;
	private static boolean pause;
	private ArrayList<Beat> masterBeats = new ArrayList<Beat>();
	private ScoreKeeper keeper = new ScoreKeeper(this);
	private String songPath;
	private MusicPlayer mp=null;
	private ArrayList<Integer> keys = new ArrayList<Integer>();

	public void setup() 
	{
		selectInput("Select a file to process: ", "fileSelected");
		selectInput("select a song to play", "songSelected");
		size(500, 500);
		frameRate(60);
		pause=false;
		try {
			mp.generateTextFile("H:\\git\\Guitarhero\\SteveGuitarHero\\Music\\song1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void songSelected(File song) {
		if (song == null) {
			println("Window was closed or the user hit cancel.");
		} else{

		songPath = song.getAbsolutePath();
		mp=new MusicPlayer(songPath,this);
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
		mp.startMusic();
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
				boolean keyHit = keeper.updateScore(keyCode, masterBeats.get(masterBeats.size() - 1));
				if (keyHit)
					masterBeats.remove(masterBeats.size() - 1);
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
