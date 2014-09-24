package processinggame;

import java.io.File;
import java.util.ArrayList;

/**
 * ScoreKeeper is the class which has the job of keeping a running score as well as checking the beat played by the guitar
 * and the beat in the song to see if they match
 */
public class ScoreKeeper 
{
	private int score;
	private Guitar guitar;
	private ArrayList<Beat> masterbeats;
	
	public ScoreKeeper()
	{
		score=0;
	}
	
	/**
	 * This method will use the method from BeatHandler and will create an ArrayList of beats. It will use these
	 * beats to compare the beats from the Guitar
	 * 
	 * Steve: How is this method different from createBeatObjects
	 * in BeatHandler?
	 * 
	 */
	public void createMasterBeats(File beats)
	{
		
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
	 * This method will also update the score as it compares the beats one by one
	 * @param beatplayed - the beat that was just played in the guitar
	 */
	public void compareBeatandUpdateScore(Beat beatplayed)
	{
		
	}
	
	/**
	 * OLD CODE
	 */
//	/**
//	 * this should access the arrayList of beats that will be stored in beat handles rather than taking a new one i believe
//	 * 
//	 */
//	public int updateScore(Beat beatPlayed, ArrayList<Beat> allbeats)
//	{
//		
//	}
}
