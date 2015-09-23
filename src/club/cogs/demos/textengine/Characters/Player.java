package club.cogs.demos.textengine.Characters;

import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;
import club.cogs.demos.textengine.Characters.Character;

public class Player extends Character{
	
	private static String DEFAULT_SPAWN_NAME = "player_default";
	
	public Player(String name, Level level) throws NameConflictException {
		this(name, level, DEFAULT_SPAWN_NAME);
	}

	public Player(String name, Level level, String spanName) throws NameConflictException {
		super(name, level, spanName);
		
		this.preventRandomAction();
	}

	public void sendMessage(String message, String value) {
		//ignore it
	}
}
