package club.cogs.demos.textengine.Characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Actions.EndGameAction;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;

public class ConsolePlayer extends Player {
	
	public ConsolePlayer(String name, Level level) throws NameConflictException {
		super(name, level);
	}

	public void sendMessage(String message, String value) {
		System.out.println(message+": "+value);
	}

	public Action chooseAction(ArrayList<Action> actions) {
		
		Action s_action = super.chooseAction(actions);
		if(s_action != null){
			return s_action;
		}
		
		do{

			String input = null;
			
			this.sendMessage("Location", this.getCurrentLocation().toString());
			System.out.println("==");
			int i = 0;

			for(Action a : actions){
				System.out.println((i++ + 1) + ") "+ a);
			}
			
			System.out.println("Quit) QUIT GAME");

			System.out.print("==\n> ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				input = in.readLine();

				if(input.toLowerCase().equals("quit")){
					return new EndGameAction("Quit");
				}
				
				try{
					int sel = Integer.parseInt(input) - 1;

					if(sel >= 0 && sel < i && sel < actions.size()){
						return actions.get(sel);
					}
					
					
				}catch(NumberFormatException e){
					//thats okay with me.
				}
				
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
				return new EndGameAction("Game Fault");
			}
			System.out.println("Command Not recognized. Please try again.");
			System.out.println("");
		}while(true);

	}

}
