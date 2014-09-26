package maingame;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import processing.core.PApplet;

public class TestApplet extends PApplet{
	
	static final String PATH =
			"/home/steve/Programming/repositories/Guitarhero/SteveGuitarHero/musicTextFiles/song1.txt";
	
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