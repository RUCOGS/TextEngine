package club.cogs.demos.textengine.Game;

import club.cogs.demos.textengine.Characters.ConsolePlayer;

public class ConsoleGame extends Game {

	public ConsoleGame(ConsolePlayer p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		System.out.println("Welcome to TextEngine!");
		super.run();
	}

}
