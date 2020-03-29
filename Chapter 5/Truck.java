// Template for Truck objects
public class Truck extends Vehicle {
	// instance variables
	int numOfWheels; // 18-wheeler? 22 wheeler?
	
	// constructor to initialize variables
	// issue is we are trying to initialize variables but they are
	// private in the superclass!  It is so strange...as a Truck object
	// I will 'have' an owner, but I can't directly access it/set it
	// I can use getters/setters...but in my constructor, I should call
	// the superclass's constructor.
	public Truck(int registrationNumber, String owner, int numOfWheels) {
		super(registrationNumber, owner);
		this.numOfWheels = numOfWheels;
		
	}
 
	// int registrationNumber, String owner inherited
	
	// public void transferOwnership() inherited
	
	// Since drive() is different, override
	public String drive() {
		return "bwaaaaaaaaaahhhh";
	}
}

