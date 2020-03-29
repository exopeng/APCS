public class Zoo {
	
	// instance variables
					// (1) what kind of array can hold Owls and Lions?
	
	
	public static void main(String[] args) {
		// (2) what is the misunderstanding here (remember, main() is STATIC)?
		Animal[] animals = new Animal[3];
		animals[0] = new Owl("Hedwig");
		animals[1] = new Owl("Mr. Owl");
		animals[2] = new Lion("Leo");
		for(int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].makeSound());
		}
		for(int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].sleep());
		}
		
		Huntable[] huntables = new Huntable[2];
		huntables[0] = new Lion("Aslan");
		huntables[1] = new KillerRobot();
		for(int i = 0; i < huntables.length; i++) {
			System.out.println(huntables[i].hunt());
		}
		
	}
	
	
}
