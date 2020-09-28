package FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Info.Nation;
import Info.Player;
import Preferences.Variables;

public class Parser {
	
	private static final String StartFile = "config.txt";
	private static List<String>  playerNames;
	private static List<Nation> nationsList;
	
	static void cargaInstruccion(String linea) {
	    if (linea.trim().length() == 0)
	        return;
	
	    String[] palabras = linea.split(" ");

	}

	public static void parse() throws FileNotFoundException, IOException {
	    
	    parseConfigFile();
	    System.out.println(Variables.numberOfNations);
	    System.out.println(Variables.numberOfPlayers);
	    for(String player : playerNames ) {
	    	System.out.println(player);
	    }
	    for(Nation player : nationsList ) {
	    	System.out.println(player);
	    }
	    if(playerNames.size() != Variables.numberOfPlayers) {
	    	throw new RuntimeException("The number of players introduced, do not match with the amount of lines with names on it, check the formating"
	    			+ "\nexpected number of players : " + Variables.numberOfPlayers + "\nnumber of players actually introduced :" + playerNames.size());

	    	
	    }
	    if(nationsList.size() != Variables.numberOfPlayers) {
	    	throw new RuntimeException("The number of nations introduced, do not match with the amount of lines with names on it, check the formating"
	    			+ "\nexpected number of nations : " + Variables.numberOfNations + "number of nations actually introduced :" + nationsList.size());
	    	
	    }
	}

	private static void parseConfigFile() throws IOException {
		BufferedReader fichero = new BufferedReader(new FileReader(StartFile));
		String linea;
		List<String>  players = null;
		List<Nation> nations = null;
		while ((linea = fichero.readLine()) != null) {
			if (linea.trim().length() == 0)
		        continue;
			if (linea.trim().startsWith("/"))
				continue;
			if(linea.trim().startsWith("@ number")) {
				linea = fichero.readLine();
				readNumberOfPlayers(linea);
			}
			if(linea.trim().startsWith("@ nation")) {
				nations = readNations(fichero);
			}
			if(linea.trim().startsWith("@ player")) {
				players = readPlayer(fichero);
			}
			if(linea.trim().startsWith("@ endfile")) {
				break;
			}
				
		}
		
		fichero.close();
		playerNames = players;
		nationsList = nations;
		
	}

	/**
	 * This methow reads the list of players that will make up the game
	 * @param fichero
	 * @return
	 * @throws IOException 
	 */
	private static List<String> readPlayer(BufferedReader fichero) throws IOException {
		String linea;
		List<String> players = new ArrayList<String>();
		while ((linea = fichero.readLine()) != null) {
			if (linea.trim().length() == 0)
		        continue;
			if (linea.trim().startsWith("/"))
				continue;
			if (linea.trim().startsWith("@ end")) {
				break;
			}
			else {
				
				players.add(linea.trim());
			}			
		}
		return players;
	}

	/***
	 * This methow reads the list of nations that will make up the game
	 * @param fichero
	 * @return 
	 * @throws IOException 
	 */
	private static List<Nation> readNations(BufferedReader fichero) throws IOException {
		String linea;
		List<Nation> nations = new ArrayList<Nation>();
		while ((linea = fichero.readLine()) != null) {
			if (linea.trim().length() == 0)
		        continue;
			else if (linea.trim().startsWith("/"))
				continue;
			else if (linea.trim().startsWith("@ end")) {
				break;
			}
			else {
				String [] words = linea.split(" ");
				nations.add(new Nation(words[0],Integer.parseInt(words[1]) ));
			}			
		}
		return nations;
		
	}

	/**
	 * This method read the number of players/nation that will be on the game
	 * the general information is stored on Variables.java
	 */
	private static void readNumberOfPlayers(String linea) {
		
		String[] word = linea.split(" ");
		System.out.println(word[0]);
		Variables.numberOfNations = Integer.parseInt(word[0]);
		Variables.numberOfPlayers = Integer.parseInt(word[0]);
		
	}
	
	
	


}
