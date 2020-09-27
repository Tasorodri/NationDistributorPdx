/**
 * 
 */
package Info;

import java.util.ArrayList;
import java.util.HashMap;

import Preferences.Variables;

import java.lang.Math;

/**
 * @author Taso
 *
 */
public class Player {
	
	
	private String name;
	//measure of the level of skill dedication and agresiveness of a player
	private int skill;
	private int dedication;
	private int agresiveness;
	//Map with preferences for Nations, the lower the number, the higher the desire for said Nation
	private HashMap<Nation, Integer> preference;
	private HashMap<Nation, Double> weights = null;
	
	

	public Player(String name, int skill, int dedication, int agresiveness, HashMap<Nation, Integer> preference) {
		super();
		this.name = name;
		this.skill = skill;
		this.dedication = dedication;
		this.agresiveness = agresiveness;
		this.preference = preference;
		this.weights = new HashMap<Nation, Double>();
	}
	
	
	


	public void calculateWeightList() {
		for( Nation nation : preference.keySet()) {
			weights.put(nation, calcWeight(nation));
		}
	}
	
	private  double calcWeight(Nation nation) {
		double prefScore =  (double) ( Variables.numberOfNations -  preference.get(nation));
		//para el calculo de la skillScore, se parte de una base de numberOfNations - nº tiers para "normalizar" con prefScore
		//luego se le resta la diferencia entre la skill recomendada y la preferencia del jugador
		
		double skillScore =  (Variables.numberOfNations - Variables.tiers) -  Math.abs((double) ( nation.getRecommendedSkill() -  skill)) -
				Math.abs((double) ( nation.getRecommendedSkill() -  dedication)) - Math.abs((double) ( nation.getRecommendedSkill() -  agresiveness));
		double result =  prefScore*Variables.prefWeight + skillScore*Variables.skillWeight;
		result = Math.pow(result, Variables.certainty);
		return result;
	}


	public HashMap<Nation, Double> getWeights() {
		return weights;
	}
	
	public String getName() {
		return name;
	}


	public int getSkill() {
		return skill;
	}


	public int getDedication() {
		return dedication;
	}


	public int getAgresiveness() {
		return agresiveness;
	}


	public HashMap<Nation, Integer> getPreference() {
		return preference;
	}
	
	
	
}
