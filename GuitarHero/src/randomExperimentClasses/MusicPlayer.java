package randomExperimentClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer {

	Minim minim;
	private AudioPlayer player;
	PApplet parent;

	public MusicPlayer(String path, PApplet parent) {
		this.parent = parent;
		minim = new Minim(parent);
		player = minim.loadFile(path);
	}

	public void startMusic() {
		player.play();
	}

	public void pauseMusic() {
		player.pause();
	}

	public void generateTextFile(String path) throws IOException {
//		long time = System.currentTimeMillis();
//		double adv;
//		long ct;
//		int arrow;
//		PrintWriter writer = new PrintWriter(path, "UTF-8");
//		for (int i = 0; i < player.bufferSize() - 1; i+=1000)
//		{
//			ct = System.currentTimeMillis() - time;
//			adv = player.left.get(i);
//			if (adv < -.9) {
//				arrow = 1;
//				writer.println(ct + " " + arrow);
//			} else if (adv > .9) {
//				arrow = 2;
//				writer.println(ct + " " + arrow);
//			} else if (adv > -.1 && adv < .1) {
//				arrow = 3;
//				writer.println(ct + " " + arrow);
//			}
//
//		}
//		writer.close();
		int i = 0;
		while(i < player.bufferSize())
		{
			float value = player.mix.get(i);
			if(value > 0)
				System.out.println(value);
			i++;
		}
		
		System.out.println("length: " + player.length());
		System.out.println("last buffer: " + i);
		System.out.println(player.position());
	}
	
	public AudioPlayer getPlayer()
	{
		return this.player;
	}

}
