package processinggame;

/**
 * 
 * Keeps track of the state of the whole game.
 *
 */
public class GameState 
{
	/**
	 * 0 - Menu
	 * 1 - In Game
	 * 2 - Paused
	 */
	private int state;
	
	/**
	 * Will change the state
	 * @param someState the desired state to change to.
	 */
	public void changeState(int someState)
	{
		
	}
	
	/**
	 * Will return the current game state. GUI uses this to know what to display
	 * @return The Game State.
	 */
	public int getGameState()
	{
		return state;
	}

}
