package club.cogs.demos.textengine.Exception;

public class InvalidSpawnException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7512938345839288940L;
	
	private final String name;

	public InvalidSpawnException(String name) {
		this.name = name;
	}
	
	public String getMessage(){
		return "Invalid Spawn Point \""+this.name+"\"";
	}

}
