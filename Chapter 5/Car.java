public class Car extends Vehicle{
	// instance variables
	// int registrationNumber, String owner inherited
	boolean isConvertible; 
	
	public Car(int registrationNumber, String owner, boolean isConvertible) {
		// trying to initialize variables...can't anymore because 
		// superclass variables are private!
		super(registrationNumber, owner);
		this.isConvertible = isConvertible;
	}

	// override inherited drive()
	public String drive() {
		return "vroom vroom vrooom";
	}
	
	public String driveTwice() {
		return this.drive() + this.drive();
	}
	
	public String driveTwiceLikeVehicle() {
		return super.drive() + super.drive();
	}
	
	// public void transferOwnership() inherited
}

