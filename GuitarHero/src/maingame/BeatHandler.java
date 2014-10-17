package maingame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import processing.core.PApplet;

public class BeatHandler {
	
	@SuppressWarnings("resource")
	public static ArrayList<Beat> getMasterBeatsNoParent(String path)
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
	
	public static ArrayList<Beat> getMasterBeatsWithParent(PApplet parent, String path)
	{
		ArrayList<Beat> masterBeats = new ArrayList<Beat>();
		BufferedReader reader = parent.createReader(path);
		
		String line = null;
		
		try
		{
			while(reader != null && (line = reader.readLine()) != null)
			{
				String[] parts = line.split("\\s");
				int note = Integer.parseInt(parts[1]);
				int time = Integer.parseInt(parts[0]) / 10;
				masterBeats.add(new Beat(note,
						time, 2));
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage() + "Error Reading File");
		}
		
		return masterBeats;
	}
}
