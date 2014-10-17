package maingame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;

@SuppressWarnings("serial")
public class BeatAnalyzer extends PApplet{
	/**
	  * This sketch demonstrates how to play a file with Minim using an AudioPlayer. <br />
	  * It's also a good example of how to draw the waveform of the audio.
	  * <p>
	  * For more information about Minim and additional features, 
	  * visit http://code.compartmental.net/minim/
	  */

	Minim minim;
	AudioPlayer player;
	FFT fft;
	private String generationTextPath = "../Music/songGeneration.txt";
	private int counter = 0;

	public void setup()
	{
	  size(640, 480);
	  
	  // we pass this to Minim so that it can load files from the data directory
	  minim = new Minim(this);
	  
	  // loadFile will look in all the same places as loadImage does.
	  // this means you can find files that are in the data folder and the 
	  // sketch folder. you can also pass an absolute path, or a URL.
	  player = minim.loadFile("../Music/shortjingle.mp3");
	  fft = new FFT(player.bufferSize(), player.sampleRate());
	  fft.logAverages(60, 7);
	  System.out.println("center frequency: " + fft.getAverageCenterFrequency(1));
	  System.out.println("band width: " + fft.getAverageBandWidth(1));
	  
	  // play the file from start to finish.
	  // if you want to play the file again, 
	  // you need to call rewind() first.
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
	  
	  // draw the waveforms
	  // the values returned by left.get() and right.get() will be between -1 and 1,
	  // so we need to scale them up to see the waveform
	  // note that if the file is MONO, left.get() and right.get() will return the same value
//	  for(int i = 0; i < player.bufferSize() - 1; i++)
//	  {
//	    float x1 = map( i, 0, player.bufferSize(), 0, width );
//	    float x2 = map( i+1, 0, player.bufferSize(), 0, width );
//	    line( x1, 50 + player.left.get(i)*50, x2, 50 + player.left.get(i+1)*50 );
//	    line( x1, 150 + player.right.get(i)*50, x2, 150 + player.right.get(i+1)*50 );
//	  }
	  
	  for(int i = 0; i < fft.avgSize(); i++)
	  {
		  stroke(i+189, i + 100, i + 59);
		  line(i * w + w/2, height, i * w + w/2, height - fft.getBand(i) * 4);
		  //System.out.println(fft.getBand(40));
		  //System.out.println(i);
	  }
	  
	  if(counter % 20 == 0)
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
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
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
