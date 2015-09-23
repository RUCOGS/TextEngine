package club.cogs.demos.textengine.Map;
import java.util.ArrayList;
import java.util.HashMap;

import club.cogs.demos.textengine.Characters.Character;


public class Map {
	
	protected static HashMap<String, Map> MapCache = new HashMap<String, Map>();
	
	private final String name;
	private ArrayList<AccessPriv> accessPrivs;
	
	public Map(String name){
		this.name = name;
		
		this.accessPrivs = new ArrayList<AccessPriv>();
		
		Map.MapCache.put(this.name, this);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.getName();
	}
	
	public void GrantAccess(AccessPriv p){
		this.accessPrivs.add(p);
	}

	public boolean permits(Character character) {

		AccessPriv[] privs = character.getPrivs();
		for(AccessPriv p : privs){
			if(this.accessPrivs.contains(p))
				return true;
		}
		return false;
	}
}
