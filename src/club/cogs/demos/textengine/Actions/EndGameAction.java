package club.cogs.demos.textengine.Actions;

import club.cogs.demos.textengine.Characters.Player;
import club.cogs.demos.textengine.Characters.Character;

public class EndGameAction extends Action {
	
	private String reason;

	public EndGameAction(String reason){
		super("End Game: "+reason);
		this.reason = reason;
	}
	
	public void preform(Character c){
		if(c instanceof Player){
			Player p = (Player) c;
			p.sendMessage("End Game", this.reason);
		}
	}

}
