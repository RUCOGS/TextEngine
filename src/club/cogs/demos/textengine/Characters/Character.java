package club.cogs.demos.textengine.Characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;
import club.cogs.demos.textengine.Map.Location;
import club.cogs.demos.textengine.Map.Map;

public class Character {
	
	protected static HashMap<String,Character> CharacterCache = new HashMap<String,Character>();
	private static ArrayList<Map> approvedMaps = new ArrayList<Map>(); //if empty all

	private final String name;
	private Location currentLocation;
	private Level level;
	
	public Character(String name, Level level) throws NameConflictException{
		if(Character.CharacterCache.containsKey(name))
			throw new NameConflictException(name);
		
		this.name = name;
		this.level = level;
		
		Character.CharacterCache.put(this.name, this);
	}
	
	public Level getLevel(){
		return this.level;
	}
	
	public void reset(){
		this.setCurrentLocation(this.level.getSpan());
	}
	
	
	public Location getCurrentLocation(){
		return this.currentLocation;
	}
	
	public void setCurrentLocation(Location l){
		this.currentLocation = l;
	}
	
	public boolean canTravelTo(Location l){
		if(approvedMaps.size() <= 0)
			return true;
		for(Map m : approvedMaps){
			if (l.onMap(m))
				return true;
		}
		return false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.getName();
	}

	public Action chooseAction(ArrayList<Action> actions) {
		
		if(actions == null)
			throw new IllegalArgumentException();
				
		return actions.get(new Random().nextInt(actions.size()));
	}

}
