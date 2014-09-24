package processinggame;

/**
 * A Beat is a line of all notes
 */
public class Beat 
{
	private int time;
	private int position;
	
	/**
	 * Default Constructor for Beat
	 * @param position - position 1 - 6 on the guitar
	 * 1 - left
	 * 2 - right
	 * 3 - center
	 * 4 - left and center
	 * 5 - center and right
	 * 6 - left center and right
	 * @param time - the time of the beat
	 */
	public Beat (int position, int time)
	{
		
	}
	
	/**
	 * Gets the time of the beat
	 * @return - the time
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * Gets the position of the beat
	 * @return - the position
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 *  Sets the time of the beat
	 * @param time - a time stamp
	 */
	public void setTime(int time) 
	{
		this.time = time;
	}

	/**
	 * Sets the position of the beat
	 * @param position - position on guitar
	 */
	public void setPosition(int position) 
	{
		this.position = position;
	}
}
