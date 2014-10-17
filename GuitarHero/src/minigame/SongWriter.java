package minigame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import ddf.minim.analysis.FFT;
import maingame.MusicPlayer;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class SongWriter extends PApplet{
	
	private MusicPlayer mp;
	private long startTime = 0;
	private String generationTextPath = "";
	private String mp3Path = "";
	
	FFT fft;
	
	@SuppressWarnings("static-access")
	public void setup() 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the path of the file to write beats to: ");
		generationTextPath = keyboard.next();
		System.out.println("Enter the path of the MP3 To analyze: ");
		mp3Path = keyboard.next();
		mp = new MusicPlayer(mp3Path, this);
		size(500, 500);
		frameRate(60);
		
		fft = new FFT(mp.getPlayer().bufferSize(), mp.getPlayer().sampleRate());
		fft.logAverages(60, 7);
		
		mp.startMusic();
		startTime = System.currentTimeMillis();
		stroke(255);
	}
	
	public void draw()
	{
		background(0);
		  int w = width / fft.avgSize();
		  strokeWeight(w);
		  strokeCap(SQUARE);
		  
		  fft.forward(mp.getPlayer().mix);
		  
		  for(int i = 0; i < fft.avgSize(); i++)
		  {
			  line(i * w + w/2, height, i * w + w/2, height - fft.getBand(i) * 4);
		  }
	}
	
	public void keyPressed()
	{
		if(key == CODED)
		{
			stroke( (int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
			if (keyCode == LEFT)
			{
				long time = System.currentTimeMillis() - this.startTime;
				try {
					writeToFile(generationTextPath, ""+time + " 1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (keyCode == DOWN)
			{
				long time = System.currentTimeMillis() - this.startTime;
				try {
					writeToFile(generationTextPath, ""+time + " 2");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (keyCode == RIGHT)
			{
				long time = System.currentTimeMillis() - this.startTime;
				try {
					writeToFile(generationTextPath, ""+time + " 3");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void writeToFile(String pathToGenerationFile, String beatsToPrint) throws IOException
	{
		PrintWriter out = null;
		try{
			out = new PrintWriter(new BufferedWriter(new FileWriter(pathToGenerationFile, true)));
		    out.println(beatsToPrint);
		}
		catch (IOException e)
		{
			System.out.println("File not written properly");
		}
		
		if(out != null)
		{
			out.close();
		}
	}

}
