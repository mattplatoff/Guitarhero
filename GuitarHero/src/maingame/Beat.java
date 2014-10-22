package maingame;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Beat is the class that signifies an individual beat. Each beat holds a y Position, time and type of beat.
 */
public class Beat 
{
	
	//The private ints are for the beats color
	private static Color LEFT_COLOR = new Color(255, 0, 103);
	private static Color CENTER_COLOR = new Color(0, 177, 177);
	private static Color RIGHT_COLOR = new Color(176, 241, 0);
	
	/**
	 * These private ints will keep track of a beats yPos on the screen, the type of note, the time of each beat
	 * and the increment value to keep the beat moving constantly. We also need PApplet to draw the beats on the gui
	 */
	private int yPos;
	private int note;
	private int time;
	private PApplet myParent;
	private double increment;
	
	/**
	 * This is a constructor of beat. Used mainly for storing masterbeats
	 * @param note - the type of note
	 * @param time - the time that the note needs to be played
	 * @param increment - the increment value
	 */
	public Beat(int note, int time, double increment)
	{
		this.note = note;
		this.time = time;
		this.yPos = 420 - time;
		myParent = null;
		this.increment = increment;
	}
	
	/**
	 * Another constructor for Beat that uses the PApplet - used mainly for drawing notes
	 * @param parent - PApplet import to draw notes
	 * @param position - the yPos of the beat
	 * @param note - the type of note
	 * @param time - the time it needs to be displayed
	 * @param increment - the increment value
	 */
	public Beat(PApplet parent, int position, int note, int time, double increment)
	{
		this(note, time, increment);
		this.myParent = parent;
		
	}
	
	/**
	 * Draws the beat out at the proper y-start position and moves it down accordingly.
	 */
	public void draw()
	{
		switch (this.note) {
		case 1:
			myParent.fill(LEFT_COLOR.getRed(), LEFT_COLOR.getGreen(), LEFT_COLOR.getBlue());
			myParent.ellipse(40, yPos, 20, 20);
			break;
		case 2:
			myParent.fill(CENTER_COLOR.getRed(), CENTER_COLOR.getGreen(), CENTER_COLOR.getBlue());
			myParent.ellipse(140, yPos, 20, 20);
			break;
		case 3:
			myParent.fill(RIGHT_COLOR.getRed(), RIGHT_COLOR.getGreen(), RIGHT_COLOR.getBlue());
			myParent.ellipse(240, yPos, 20, 20);
			break;
		default:
			break;
		}
		
		this.incrementPosition(this.increment);
	}
	
	/**
	 * Allows up to set the PApplet
	 * @param parent - the PApplet
	 */
	public void setParent(PApplet parent)
	{
		this.myParent = parent;
	}
	
	/**
	 * Gets the position of the beat
	 * @return - the int y-position
	 */
	public int getPosition()
	{
		return this.yPos;
	}
	
	/**
	 * The time of the beat
	 * @return - the int time
	 */
	public int getTime()
	{
		return this.time;
	}
	
	/**
	 * Gets the note of the beat
	 * @return - the  note of the beat
	 */
	public int getNote()
	{
		return this.note;
	}
	
	/**
	 * Sets the position of the code
	 * @param position - the y position
	 */
	public void setPosition(int position)
	{
		this.yPos = position;
	}
	
	/**
	 * Sets the time of the code
	 * @param time - the system time
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	
	/**
	 * Sets the note of a beat
	 * @param note - the int note
	 */
	public void setNote(int note)
	{
		this.note = note;
	}
	
	/**
	 * Increments the Y Position of the beat by the increment value
	 * @param increment
	 */
	public void incrementPosition(double increment)
	{
		if(!Gui.pauseState())
		this.yPos += increment;
	}
}
