import java.util.Scanner;

public class YahtzeeGame {
	private int rounds = 13;
	private Scoreboard scorecard = new Scoreboard();
	YahtzeeDice die = new YahtzeeDice();
	
	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < rounds; i++) {
			playRound(die, scanner);
			System.out.println("Current Scorecard: ");
			System.out.println(scorecard.getScores());
			System.out.println();
			System.out.println(scorecard.checkScore(die));
			String valid = "";
			do {
				System.out.println("Enter the number which you want to pick");
				int num = Integer.parseInt(scanner.nextLine());
				valid = scorecard.changeScore(num, die);
				System.out.println(valid);
			} while (!valid.equals("Great, that hasn't been taken"));
			
			System.out.println("New Scores: ");
			System.out.println(scorecard.getScores());
		}
		System.out.println("End of Game, your final score:");
		System.out.println(scorecard.getScores());

		
		
	}
	
	public void playRound(YahtzeeDice dice, Scanner scanner) {
		dice.roll();
		System.out.println("The five dice read: " + java.util.Arrays.toString(dice.getDiceValues()));
		int turns = 2;
		while (turns > 0) {
			System.out.println("Turns left in this round " + turns);
			System.out.println("Would you like roll(r) or don't roll anymore(d): ");
			if (scanner.nextLine().equals("r")) {
				System.out.println("Hold any dice(h) or roll all(r)");
				if (scanner.nextLine().equals("h")) {
					dice.roll(holdDice(scanner));
					
				} else {
					dice.roll();
				}
				System.out.println("The five dice read: " + java.util.Arrays.toString(dice.getDiceValues()));
				turns--;
				
			} else {
				break;
			}
		}
		System.out.println("End of round");
	}
	
	public boolean[] holdDice(Scanner scanner) {
		boolean[] whichToRoll = new boolean[5];
		for (int i = 0; i < 5 ; i++) {
			System.out.println("Hold die " +  (i) + " (y) or don't hold(n)");
			if (scanner.nextLine().equals("y")) {
				whichToRoll[i] = true;
			}
		}
		return whichToRoll;
	}
}
