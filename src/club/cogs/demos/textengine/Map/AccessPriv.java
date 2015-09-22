package club.cogs.demos.textengine.Map;

import java.util.HashMap;

public class AccessPriv {
	
protected static HashMap<String, AccessPriv> AccessPrivCache = new HashMap<String, AccessPriv>();
	
	private final String name;
	
	public AccessPriv(String name){
		this.name = name;
		
		AccessPriv.AccessPrivCache.put(this.name, this);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.getName();
	}
}