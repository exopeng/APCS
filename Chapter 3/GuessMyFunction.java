import java.util.Scanner;
public class GuessMyFunction {

	public static void main(String[] args) {
		printWelcomeAndRules(); // You may comment this out

		int score = 0;	// User's score (starts at 0, can go positive or negative, based on inquiries and guesses)
		Scanner scanner = new Scanner(System.in);
		// Pick My Secret Function, randomly
		char mySecretOperator = getRandomOperator(); 	// Set mySecretOperator as '+' '-' '*' or '/'
		int mySecretNumber = (int)(Math.random() * 10 + 1);  		// ** Fix: Pick a random integer from 1-10 using Math.random()
		// System.out.println("** For debugging.  mySecretOperator: " + mySecretOperator + ". mySecretNumber: " + mySecretNumber);
		String guess = "1";
		// Loop until the game is finished (when the user guesses the function)
		while (!(guess.charAt(0) == mySecretOperator && (guess.substring(1, guess.length()).equals(mySecretNumber + "")))) {
			System.out.print("Type a number or guess a function: ");
			guess = scanner.nextLine();
			if (!(guess.charAt(0) == '+' || guess.charAt(0) == '-' || guess.charAt(0) == '/' || guess.charAt(0) == '*')) {
				System.out.println("The output of my function is " + applyOperation(mySecretOperator, mySecretNumber, Double.parseDouble(guess)));
				score -= 1;
				
			} else {
				if (guess.substring(1, guess.length()).equals(mySecretNumber + "") && guess.charAt(0) == mySecretOperator) {
					System.out.println("Your figured it out");
					score += 10;
					
				} else {
					System.out.println("That isn't my function");
					score -= 5;
				}
			}
			System.out.println("Score: " + score);
		}
		
		// Prompt the user, then store the input.
		// YOU MAY ASSUME VALID INPUT 	(e.g. the input is either an 'inquiry' number like '7' or '10'
		// 								(or the input is a 'guess' like '*5' or '-6')

		// Determine whether the input was an inquiry or a guess, and take the appropriate action
		// When the game is finished, print out the final score.

		// Hint: the following lines of code can be used (or not):
		// while(someCondition) {
		// System.out.print("==> Type a number or guess a function: ");
		// String userInput = TextIO.getlnString();
		// char firstCharOfInput; // Can assume it represents the first char of an 'inquiry' or 'guess'

		// Double.parseDouble(someStringToChangeToADouble); 
		// }
	}

	/**
	 * This method generates a random number from 0-3 or 1-4, and then returns an operator 
	 * based on that random number. (either '+' '-' '*' or '/')
	 * YOU MUST USE A SWITCH STATEMENT
	 * 
	 * @return A random operator, as a char (either '+' '-' '*' or '/')
	 */
	public static char getRandomOperator() {
		int ran = (int)(Math.random() * 4);
		switch (ran) {
			case 0:
				return '+';
			case 1:
				return '-';
			case 2:
				return '*';
			default:
				return '/';
		}
	}

	/**
	 * This method implements the 'inquiry' functionality. A user types in an
	 * input inquiry number, e.g. '9' and then the return value is calculated
	 * based on the Secret number and Secret Operator chosen in the beginning.
	 * For example if the Secret Function is +10, and the input is 9, you should
	 * output 19. If the Secret Function is *10, and the input is 9, you should
	 * output 90.
	 * 
	 * @param op: the Secret Operator (either '+' '-' '*' or '/')
	 * @param num: the Secret Number that was set in the beginning.
	 * @param input: the users 'inquiry' input number 
	 * return the result of applying the Secret Number and Secret Operator as 
	 * a function to the user input. 
	 */
	public static double applyOperation(char op, int num, double input) {
		if (op == '+') {
			return input + (num);
		} else if (op == '-') {
			return input - (num);
		} else if (op == '*') {
			return input * (num);
		}
		return input / (num);  // ** Implement
	}

	
	
	// Don't modify this method
	private static void printWelcomeAndRules() {
		System.out.println("***Welcome to Guess My Function!***");
		System.out.println("I am thinking of a function that involves +, -, *, or /, plus a number from 1-10.");
		System.out.println("For example, it could be *3 (My Secret Function triples the input), or "
				+ "\nperhaps -5 (My Secret Function subtracts five from the input).\n");
		System.out.println("There are 2 types of input: 'inquiries' and 'guesses.'\n"
				+ "To make an 'inquiry', type in a number to see what my function would output");
		System.out.println("For example, typing in '3' if My Secret Function was *3 would output a 9.\n"
				+ "Typing in '8' would output 24.  This helps you discover the function.\n");
		System.out.println("When you are ready to 'guess', type in an operation followed by a number to guess the function");
		System.out.println("For example, you would type in *5 to guess that the function is Multiply by 5\n"
				+ "You would type in /3 to guess that the function is Divide by 3.\n");
		System.out.println("You lose 1 point every time you type in a number (i.e. every 'inquiry').");
		System.out.println("You get 10 points if you guess the correct function.");
		System.out.println("You lose 5 points for guessing the wrong function.\n");
		System.out.println("After you guess the function, your score will be printed out for you to see.\n");
	}
}
