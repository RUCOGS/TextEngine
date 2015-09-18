package club.cogs.demos.textengine.Exception;

public class NameConflictException extends Exception {
	
	private final String name;
	
	public NameConflictException(String name){
		this.name = name;
	}
	
	public String getMessage(){
		return "Name \""+name+"\" already in use";
	}

}
