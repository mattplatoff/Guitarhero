package processinggame;

/**
 * A Beat is a line of all notes
 */
public class Beat 
{
	private int position;
	private int note;
	//TODO Create a method, updateBeatPosition()
	
	/**
	 * Default Constructor for Beat
	 * @param note - keys 1 - 6 on the guitar
	 * 1 - left
	 * 2 - right
	 * 3 - center
	 * 4 - left and center
	 * 5 - center and right
	 * 6 - left center and right
	 * @param position, the vertical position.
	 */
	public Beat (int position, int note)
	{
		this.position = position;
		this.note = note;
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
	 * Sets and updates the position of the beat
	 * @param position - position on guitar
	 */
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	/**
	 * Sets the note of a specific beat
	 * @param note - the note to set
	 */
	public void setNote(int note)
	{
		this.note = note;
	}
	
	/**
	 * Returns the note of the beat so other classes can compare
	 * @return - the note
	 */
	public int getNote()
	{
		return note;
	}
}
