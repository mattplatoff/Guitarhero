package maingame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;

public class BeatHandler {
	
	private PApplet myParent;
	
	public BeatHandler(PApplet parent) {
		
		this.myParent = parent;
		
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<Beat> getMasterBeats(String path)
	{
		File musicTextFile = new File(path);
		ArrayList<Beat> masterBeats = new ArrayList<Beat>();
		BufferedReader bReader = null;
		
		try
		{
			bReader = new BufferedReader(new FileReader(musicTextFile));
		}
		catch (FileNotFoundException e1)
		{
			System.out.println("File Not Found ");
		} 
		String line;
		try
		{
			while(bReader != null && (line = bReader.readLine()) != null)
			{
//				String[] parts = line.split("\\s");
//				masterBeats.add(new Beat(Integer.parseInt(parts[0]),
//						Integer.parseInt(parts[1]),
//						Integer.parseInt(parts[0])));
				
				System.out.println(line);
			}
			bReader.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage() + "Error Reading File");
		}
		
		return masterBeats;
	}
	
//	public static void main(String[] args)
//	{
//		getMasterBeats("musicTextFiles/song1");
//	}
	
}
