package club.cogs.demos.textengine.Game;

import java.util.HashMap;

import club.cogs.demos.textengine.Exception.InvalidSpawnException;
import club.cogs.demos.textengine.Map.Location;

public class Level {
	
	private static String DEFAULT_SPAWN_NAME = "default";
	
	private HashMap<String,Location> spawns;
	
	public Level(HashMap<String,Location> spawns){
		this.spawns = spawns;
	}

	public Location getSpawn() {
		return getSpawn(DEFAULT_SPAWN_NAME);
	}
	
	public Location getSpawn(String name){
		if(this.spawns.containsKey(name))
			return this.spawns.get(name);
		if(this.spawns.containsKey(DEFAULT_SPAWN_NAME))
			return this.spawns.get(DEFAULT_SPAWN_NAME);
		throw new InvalidSpawnException(name);
	}
	
}
