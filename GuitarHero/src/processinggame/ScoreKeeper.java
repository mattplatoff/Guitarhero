package processinggame;

import java.io.File;
import java.util.ArrayList;

/**
 * 
 * @author 167564
 *
 */
public class ScoreKeeper 
{
	private int score;
	private Guitar guitar;
	
	public ScoreKeeper()
	{
		score=0;
	}
	
	/**
	 * This method will use the method from BeatHandler and will create an ArrayList of beats. It will use these
	 * beats to compare the beats from the Guitar
	 */
	public ArrayList<Beat> createMasterBeats(File beats)
	{
		return null;
	}
	
	/**
	 * Will return the current score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * This method will compare the beat that was played from the guitar to the beat in the master list
	 * @param beatplayed - the beat that was just played in the guitar
	 */
	public void compareBeats(Beat beatplayed)
	{
		
	}
	
	/**
	 * this should access the arrayList of beats that will be stored in beat handles rather than taking a new one i believe
	 * 
	 */
	public int updateScore(Beat beatPlayed, ArrayList<Beat> allbeats)
	{
		
	}
	
}
