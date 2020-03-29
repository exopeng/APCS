public class Owl extends Animal {
	// instance variables
	
	public Owl(String name) {
		super(name);
	}
	// instance methods
	public String makeSound() {
		return "Whoooo hooo hooo";
	}
	
	public String sleep() {
		return "DayTime" + super.sleep();
	}
	
	
	
	
}
