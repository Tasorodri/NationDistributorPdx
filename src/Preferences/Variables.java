/**
 * 
 */
package Preferences;

import Info.Nation;
import Info.Player;

/**
 * @author Taso
 *
 *	This class is used to store the preferences of the game
 */
public class Variables {
	
	public static final int numberOfPlayers = 10;
	public static final int numberOfNations = 10;
	//there must always be al least 3 factions per tier
	public static final int tiers = 3;
	//the comparable weight of skill/preference, better to alternate from 0 to 1.0
	public static final double skillWeight = 1;
	public static final double prefWeight = 1;
	//the highier the less random it will be, exponential
	public static final double certainty = 2;
	
	
	
	
	
}
