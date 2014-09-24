package processinggame;

public class Guitar 
{
	private int lastKeyPressed;
	/**
	 * This method will get the key that has been pressed 
	 */
	public void getKeyPressed()
	{
		
	}
	/**
	 * Sends the input of pressed key to ScoreKeeper. 
	 */
	public int sendKey(){
		return lastKeyPressed;
	}
	/**
	 * OLD CODE
	 */
//	private final key
//	/**
//	 *  called when the spacebar on the guitar is pressed.  returns an arraylist with 
//	 *  what keys were checked so that score keeper can compare it to the beats in the score zone to determine points.
//	 */
//	public Beat playNotes()
//	{
//		
//	}
//	/**
//	 * checks if a given key was pressed
//	 */
//	public void keyPressed()
//	{
//		
//	}
}
