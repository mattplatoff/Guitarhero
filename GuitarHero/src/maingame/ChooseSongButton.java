package maingame;

import java.io.File;
import java.io.FileWriter;

import processing.core.PApplet;

public class ChooseSongButton extends Button {
	
	private String songPath = "";

	public ChooseSongButton(int x, int y, int width, int length,
			PApplet parent) {
		super(x, y, width, length, "Choose Song", parent);
		// TODO Auto-generated constructor stub
	}
	
	public String action()
	{
		super.getParent().selectInput("Choose MP3 File", "selectSong");
		return this.songPath;
	}
	
	public void selectSong(File fileSelected)
	{
		this.songPath = fileSelected.getAbsolutePath();
	}

}
