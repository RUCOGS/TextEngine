package club.cogs.demos.textengine.Actions;

import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Characters.Player;
import club.cogs.demos.textengine.Map.Location;

public class NonPlayerAction extends Action {

	public NonPlayerAction(String title) {
		super(title);
	}

	public boolean canBePerformedBy(Character c, Location l) {
		if(c instanceof Player)
			return false;
		return true;
	}

}
