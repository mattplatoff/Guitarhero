package maingame;
import java.io.BufferedReader;
import java.io.IOException;

import processing.core.PApplet;

public class blah extends PApplet{
	
	static final String PATH = "song1.txt";
	
//	public static void main(String[] args)
//	{
//		BeatHandler.getMasterBeatsNoParent(PATH);
//	}
	
	public void setup()
	{
		BufferedReader br = this.createReader(PATH);
		String line = null;
		try
		{
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}