package club.cogs.demos.textengine.Map;
import java.util.ArrayList;
import java.util.HashMap;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Characters.Character;


public class Location {
	
	protected static HashMap<String,Location> NodeCache = new HashMap<String, Location>();

	private final String name;
	
	private ArrayList<Map> maps;
	private ArrayList<Action> actions;
	
	public Location(String name){
		this.maps = new ArrayList<Map>();
		this.name = name;
		
		this.actions = new ArrayList<Action>();
	}
	
	public ArrayList<Action> getPreformableActions(Character c){
		
		ArrayList<Action> preformable = new ArrayList<Action>();
		if(this.actions != null){
			for(Action a : this.actions){
				if(a.canBePerformedBy(c, this))
					preformable.add(a);
			}
		}
		return preformable;
	}
	
	public void addAction(Action a){
		this.actions.add(a);
	}
	
	public void removeAction(Action a){
		this.actions.remove(a);
	}
	
	public void linkMap(Map m){
		this.maps.add(m);
	}
	
	public boolean onMap(Map m){
		if(this.maps.contains(m)){
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

}
