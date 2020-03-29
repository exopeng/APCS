public class RockPaperScissors {
	// Constants (marked final)
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	public static final int HUMAN_WIN = 3;
	public static final int TIE = 4;
	public static final int HUMAN_LOSS = 5;
	// Global variables that any subroutine can access (scope is whole class)
	public static int humanScore; // default is 0
	public static int compScore;

	public static void main(String[] args) {
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.print("What score do you want to play to? ");
		int numRequiredWins = TextIO.getlnInt();
		System.out.println("You will play against the computer.");
		System.out.println("The winner is the first person to win 2 rounds.");
		int humanMove = -1;
		int compMove = -1;
		// Keep looping as long as neither player has won yet
		while (humanScore < numRequiredWins && compScore < numRequiredWins) {
			// Get player input, make sure it's valid with do...while
			humanMove = findOutcome();
			// Generate random computer move (0: ROCK 1: PAPER 2: SCISSORS)
			compMove = (int)(Math.random() * 3);
			// Print moves out with ASCII to look pretty
			System.out.println(getASCII(humanMove, compMove));
			
			// Determine the outcome (3: HUMAN_WIN, 4: TIE, 5: HUMAN_LOSS)
			int outcome = outcomeDeterminer(humanMove, compMove);
			String outcomeString = "";
			// Print out the outcome of this round
			if (outcome == HUMAN_WIN) {
				humanScore++;
				outcomeString = "You win! Score is " + humanScore + " to " + compScore;
			}
			else if (outcome == TIE) {
				outcomeString = "Tie. Score is still " + humanScore + " to " + compScore;
			}
			else {
				compScore++;
				outcomeString = "You lose. Score is " + humanScore + " to " + compScore;
			}
			
			System.out.println(outcomeString);
			
			// End of this round, while loop while keep going until someone wins
		}
		
		// Finished while loop, somebody has won.  Determine who won.
		if (humanScore > compScore) {
			System.out.println("Congratulations! You Win!");
		}
		else {
			System.out.println("You lost :(");
		}
	}

	public static String getASCII(int humanMove, int computerMove) {
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
	public static int outcomeDeterminer(int humanMove, int compMove) {
		int outcome;
		if (humanMove == ROCK && compMove == SCISSORS 
				|| humanMove == PAPER && compMove == ROCK 
				|| humanMove == SCISSORS && compMove == PAPER ) {
			outcome = HUMAN_WIN;
		}
		else if (humanMove == compMove) {
			outcome = TIE;
		}
		else {
			outcome = HUMAN_LOSS;
		}
		return outcome;
	}
	public static int findOutcome() {
		int humanMove;
		do {
			System.out.print("Enter your move (r, p, or s): ");
			char humanInput = TextIO.getlnChar();
			humanMove = -1; // error code
			switch (humanInput) {
			case 'R':
			case 'r': 	
				humanMove = ROCK;
				break;
			case 'P':
			case 'p':	
				humanMove = PAPER;
				break;
			case 'S':
			case 's':	
				humanMove = SCISSORS;
				break;
			}
		} while(humanMove == -1);
		return humanMove;
	}
}

