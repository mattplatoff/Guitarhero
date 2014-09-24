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
	 */
	public void changeState()
	{
		
	}
	
	/**
	 * Will return the current game state. GUI uses this to know what to display
	 * @return
	 */
	public int getGameState()
	{
		return state;
	}

}
