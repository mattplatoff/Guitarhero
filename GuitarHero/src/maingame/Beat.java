package maingame;

import java.awt.Color;

import processing.core.PApplet;

public class Beat 
{
	
	//NOTES
	private static final int LEFT = 1;
	private static final int CENTER = 2;
	private static final int RIGHT = 3;
	private static final int LEFTCENTER = 4;
	private static final int RIGHTCENTER = 5;
	private static final int LEFTRIGHT = 6;
	private static final int LEFTRIGHTCENTER = 7;
	private static Color LEFT_COLOR = new Color(255, 0, 103);
	private static Color CENTER_COLOR = new Color(0, 177, 177);
	private static Color RIGHT_COLOR = new Color(176, 241, 0);
	
	private int yPos;
	private int note;
	private int time;
	private PApplet myParent;
	
	public Beat(int position, int note, int time)
	{
		this.yPos = position;
		this.note = note;
		this.time = time;
		myParent = null;
	}
	
	public Beat(PApplet parent, int position, int note, int time)
	{
		this(position, note, time);
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
			myParent.ellipse(100, yPos, 20, 20);
			break;
		case 3:
			myParent.fill(RIGHT_COLOR.getRed(), RIGHT_COLOR.getGreen(), RIGHT_COLOR.getBlue());
			myParent.ellipse(160, yPos, 20, 20);
			break;
		default:
			break;
		}
		
		this.incrementPosition(1);
	}
	
	public void setParent(PApplet parent)
	{
		this.myParent = parent;
	}
	
	public int getPosition()
	{
		return this.yPos;
	}
	
	public int getTime()
	{
		return this.time;
	}
	
	public int getNote()
	{
		return this.note;
	}
	
	public void setPosition(int position)
	{
		this.yPos = position;
	}
	
	public void setTime(int time)
	{
		this.time = time;
	}
	
	public void setNote(int note)
	{
		this.note = note;
	}
	
	public void incrementPosition(int increment)
	{
		if(!Gui.pauseState())
		this.yPos += increment;
	}
	
	public void highLightBeat()
	{
		
	}

}
