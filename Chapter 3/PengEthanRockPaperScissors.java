import java.util.Scanner;
import java.lang.Math;

public class PengEthanRockPaperScissors {
	public static void main(String[] args) {
		int computerWins = 0;
		int playerWins = 0;
		boolean gameOver;
		String playerMove = "";
		String computerMove = "";
		Scanner scanner = new Scanner(System.in);
		while (computerWins < 2 && playerWins < 2) {
			gameOver = false;
			while (gameOver == false) {
				int ran = (int)(Math.random() * 3);
				switch(ran) {
				case 0:
					computerMove = "rock";
					break;
				case 1:
					computerMove = "scissors";
					break;
				default:
					computerMove = "paper";
				}
		
				System.out.print("Enter rock, paper, or scissors: ");
				playerMove = scanner.nextLine();
				if (!(playerMove.equals(computerMove))) {
					gameOver = true;
				} else {
					System.out.println("Computer move was: " + computerMove + " Player move was: " + playerMove + " Enter again");
				}
			}

			if (computerMove.equals("rock")) {
				if (playerMove.equals("scissors")) {
					computerWins++;
				} else {
					playerWins++;
				}
			}
			if (computerMove.equals("paper")) {
				if (playerMove.equals("rock")) {
					computerWins++;
				} else {
					playerWins++;
				}
			}
			if (computerMove.equals("scissors")) {
				if (playerMove.equals("paper")) {
					computerWins++;
				} else {
					playerWins++;
				}
			}
			System.out.println("Computer move was " + computerMove);
			System.out.println("Player move was " + playerMove);
			System.out.println("Player score: " + playerWins + " Computer Score: " + computerWins);
		}
		if (playerWins == 2) {
			System.out.println("player won");
		} else {
			System.out.println("computer won");
		}
	}
}