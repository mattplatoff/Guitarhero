package maingame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ddf.minim.*;
import processing.core.PApplet;

public class MusicPlayer {

	Minim minim;
	private static AudioPlayer player;
	PApplet parent;

	public MusicPlayer(String path, PApplet parent) {
		this.parent = parent;
		minim = new Minim(parent);
		player = minim.loadFile(path);
	}

	public static void startMusic() {
		player.play();
	}

	public static void pauseMusic() {
		player.pause();
	}

	public void generateTextFile(String path) throws IOException {
		long time = System.currentTimeMillis();
		double adv;
		long ct;
		int arrow;
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		for (int i = 0; i < player.bufferSize() - 1; i+=1000)
		{
			ct = System.currentTimeMillis() - time;
			adv = player.left.get(i);
			if (adv < -.9) {
				arrow = 1;
				writer.println(ct + " " + arrow);
			} else if (adv > .9) {
				arrow = 2;
				writer.println(ct + " " + arrow);
			} else if (adv > -.1 && adv < .1) {
				arrow = 3;
				writer.println(ct + " " + arrow);
			}

		}
		writer.close();
	}

}
