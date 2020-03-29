public class Lion extends Animal implements Huntable {
	// instance variables
	private int maneLength;

	// constructor
	public Lion(String name) {
		super(name);
		maneLength = 10;
	}
	
	// instance methods
	public String makeSound() {
		return "ROOOAAAR!";
	}
	
	public String hunt() {
		return "catches antelope, kills it"; 
	}
	
}
