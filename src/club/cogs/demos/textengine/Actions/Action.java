package club.cogs.demos.textengine.Actions;

import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Map.Location;

public class Action {
	
	private String title;
	
	public Action(){
		
	}

	public boolean canBePerformedBy(Character c, Location l) {
		return true;
	}

	public void preform(Character c) {
		
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String toString(){
		return this.getTitle();
	}

}
