package club.cogs.demos.textengine.Map;
import java.util.HashMap;


public class Map {
	
	protected static HashMap<String, Map> MapCache = new HashMap<String, Map>();
	
	private final String name;
	
	public Map(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.getName();
	}
}
