package club.cogs.demos.textengine.Actions;

import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Map.Location;

public class TravelAction extends Action {

	private Location destination;

	public TravelAction(String title, Location dest) {
		super(title);
		
		this.destination = dest;
	}

	public boolean canBePerformedBy(Character c, Location l) {
		if(c.canTravelTo(this.destination)){
			return super.canBePerformedBy(c, l);
		}
		return false;
	}

	public void preform(Character c) {
		c.setCurrentLocation(this.destination);
	}
	
	
}
