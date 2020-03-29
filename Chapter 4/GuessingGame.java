
public class GuessingGame {
	//global vars have default values, local don't
	private static int roundsPlayed = 0;
	private static int roundsWon;
	
	public static void main(String[] args) {
		welcomePrinter();
		boolean playAgain;
		

		do {
			playRound();
			System.out.println();   
			System.out.print("Would you like to play again? ");
			playAgain = TextIO.getlnBoolean();
		} while (playAgain);
		System.out.println("You played " + roundsPlayed + " rounds");
		System.out.println("You won " + roundsWon + "rounds")
		System.out.println("Thanks for playing.  Goodbye.");
	}

	public static void welcomePrinter() {
		System.out.println();
		System.out.print("What is your first guess? ");
	}
	
	private static void playRound() {
		int computersNumber; // A random number picked by the computer.
		int usersGuess;      // A number entered by user as a guess.
		int guessCount;      // Number of guesses the user has made.
		roundsPlayed++;
		computersNumber = (int)(100 * Math.random()) + 1;
		guessCount = 0;
		System.out.println();
		System.out.print("What is your first guess? ");
		while (true) {
			usersGuess = TextIO.getInt();  // Get the user’s guess.
			guessCount++;
			if (usersGuess == computersNumber) {
				System.out.println("You got it in " + guessCount
						+ " guesses!  My number was " + computersNumber);
				break;  // The game is over; the user has won.
			}
	
			if (guessCount == 6) {
				System.out.println("You didn’t get the number in 6 guesses.");
				System.out.println("You lose.  My number was " + computersNumber);
				roundsWon++;
				break;  // The game is over; the user has lost.
			}
			// If we get to this point, the game continues.
			// Tell the user if the guess was too high or too low.
			if (usersGuess < computersNumber)
				System.out.print("That’s too low.  Try again: ");
			else if (usersGuess > computersNumber)
				System.out.print("That’s too high.  Try again: ");
		} //end of while(true)
	}
}
