
public class VehicleTester {

	public static void main(String[] args) {
		Vehicle v = new Car(111, "Bob", true);
		Vehicle v2 = new Car(222, "Joe", false);
		v.drive();
		System.out.println(((Car)v).driveTwice());
		System.out.println(((Car)v).driveTwiceLikeVehicle());
		
	}

}
