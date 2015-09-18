package club.cogs.demos.textengine.Game;

public class InvalidSpawnException extends RuntimeException {
	
	private final String name;

	public InvalidSpawnException(String name) {
		this.name = name;
	}
	
	public String getMessage(){
		return "Invalid Spawn Point \""+this.name+"\"";
	}

}
