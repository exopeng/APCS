import java.util.Scanner;

public class RockPaperScissorsDebug {
	// Note: This person's problem is that result always is "tie"
	// For example, if Player is "rock", Computer is "scissors"
	// Player should win, but it always says "tie."
	// Note they've hardcoded the Computer as "scissors" to  
	// eliminate the randomness and help with debugging (this is fine) 
	
	// Let's set breakpoint on line 25.
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Hello! Welcome to Rock Paper Scissors!");
		System.out.println("We will be playing for best of three.");
		int playerWins = 0;
		int computerWins = 0;
		String playAgain = "yes";

		while (playAgain == "yes") {

			while (playerWins != 2 || computerWins != 2){
				System.out.println("Please enter rock, paper, or scissors:");
				String playerAnswer = scan.nextLine().toLowerCase(); 
				int computerNumber = 2; //(int)(Math.random()*3); // ***Hardcode for debug
				String computerAnswer;
				switch (computerNumber) {
				case 0:
					computerAnswer = "rock";
					break;
				case 1:
					computerAnswer = "paper";
					break;
				default:
					computerAnswer = "scissors";
					break;
				}
				System.out.println("I play " + computerAnswer);
				if ((computerAnswer == "rock" && playerAnswer == "scissors")
						|| (computerAnswer == "paper" && playerAnswer == "rock")
						|| (computerAnswer == "scissors" && playerAnswer == "paper")){

					System.out.println("HAHA! I win!");
					computerWins ++;
				} else if ((playerAnswer == "rock" && computerAnswer == "scissors")
						|| (playerAnswer == "paper" && computerAnswer == "rock")
						|| (playerAnswer == "scissors" && computerAnswer == "paper")){
					System.out.println("NOOO! You win.");
					playerWins ++;

				} else 
					System.out.println("We tied. Go again.");

			}

			if (playerWins == 2)
				System.out.println("Very well. You win.");
			else
				System.out.println("YESSSS. I WONNNNN!");

			System.out.println("Play again? Enter yes or no.");
			playAgain = scan.nextLine().toLowerCase(); // ask if they want to play another round of best of three
		}


	} // end of main
} // end of class