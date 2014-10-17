package maingame;

import processing.core.PApplet;

public class EnterMinigameButton extends Button {

	public EnterMinigameButton(int x, int y, int width, int length,
			PApplet parent) {
		super(x, y, width, length, "Enter Songwriter Minigame", parent);
		// TODO Auto-generated constructor stub
	}
	
	public String action()
	{
		return "minigame";
	}
	
	

}
