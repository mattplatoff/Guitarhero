package maingame;

import processing.core.PApplet;

public class Beat {
	
	//NOTES
	private static final int LEFT = 1;
	private static final int CENTER = 2;
	private static final int RIGHT = 3;
	private static final int LEFTCENTER = 4;
	private static final int RIGHTCENTER = 5;
	private static final int LEFTRIGHT = 6;
	private static final int LEFTRIGHTCENTER = 7;
	
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
			myParent.fill(255, 0, 0);
			myParent.ellipse(40, yPos, 20, 20);
			break;
		case 2:
			myParent.fill(0, 255, 0);
			myParent.ellipse(100, yPos, 20, 20);
			break;
		case 3:
			myParent.fill(0, 0, 255);
			myParent.ellipse(160, yPos, 20, 20);
			break;
		default:
			break;
		}
		
		this.incrementPosition(2);
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
		this.yPos += increment;
	}
	
	public void highLightBeat()
	{
		
	}

}
