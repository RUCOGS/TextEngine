package club.cogs.demos.textengine.Exception;

public class NameConflictException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2087159193518845578L;
	
	private final String name;
	
	public NameConflictException(String name){
		this.name = name;
	}
	
	public String getMessage(){
		return "Name \""+name+"\" already in use";
	}

}
