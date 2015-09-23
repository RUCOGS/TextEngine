package club.cogs.demos.textengine.Characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;
import club.cogs.demos.textengine.Map.AccessPriv;
import club.cogs.demos.textengine.Map.Location;

public class Character {
	
	protected static HashMap<String,Character> CharacterCache = new HashMap<String,Character>();
	
	
	private ArrayList<AccessPriv> accessPrives = new ArrayList<AccessPriv>(); //if empty all
	
	private static String DEFAULT_SPAWN_NAME = "default";

	private final String name;
	private Location currentLocation;
	private Level level;
	private String spawnName;
	private boolean allowRandomAction = true;
	
	public Character(String name, Level level) throws NameConflictException{
		this(name, level, DEFAULT_SPAWN_NAME);
	}
	
	public Character(String name, Level level, String spawnName) throws NameConflictException{
		if(Character.CharacterCache.containsKey(name))
			throw new NameConflictException(name);
		
		this.name = name;
		this.level = level;
		this.spawnName = spawnName;
		
		Character.CharacterCache.put(this.name, this);
	}
	
	public Level getLevel(){
		return this.level;
	}
	
	public void reset(){
		if(this.spawnName != null)
			this.setCurrentLocation(this.level.getSpawn(this.spawnName));
		else
			this.setCurrentLocation(this.level.getSpawn());
	}
	
	
	public Location getCurrentLocation(){
		return this.currentLocation;
	}
	
	public void setCurrentLocation(Location l){
		this.currentLocation = l;
	}
	
	public boolean canTravelTo(Location l){
		if (l.canAccess(this))
			return true;
		if(accessPrives.size() <= 0)
			return true;
		return false;
	}
	
	public void allowPriv(AccessPriv p){
		this.accessPrives.add(p);
	}
	
	public AccessPriv[] getPrivs(){
		AccessPriv[] privs = new AccessPriv[accessPrives.size()];
		
		int i = 0;
		for(AccessPriv p : this.accessPrives){
			privs[i++] = p;
		}
		
		return privs;
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

		if(!this.actionAllowed())
			return new Action("Wait");

		if(this.randomActionAllowed() && actions.size() > 0)
			return actions.get(new Random().nextInt(actions.size()));
		
		return null;
	}

	public boolean actionAllowed() {
		return true;
	}
	
	protected void preventRandomAction(){
		this.allowRandomAction = false;
	}
	
	protected void allowRandomAction(){
		this.allowRandomAction = true;
	}
	
	protected boolean randomActionAllowed(){
		return this.allowRandomAction;
	}
	
	public void setLevel(Level l){
		this.level = l;
	}

}
