// Potential Giant names if you are feeling uncreative:
// Goliath, Cyclops, Titan, Paul Bunyan, Andre, The BFG, Grog, Thag
// Potential Elf names if you are feeling uncreative:
// Galadriel, Legolas, Elrond, Tauriel, Dobby, Link, Snap, Crackle, Pop
// Potential Wizard names if you are feeling uncreative:
// Harry, Ron, Dumbledore, Voldemort, Gandalf, Saruman, Tim the Enchanter, Merlin
		
public class DuelGame {
	
	public static void main(String[] args) {
		// 1) Create an array that holds 2 Giants, 2 Elfs, 2 Wizards.
		FantasyCharacter[] array = new FantasyCharacter[6];
		array[0] = new Giant("Andre");
		array[1] = new Giant("Goliath");
		array[2] = new Elf("Galadriel");
		array[3] = new Elf("Elrond");
		array[4] = new Wizard("Harry");
		array[5] = new Wizard("Dumbledore");
		
		// 2) Randomly select 2 DIFFERENT participants to duel, and then start the duel.
		
		// THIS PART IS ONLY WORTH .5 POINTS, ~2% OF CODING TEST GRADE
		// 3) Ensure that two members from the same race CAN'T duel each other 
		// (e.g Giant vs. Giant, Elf vs. Elf, Wizard vs. Wizard is not OK)
		// How to do this?? 
		// 
		// From the text: "It is even possible to test whether a given object 				 
		// belongs to a given class, using the 'instanceof' operator. Example:
		// Vehicle myVehicle = new Car();
		// if (myVehicle instanceof Car) {...} --> would evaluate to true, evaluate {}
		// if (myVehicle instanceof Truck) {...} --> would evaluate to false, skip {}
	
	
		//change this to select 2 different participants, from 2 different races from a group of 6
		
		//0 is first race, 1 is second race, 2 is third race
		int whichCharacter = (int)(Math.random() * 3);
		
		//get character from different race
		int whichCharacter1 = 0;
		do {
			whichCharacter1 = (int)(Math.random() * 3);
			
		} while(whichCharacter1 == whichCharacter);
		
		FantasyCharacter[] firstRace = new FantasyCharacter[2];
		firstRace[0] = array[whichCharacter * 2];
		firstRace[1] = array[whichCharacter * 2 + 1];
		
		FantasyCharacter[] secondRace = new FantasyCharacter[2];
		secondRace[0] = array[whichCharacter1 * 2];
		secondRace[1] = array[whichCharacter1 * 2 + 1];
		
		FantasyCharacter c1 = firstRace[(int)(Math.random() * 2)];
		FantasyCharacter c2 = secondRace[(int)(Math.random() * 2)];
		Duel duel = new Duel(c1, c2);
		duel.startDuel();
	}

}
