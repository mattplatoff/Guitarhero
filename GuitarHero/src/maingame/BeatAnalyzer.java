package maingame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;

@SuppressWarnings("serial")
public class BeatAnalyzer extends PApplet{
	Minim minim;
	AudioPlayer player;
	FFT fft;
	private String generationTextPath = "";
	private int counter = 0;

	public void setup()
	{
	  size(640, 480);
	  minim = new Minim(this);
	  
	  Scanner keyboard = new Scanner(System.in);
	  System.out.println("Enter the path of the file to write beats to: ");
	  generationTextPath = keyboard.next();
	  System.out.println("Enter the path of the MP3 To analyze: ");
	  String mp3Path = keyboard.next();
	  player = minim.loadFile(mp3Path);
	  fft = new FFT(player.bufferSize(), player.sampleRate());
	  fft.logAverages(60, 7);
	  
//	  System.out.println("center frequency: " + fft.getAverageCenterFrequency(1));
//	  System.out.println("band width: " + fft.getAverageBandWidth(1));
	  
	  keyboard.close();
	  
	  player.play();
	}

	public void draw()
	{
	  counter++;
	  background(0);
	  stroke(255);
	  int w = width / fft.avgSize();
	  strokeWeight(w);
	  strokeCap(SQUARE);
	  
	  fft.forward(player.mix);
	  
	  for(int i = 0; i < fft.avgSize(); i++)
	  {
		  stroke(i+189, i + 100, i + 59);
		  line(i * w + w/2, height, i * w + w/2, height - fft.getBand(i) * 4);
	  }
	  
	  if(counter % 25 == 0)
	  {
		  /*Bands to Check: 9, 30, 50*/
		  double lowBand = fft.getBand(9) + fft.getBand(11);
		  double midBand = (fft.getBand(30) + fft.getBand(32) + fft.getBand(34)) * 4;
		  double highBand = (fft.getBand(50) + fft.getBand(48) + fft.getBand(52)) * 8;
		  
		  if(lowBand > midBand && lowBand > highBand)
		  {
			  String stuff = ""+player.position() + " 1";
			  System.out.println(stuff);
			  try {
				writeToFile(generationTextPath, stuff);
			} catch (IOException e) {
				System.out.println(stuff);
			}
		  }
		  else if(midBand > lowBand && midBand > highBand)
		  {
			  String stuff = ""+player.position() + " 2";
			  System.out.println(stuff);
			  try {
				writeToFile(generationTextPath, stuff);
			} catch (IOException e) {
				System.out.println(stuff);
			}
		  }
		  else if(highBand > lowBand && highBand > midBand)
		  {
			  String stuff = ""+player.position() + " 3";
			  System.out.println(stuff);
			  try {
				writeToFile(generationTextPath, stuff);
			} catch (IOException e) {
				System.out.println(stuff);
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
