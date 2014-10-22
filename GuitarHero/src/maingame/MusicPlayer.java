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
/**
 * Creates a music player object with a PApplet as a parent and a path to the music file
 * @param path path to music file
 * @param parent PApplet the music player is being called it
 * 
 */
	public MusicPlayer(String path, PApplet parent) {
		this.parent = parent;
		minim = new Minim(parent);
		player = minim.loadFile(path);
	}
/**
 * Starts the music
 */
	public static void startMusic() {
		player.play();
	}
/**
 * pauses music
 */
	public static void pauseMusic() {
		player.pause();
	}

	
	/**
	 * returns the refrence to the Player object
	 * @return this player
	 */
	public AudioPlayer getPlayer()
	{
		return this.player;
	}

}
