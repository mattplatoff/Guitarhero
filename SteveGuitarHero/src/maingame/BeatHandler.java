package maingame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;

public class BeatHandler {
	
	@SuppressWarnings("resource")
	public static ArrayList<Beat> getMasterBeatsNoParent(String path) throws IOException
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
		while(bReader != null && (line = bReader.readLine()) != null)
		{
//				String[] parts = line.split("\\s");
//				masterBeats.add(new Beat(Integer.parseInt(parts[0]),
//						Integer.parseInt(parts[1]),
//						Integer.parseInt(parts[0])));
			
			System.out.println(line);
		}
		bReader.close();
		
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
				masterBeats.add(new Beat(Integer.parseInt(parts[0]),
						Integer.parseInt(parts[1]),
						Integer.parseInt(parts[0])));
			}
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
