public class HangmanGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hangman!");
		System.out.println("Once you guess incorrectly 10 times, you die.");
		String secretWord = getRandomWord();
		//System.out.println(secretWord);   //uncomment this line to see the secret word while playing
		
		String wordWithBlanks = convertWordToBlanks(secretWord);
		int numIncorrectGuesses = 0;
		
		// can modify to for loop
		while (numIncorrectGuesses < 10 && !(wordWithBlanks.equals(secretWord))) {
			System.out.println(wordWithBlanks);
			System.out.print("Please guess a character: ");
			
			char input = TextIO.getlnChar();
			if (secretWord.contains("" + input)) { // if they guessed correctly, fill in their correct guess
				wordWithBlanks = replaceBlanksWithChar(wordWithBlanks, secretWord, input);
			} 
			else { // otherwise, if they did not guess correctly...
				numIncorrectGuesses++;
				System.out.println("Sorry " + input + " isn't one of the letters");
				System.out.println("You have " + numIncorrectGuesses + " incorrect guesses, if you reach 10, you lose");
			}
			
			// check if they won or lost the game, or if the game just continues on.
			// print out the appropriate message if that is the case
			
		}
		
		if (wordWithBlanks.equals(secretWord)) {
			System.out.println("You won");
		} else {
			System.out.println("You lost");
		}

		System.out.println("Thanks for playing! Good bye!");
	}
	
	/**
	 * Example: convertWordToBlanks("dollop") returns "______"
	 * Example: convertWordToBlanks("") returns ""
	 * Example: convertWordToBlanks("The red hat") returns "___________"
	 * Example: convertWordToBlanks("r__ei__") returns "_______"
	 */
	public static String convertWordToBlanks(String word) {
		String wordWithBlanks = "";
		
		// fill in
		for (int i = 0 ; i < word.length(); i++) {
			wordWithBlanks += "_";
		}
		return wordWithBlanks;
	}
	
	/** 
	 * Example: countNumberOfBlanks("__b_l_") returns 4
	 * Example: countNumberOfBlanks("") returns 0
	 * Example: countNumberOfBlanks("hello") returns 0
	 * Example: countNumberOfBlanks("t_e_a_y") returns 3
	 */
	public static int countNumberOfBlanks(String word) {
		int count = 0;
		// fill in
		return count;
	}
	
	/** Example: replaceBlanksWithChar("__b_l_", "subtle", 't') returns "__btl_"
	  * Example: replaceBlanksWithChar("su__er", "supper", 'p') returns "supper"
	  * Example: replaceBlanksWithChar("__i____", "trident", 's') returns "__i____"
	  * Example: replaceBlanksWithChar("_______", "hepatitis", 'i') returns "_____i_is"
	  */
	public static String replaceBlanksWithChar(String wordWithBlanks, String secretWord, char ch) {
		String result = "";
		// fill in
		for (int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i) == ch) {
				result += ch;
			} else {
				result += wordWithBlanks.charAt(i);
			}
		}
		return result;
	}
	
	public static String getRandomWord() {
		// Generate a random integer from 0 - 9 (or more if you want a more interesting, varied game)
		// Based on that random integer, return a random word of your choosing 
		// Use a switch statement
		int rand = (int)(Math.random() * 10);
		switch (rand) {
			case 0:
				return "computer";
			case 1:
				return "programming";
			case 2:
				return "computer";
			case 3:
				return "desktop";
			case 4:
				return "bannister";
			case 5:
				return "development";
			case 6:
				return "ceiling";
			case 7:
				return "lollipop";
			default:
				return "tabletop";
		}	
		
	}

}
