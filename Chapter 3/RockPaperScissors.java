public class RockPaperScissors {
	// (2)*** Since constants are never changing, we use all caps
	// If you are sure the value will never change, we can declare 
	// the variable 'final'
	
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	public static final int HUMAN_WIN = 3;
	public static final int TIE = 4;
	public static final int HUMAN_LOSS = 5;
		
	public static void main(String[] args) {
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.print("What score do you want to play to? ");
		int numRequiredWins = TextIO.getlnInt();
		System.out.println("You will play against the computer.");
		System.out.println("The winner is the first person to win "
							+ numRequiredWins + " rounds.");
		int humanScore = 0;
		int compScore = 0;
		while (humanScore < numRequiredWins && compScore < numRequiredWins) {
			System.out.print("Enter your move (r, p, or s): ");
			char humanInput = TextIO.getlnChar();
			int humanMove;
			// (5)***Let's add code to handle the possible exceptions generated
			try {
				humanMove = interpretInput(humanInput);
			}
			catch(IllegalArgumentException e) {
				System.out.println(humanInput + " is an illegal input");
				continue;
			}
			int compMove = (int)(Math.random() * 3);
			System.out.println(getStringPicture(humanMove, compMove));
			int outcome = determineWinner(humanMove, compMove);
			if (outcome == HUMAN_WIN) {
				humanScore++;
				System.out.println("You win! Score is " + humanScore + " to " + compScore);
			}
			else if (outcome == TIE) {
				System.out.println("Tie. Score is still " + humanScore + " to " + compScore);
			}
			else {
				compScore++;
				System.out.println("You lose. Score is " + humanScore + " to " + compScore);
			}
			System.out.println();
		}
		if (humanScore > compScore) {
			System.out.println("Congratulations! You Win!");
		}
		else {
			System.out.println("You lost :(");
		}
	}
	
	
	// (1) *** Instead of using Strings to compare moves (what if I misspelld one of them?)
	// or messed up, comparing "rock".equals("RocK")?  It's safer to use CONSTANTS.
	// 
	public static int interpretInput(char input) {
		// (4) *** Add code to throw an IllegalArgumentException if the input isn't what we want
		switch (input) {
			case 'R':
			case 'r': 	
				return ROCK;
			case 'P':
			case 'p':	
				return PAPER;
			case 'S':
			case 's':	
				return SCISSORS;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static int determineWinner(int humanMove, int computerMove) {
		// (3)*** Our code can be more readable now
		if ( (humanMove == 0 && computerMove == 2) 
				|| (humanMove == 2 && computerMove == 1)
				|| (humanMove == 1 && computerMove == 0) )
			return HUMAN_WIN;
		else if (humanMove == computerMove)
			return TIE;
		else
			return HUMAN_LOSS;
	}

	public static String getStringPicture(int humanMove, int computerMove) {
		String youRockCompRock = "You         Comp\n\n __           __ \n/  \\         /  \\\n\\__/         \\__/";
		String youRockCompPaper = "You         Comp\n\n __            ___\n/  \\          /  /\n\\__/         /__/";
		String youRockCompScissors = "You         Comp\n\n __          O O\n/  \\          X\n\\__/         / \\";
		String youPaperCompRock = "You         Comp\n\n  ___          __ \n /  /         /  \\\n/__/          \\__/";
		String youPaperCompPaper = "You         Comp\n\n  ___           ___\n /  /          /  /\n/__/          /__/";
		String youPaperCompScissors = "You         Comp\n\n  ___         O O\n /  /          X\n/__/          / \\";
		String youScissorsCompRock = "You         Comp\n\nO O          __ \n X          /  \\\n/ \\         \\__/";
		String youScissorsCompPaper = "You         Comp\n\nO O           ___\n X           /  /\n/ \\         /__/";
		String youScissorsCompScissors = "You         Comp\n\nO O         O O\n X           X\n/ \\         / \\";
		if (humanMove == ROCK && computerMove == ROCK)
			return youRockCompRock;
		else if (humanMove == ROCK && computerMove == PAPER)
			return youRockCompPaper;
		else if (humanMove == ROCK && computerMove == SCISSORS)
			return youRockCompScissors;
		else if (humanMove == PAPER && computerMove == ROCK)
			return youPaperCompRock;
		else if (humanMove == PAPER && computerMove == PAPER)
			return youPaperCompPaper;
		else if (humanMove == PAPER && computerMove == SCISSORS)
			return youPaperCompScissors;
		else if (humanMove == SCISSORS && computerMove == ROCK)
			return youScissorsCompRock;
		else if (humanMove == SCISSORS && computerMove == PAPER)
			return youScissorsCompPaper;
		else
			return youScissorsCompScissors;
	}
}
