package club.cogs.demos.textengine.Game;

import java.util.ArrayList;

import club.cogs.demos.textengine.Actions.Action;
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
		
		this.running = true;
		
		for(Character c : this.characters){
			c.reset();
		}
	}
	
	public void loop(){
		//run the game loop;
		
		Location p_location = this.player.getCurrentLocation();
		
		ArrayList<Action> p_actions = p_location.getPreformableActions(this.player);
		
		Action p_action = this.player.chooseAction(p_actions);
	
		p_action.preform(this.player);
		
		for (Character c : this.characters){
			if(c == this.player)
				continue;
			Location c_location = c.getCurrentLocation();
			ArrayList<Action> c_actions = c_location.getPreformableActions(this.player);
			Action c_action = c.chooseAction(c_actions);
			c_action.preform(this.player);
		}
		
		clock.tick();
		
	}

	public void run() {
		while(this.running){
			this.loop();
		}
	}
	
}
