package club.cogs.demos.textengine.Game;

import java.util.ArrayList;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Actions.EndGameAction;
import club.cogs.demos.textengine.Characters.Character;
import club.cogs.demos.textengine.Characters.Player;
import club.cogs.demos.textengine.Clock.Clock;
import club.cogs.demos.textengine.Map.Location;

public class Game implements Runnable{
	
	private Player player;
	
	private ArrayList<Character> characters;
	
	private Clock clock;
	
	private boolean running = false;
	
	public Game(Player p){
		this.player = p;
		
		this.characters = new ArrayList<Character>();
		this.characters.add(player);
		
		this.clock = new Clock(9,0);
	}
	
	public void AddCharacter(Character c){
		this.characters.add(c);
	}
	
	public void loop(){
		
		this.player.sendMessage("Time",this.clock.toString());
		
		Location p_location = this.player.getCurrentLocation();
		
		ArrayList<Action> p_actions = p_location.getPreformableActions(this.player);
		
		Action p_action = this.player.chooseAction(p_actions);
	
		if(p_action instanceof EndGameAction){
			EndGameAction e = (EndGameAction) p_action;
			e.preform(this.player);
			running = false;
			return;
		}
		
		
		if(p_action != null)
			p_action.preform(this.player);
		
		for (Character c : this.characters){
			if(c == this.player)
				continue;
			Location c_location = c.getCurrentLocation();
			ArrayList<Action> c_actions = c_location.getPreformableActions(c);
			Action c_action = c.chooseAction(c_actions);

			System.out.println();
			System.out.print(c.toString()+": ");
			if(c_action != null)
				c_action.preform(c);

			System.out.println();
		}
		
		clock.tick();
		
	}

	public void run() {
		for(Character c : this.characters){
			c.reset();
		}
		this.running = true;
		while(this.running){
			this.loop();
		}
	}
	
}
