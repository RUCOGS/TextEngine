package club.cogs.demos.textengine.Actions;

import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Characters.Player;

public class MessageAction extends Action {

	private String message;

	public MessageAction(String title, String message) {
		super(title);
		
		this.message = message;
		// TODO Auto-generated constructor stub
	}

	public void preform(Character c) {
		if(c instanceof Player){
			Player p = (Player) c;
			p.sendMessage("Location", this.message);
		}
	}
}
