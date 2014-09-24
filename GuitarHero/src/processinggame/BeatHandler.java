package processinggame;

import java.io.File;
import java.util.ArrayList;

/**
 * The sole purpose of BeatHandler is to read a text file and create a list of beats which have the positions
 * and times in the text file
 * 
 * Steve: CLASS NOT NECESSARY. We can put this one method in ScoreKeeper.
 *
 */
public class BeatHandler
{
	/**
	 * This method will read a text file that contains the positions and times of beats and create an arraylist
	 * of beats with the positions and time
	 * @param beats - the text file of beats
	 */
	public static ArrayList<Beat> createBeatObjects(File beats)
	{
		return null;
	}
}



/**
 * !Old code! I didnt want to delete it, so i commented it out here
 */
///**
//* The method will place beat objects on the gui
//* @param beat This is the file that will tell beat handler where and when to put the beat objects on 
//* guitar. 
//* 
//*/
//public void createBeatObjects(File beats){
//	
//}
//
///**
//* this method will return all the beats in the given song
//*/
//public ArrayList<Beat> getBeats(File beats){
//	
//}
//}