package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import Info.Nation;
import Info.Player;
import Main.NationDistributer;

class TestPlayer {

	@Test
	void test() {
		Nation fra  = new Nation("France", 3);
		Nation spa  = new Nation("Spain", 2);
		Nation hab  = new Nation("Austria", 1);
		Nation tur  = new Nation("Otomanos", 3);
		Nation eng  = new Nation("Inglaterra", 1);
		List<Nation>  nations = new ArrayList<Nation>();
		nations.add(fra);
		nations.add(spa);
		nations.add(hab);
		nations.add(tur);
		nations.add(eng);
		
		HashMap<Nation, Integer> preference = new HashMap<Nation, Integer>();
		preference.put(fra, 1);
		preference.put(spa, 3);
		preference.put(hab, 2);
		preference.put(tur, 5);
		preference.put(eng, 4);
		
		
		HashMap<Nation, Integer> preference2 = new HashMap<Nation, Integer>();
		preference2.put(fra, 2);
		preference2.put(spa, 3);
		preference2.put(hab, 4);
		preference2.put(tur, 1);
		preference2.put(eng, 5);
		
		
		Player taso = new Player("taso", 3, 3, 3, preference);
		Player patilloro = new Player("llorotodo", 1, 1, 1, preference2);
		Player basileus = new Player("basileus", 2, 2, 2, preference);
		Player sauriano = new Player("sauriano", 3, 2, 1, preference2);
		Player renesubnormal = new Player("renesubnormal", 1, 1, 1, preference);
		
		List<Player>  players = new ArrayList<Player>();
		players.add(taso);
		players.add(patilloro);
		players.add(basileus);
		players.add(sauriano);
		players.add(renesubnormal);
		
		taso.calculateWeightList();
		patilloro.calculateWeightList();
		basileus.calculateWeightList();
		sauriano.calculateWeightList();
		renesubnormal.calculateWeightList();
		
		for(Nation nation : taso.getWeights().keySet()) {
			System.out.println(taso.getName() + " " + nation.getName() + " " + taso.getWeights().get(nation));
			System.out.println(patilloro.getName() + " " + nation.getName() + " " + patilloro.getWeights().get(nation));
			System.out.println(basileus.getName() + " " + nation.getName() + " " + basileus.getWeights().get(nation));
			System.out.println(sauriano.getName() + " " + nation.getName() + " " + sauriano.getWeights().get(nation));
			System.out.println(renesubnormal.getName() + " " + nation.getName() + " " + renesubnormal.getWeights().get(nation));
		}
		
		//pruebas sobre el selector de paises
		NationDistributer nt = new NationDistributer(players, nations);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		nt.asingNations();
	}

}
