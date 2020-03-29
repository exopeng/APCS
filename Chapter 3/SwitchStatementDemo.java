public class SwitchStatementDemo {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Magnificent Picking Game!\nTry to pick a different suit than the computer");
		String yourSuit;
		String compSuit;
		char input;
		
		do {
			System.out.print("Choose suit (h)earts / (c)lubs / (d)iamonds / (s)pades: ");
			input = TextIO.getlnChar();
		} while(!isValid(input));

		yourSuit = convertCharToSuit(input);
		compSuit = getRandomSuit();
		
		System.out.println("Your suit is: " + yourSuit);
		System.out.println("Computer's suit is: " + compSuit);	
		
		if(yourSuit.equals(compSuit)) 
			System.out.println("**You lose!**");
		else 
			System.out.println("**You win!**"); 

	}
	
	// Returns true if char c is one of the allowed inputs.
	// Returns false otherwise. 
	public static boolean isValid(char c) {
		
		// Because char is a primitive type it doesn't have methods (String is different, remember). 
		// So, we have a "wrapper" class called Character that has some useful static methods
		if (c == 'h' || c == 'd' || c == 's' || c == 'c') {
			return true;
		}
		return false;
	}
	
	// Picks and returns a random String representing a suit, 
	// either "Hearts" "Clubs" "Diamonds" or "Spades".
	// Use a switch statement to pick the suit, after generating a random number.
	public static String getRandomSuit(){
		//generate random number from 0 to 3, return suit based on that number
		int randNum = (int)Math.random() * 4;
		switch(randNum) {
		case 0:
			return "Hearts";
		case 1:
			return "Spades";
		case 2:
			return "Diamonds";
		default:
			return "Clubs";
		}
	}
	
	// Returns a String representing a suit, 
	// either "Hearts" "Clubs" "Diamonds" or "Spades",
	// based on the users input, which is passed in as a parameter. 
	// Use a switch statement to return a String, based on the char ch. 
	public static String convertCharToSuit(char ch) {
		String str = "";
		
		switch(ch) { //switch on value of char
		case 'h';
			str = "Hearts";
			break;
		case 'c':
			str = "Clubs";
			break;
		case 'd':
			str = "Diamonds";
			break;
		default:
			str = "Spades";
		}
		

	}
}
