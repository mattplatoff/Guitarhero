package minigame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import maingame.MusicPlayer;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class SongWriter extends PApplet{
	
	private MusicPlayer mp;
	private long startTime = 0;
	private String allBeats = "";
	
	@SuppressWarnings("static-access")
	public void setup() 
	{
		mp = new MusicPlayer("../Music/test.mp3", this);
		size(500, 500);
		frameRate(60);
		mp.startMusic();
		startTime = System.currentTimeMillis();
	}
	
	public void draw()
	{
		background(1, 52, 64);
	}
	
	public void keyPressed()
	{
		if(key == CODED)
		{
			if (keyCode == LEFT)
			{
				System.out.println("keyPressed");
				long time = System.currentTimeMillis() - this.startTime;
				allBeats += time + " 1\n";
			}
			else if (keyCode == DOWN)
			{
				System.out.println("keyPressed");
				long time = System.currentTimeMillis() - this.startTime;
				allBeats += time + " 2\n";
			}
			else if (keyCode == RIGHT)
			{
				System.out.println("keyPressed");
				long time = System.currentTimeMillis() - this.startTime;
				allBeats += time + " 3\n";
			}
		}
		
		else if (key == 'w')
		{
			BufferedWriter writer = null;
			try
			{
			    writer = new BufferedWriter( new FileWriter( "../Music/songWriteTest.txt"));
			    writer.write(this.allBeats);
			    System.out.println("written");
			}
			catch ( IOException e)
			{
				System.out.println(allBeats);
			}
			finally
			{
			    try
			    {
			        if ( writer != null)
			        writer.close( );
			    }
			    catch ( IOException e)
			    {
			    }
			}
		}
	}

}
