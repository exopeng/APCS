// abstract class = can't instantiate Vehicle
// Vehicle v = new Vehicle() <--- Nope! 
public abstract class Vehicle {
	// instance variables 
	private int registationNumber;
	private String owner;
	
	// constructor - initialize variables
	public Vehicle(int registationNumber, String owner) {
		this.registationNumber = registationNumber;
		this.owner = owner;
	}

	public int getRegistationNumber() {
		return registationNumber;
	}

	public void setRegistationNumber(int registationNumber) {
		this.registationNumber = registationNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	// (will be inherited by subclasses)
	public void transferOwnership(String newOwner) {
		owner = newOwner;
	}
	
	// Need drive() to not be abstract to demo using super.drive()
	public String drive() {
		return "drive in a default way";
	}
	
}




