package maingame;

import processing.core.PApplet;

public abstract class Button {
	
	private int topLeftX;
	private int topLeftY;
	private int width;
	private int length;
	private String message;
	
	private PApplet parent;
	
	public Button(int x, int y, int width, int length, String message, PApplet parent)
	{
		this.topLeftX = x;
		this.topLeftY = y;
		this.width = width;
		this.length = length;
		this.message = message;
		this.parent = parent;
	}
	
	public void draw()
	{
		parent.fill(245);
		parent.stroke(180, 150, 49);
		parent.rect(topLeftX, topLeftY, width, length);
		parent.text(message, topLeftX + 20, topLeftY + 20);
	}
	
	public abstract String action();
	
	public PApplet getParent()
	{
		return this.parent;
	}

}
