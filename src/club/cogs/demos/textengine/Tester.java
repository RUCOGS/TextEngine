package club.cogs.demos.textengine;


import java.util.HashMap;

import club.cogs.demos.textengine.Actions.MessageAction;
import club.cogs.demos.textengine.Actions.NonPlayerAction;
import club.cogs.demos.textengine.Actions.TravelAction;
import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Characters.ConsolePlayer;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.ConsoleGame;
import club.cogs.demos.textengine.Game.Level;
import club.cogs.demos.textengine.Map.AccessPriv;
import club.cogs.demos.textengine.Map.Location;
import club.cogs.demos.textengine.Map.Map;

public class Tester {

	public static void main(String[] args) {

		
		try {
			
			HashMap<String,Location> spawns = new HashMap<String,Location>();
	
			Level test = new Level(spawns);

			ConsolePlayer player = new ConsolePlayer("Player", test);
			Character c = new Character("NPC 1", test);
			
			ConsoleGame game = new ConsoleGame(player);
			game.AddCharacter(c);
			
			
			Map map1 = new Map("Map1");
			Map map2 = new Map("Map2");
			
			
			AccessPriv ap_c = new AccessPriv("Character");
			AccessPriv ap_p = new AccessPriv("Player");

			Location l_default =  new Location("CharacterDefault");
			Location l_travel_1 = new Location ("Travel 1");
			Location l_playerDefault =  new Location("PlayerDefault");
			
			spawns.put("default", l_default);
			spawns.put("player_default", l_playerDefault);
			

			
			l_default.linkMap(map1);
			l_default.linkMap(map2);
			
			l_travel_1.linkMap(map2);
	
			l_playerDefault.linkMap(map1);
			
			
			map1.GrantAccess(ap_c);
			map1.GrantAccess(ap_p);
			
			map2.GrantAccess(ap_p);
			
			
			l_playerDefault.addAction(new TravelAction("Travel to Default", l_default));
			l_default.addAction(new TravelAction("Travel to 1", l_travel_1));
			l_travel_1.addAction(new TravelAction("Travel to Default", l_default));
			
			l_default.addAction(new MessageAction("Sample Action 1","Sample Action"));
	
			l_default.addAction(new MessageAction("Sample Action 2","Sample Action 2"));
			
			l_playerDefault.addAction(new MessageAction("Default Player Action","Default Player Action"));
			
			l_default.addAction(new NonPlayerAction("Player Cant Do This"){
				public void preform(Character c) {
					System.out.println("I am not a player");
				}
			});
			
			l_travel_1.addAction(new NonPlayerAction("Player Can't See This"){
				public void preform(Character c) {
					System.out.println("NPC 1 should never get here");
				}
			});
			

			Thread gameThread = new Thread(game);
			gameThread.start();
		} catch (NameConflictException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}

	}

}
