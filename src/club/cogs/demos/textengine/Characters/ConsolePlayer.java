package club.cogs.demos.textengine.Characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import club.cogs.demos.textengine.Actions.Action;
import club.cogs.demos.textengine.Exception.NameConflictException;
import club.cogs.demos.textengine.Game.Level;

public class ConsolePlayer extends Player {
	
	public ConsolePlayer(String name, Level level) throws NameConflictException {
		super(name, level);
		// TODO Auto-generated constructor stub
	}

	public Action chooseAction(ArrayList<Action> actions) {
		
		if(actions == null)
			throw new IllegalArgumentException();
		
		int i = 1;

		
		String input = null;
		while(input == null){
			for(Action a : actions){
				System.out.println((i++) + ") "+ a);
			}
			
			System.out.println("Quit) QUIT GAME");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			
			try {
				input = in.readLine();
				if(input.toLowerCase().equals("quit")){
					return null;
				}
				
				try{
					int sel = Integer.parseInt(input);
					
					if(sel > 0 && sel < i && sel < actions.size()){
						return actions.get(sel);
					}
					
				}catch(NumberFormatException e){
					input = null;
				}
				
				
			} catch (IOException e) {
				input = null;
			}
		}

		Action s_action = super.chooseAction(actions);
		if(s_action != null){
			return s_action;
		}
		
		return null;
	}

}
