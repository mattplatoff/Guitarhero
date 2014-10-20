package maingame;

import maingame.Beat;
import processing.core.PApplet;

public class ScoreKeeper {
	
	private int score;
	private PApplet parent;
	/**
	 * creates a new score keeper object with a papplet as a parameter
	 * @param parent the PApplet that the scorekeeper is being created in
	 */
	public ScoreKeeper(PApplet parent)
	{
		this.score = 0;
		this.parent = parent;
	}
	/**
	 * returns the current score
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * draws the score keeper
	 */
	public void draw()
	{
		parent.textSize(32);
		parent.text("Score: " + this.getScore(), 300, 50);
	}
	/**
	 * runs continuously to update the score
	 * @param keyCode the key beign pressed
	 * @param firstBeat the beat to be player
	 * @return true if beat is hit
	 */
	public boolean updateScore(int keyCode, Beat firstBeat)
	{
		boolean hitBeat = false;
		if( ((keyCode == parent.LEFT && firstBeat.getNote() == 1) ||
				(keyCode == parent.DOWN && firstBeat.getNote() == 2) ||
				(keyCode == parent.RIGHT && firstBeat.getNote() == 3)) &&
				Math.abs(400 - firstBeat.getPosition()) < 50 )
		{
			this.score += 100;
			hitBeat = true;
		}
		else
		{
			this.score -= 50;
			hitBeat = false;
		}
		
		return hitBeat;
	}
	
}
