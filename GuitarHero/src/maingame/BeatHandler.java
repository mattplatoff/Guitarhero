package maingame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * The beat handler reads in the beats from a text file. It will read the values and then create an arraylist of beats from
 * the text file
 */
public class BeatHandler {
	
	/**
	 * This method reads a text file of beats, reads the text file and stores the beats into an arraylist of beats
	 * @param path - the path of the text file
	 * @return - an arraylist of beats
	 */
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
	
	/**
	 * This method get the master list of beats just like the previous method except it does them with the PApplet
	 * @param parent - PApplet
	 * @param path - path of the file
	 * @return - the arraylist of beatss
	 */
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
