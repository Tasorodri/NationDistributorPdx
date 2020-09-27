package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Info.Nation;
import Info.Player;

public class NationDistributer {


	private List<Player> playerList;
	private List<Nation> nationList;
	private HashMap<Player, Nation> electionList;



	public NationDistributer(List<Player> playerList, List<Nation> nationList) {
		super();
		this.playerList = playerList;
		this.nationList = nationList;
		electionList = new HashMap<Player, Nation>();
		
	}

	public void asingNations() {
		
		//TODO hay que iterar por paises no por jugadores
		while(playerList.size()>0) {
			assingCountry(playerList.get(0));
		}
		
		for(Player player: electionList.keySet()) {
			System.out.println(player.getName() + " - " + electionList.get(player));
		}
	}

	
	/***
	 * This method does the call to the random select
	 * store the result on a list and removes the player and the nation from the algorithm
	 * @param player
	 */
	private void assingCountry(Player player) {
		Nation selected = randomSelec(player.getWeights());

		electionList.put(player, selected);
		playerList.remove(player);
		nationList.remove(selected);
		for(Player otherPlayer : playerList) {
			otherPlayer.getWeights().remove(selected);
		}

	}

	/***
	 * This method chooses with Nation will correspond to the given player weights, returns
	 * the choosen nation or throws an exception if its unable to
	 * @param weights
	 * @return
	 */
	private Nation randomSelec(HashMap<Nation,Double> weights) {
		double totalProb =0;
		for(Nation nation : weights.keySet()) {
			totalProb += weights.get(nation);
		}
		double rand = new Random().nextDouble() * totalProb;
		for(Nation nation : weights.keySet()) {
			rand -= weights.get(nation);
			if(rand < 0.0){
				return nation;
			}
		}
		throw new RuntimeException("error, the random select encountered an error, negative number");


	}
	
	
	public List<Player> getPlayerList() {
		return playerList;
	}

	public List<Nation> getNationList() {
		return nationList;
	}

	public HashMap<Player, Nation> getElectionList() {
		return electionList;
	}

}
