package maingame;

import processing.core.PApplet;

public class ScoreKeeper {
	
	private int score;
	private PApplet parent;
	
	public ScoreKeeper(PApplet parent)
	{
		this.score = 0;
		this.parent = parent;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void draw()
	{
		parent.textSize(32);
		parent.text("Score: " + this.getScore(), 300, 50);
	}
	
	public int updateScore(int keyCode, Beat firstBeat)
	{
		if( ((keyCode == parent.LEFT && firstBeat.getNote() == 1) ||
				(keyCode == parent.CENTER && firstBeat.getNote() == 2) ||
				(keyCode == parent.RIGHT && firstBeat.getNote() == 3)) &&
				Math.abs(400 - firstBeat.getPosition()) < 50 )
		{
			this.score += 100;
		}
		else
		{
			this.score -= 10;
		}
		
		return score;
	}
	
}
