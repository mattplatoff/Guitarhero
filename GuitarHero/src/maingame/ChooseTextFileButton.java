package maingame;

import java.io.File;

import processing.core.PApplet;

public class ChooseTextFileButton extends Button {
	
	private String textFilePath = "";

	public ChooseTextFileButton(int x, int y, int width, int length,
			PApplet parent) {
		super(x, y, width, length, "Choose a Text File", parent);
		// TODO Auto-generated constructor stub
	}
	
	public String action()
	{
		super.getParent().selectInput("Select a text file", "textFileSelected");
		return textFilePath;
	}
	
	public void textFileSelected(File fileSelected)
	{
		this.textFilePath = fileSelected.getAbsolutePath();
	}
	
	

}
