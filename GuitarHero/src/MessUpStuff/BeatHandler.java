package MessUpStuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<Beat> createBeatObjects(File beats) throws FileNotFoundException
	{
		Scanner scan=new Scanner(beats);
		ArrayList<Beat> master=new ArrayList<Beat>();
		
		while(scan.hasNext()){
			String b=scan.nextLine();
			master.add(new Beat(Integer.parseInt(b.substring(0,1)),Integer.parseInt(b.substring(1,2)),Integer.parseInt(b.substring(2,3))));
			
		}
		
		scan.close();
		
		return master;
		
	}
}