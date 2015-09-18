package club.cogs.demos.textengine.Game;

import java.util.HashMap;

import club.cogs.demos.textengine.Map.Location;

public class Level {
	
	private HashMap<String,Location> spawns;
	
	public Level(HashMap<String,Location> spawns){
		this.spawns = spawns;
	}

	public Location getSpan() {
		return getSpawn("default");
	}
	
	public Location getSpawn(String name){
		if(this.spawns.containsKey(name))
			return this.spawns.get(name);
		throw new InvalidSpawnException(name);
	}
	
}
