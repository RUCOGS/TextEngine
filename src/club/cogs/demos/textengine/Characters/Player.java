package club.cogs.demos.textengine.Characters;

import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;

public class Player extends Character{
	

	public Player(String name, Level level) throws NameConflictException {
		super(name, level);
		
		this.reset();
	}

}
