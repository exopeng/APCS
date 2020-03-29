public class Motorcycle extends Vehicle {
	// int registrationNumber, String owner inherited
	
	// public void transferOwnership() inherited
	
	public Motorcycle(int registationNumber, String owner) {
		super(registationNumber, owner);
	}
	
	// override drive()
	public String drive() {
		return "vrooooooom";
	}
	// can add functionality specific to Motorcycles
	public void doWheelie() {
		System.out.println("...pops wheelie");
	}
}



