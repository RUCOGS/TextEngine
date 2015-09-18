package club.cogs.demos.textengine;


import java.util.HashMap;

import club.cogs.demos.textengine.Characters.ConsolePlayer;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.ConsoleGame;
import club.cogs.demos.textengine.Game.Level;
import club.cogs.demos.textengine.Map.Location;

public class Tester {

	public static void main(String[] args) {
		
		HashMap<String,Location> spawns = new HashMap<String,Location>();
		
		spawns.put("default", new Location("Demo"));

		Level test = new Level(spawns);
				
		ConsolePlayer player;
		try {
			player = new ConsolePlayer("Player", test);
			
			ConsoleGame game = new ConsoleGame(player);
			Thread gameThread = new Thread(game);
			gameThread.start();
		} catch (NameConflictException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}

	}

}
