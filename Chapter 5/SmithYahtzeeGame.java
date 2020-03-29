public class SmithYahtzeeGame {
	// instance variables
	private SmithYahtzeeDice gameDice = new SmithYahtzeeDice(); // game HAS Yahtzee Dice
	private SmithScoreCard scoreCard = new SmithScoreCard(); // game HAS a score card.
	//int totalScore = 0; ***Conceptually, ScoreCard object will keep track

	public static void main(String[] args) {
		SmithYahtzeeGame game = new SmithYahtzeeGame();
		game.playRound();
		game.playRound();
		game.playRound();
		System.out.println("\nGAME OVER!\n");
		System.out.println("******Final score: 0");  
	}
	
	public void playRound() {		
		System.out.println("Rolling...");
		gameDice.rollAll();
		System.out.println(gameDice); 
		
		System.out.print("Enter any character and press enter to continue: ");
		TextIO.getlnString();
			
		// Now we have dice in their final 'state' for the round
		// Print out potential scores ( method in ScoreCard class...note I pass in int[] )
		System.out.println(scoreCard.getPotentialScores(gameDice.getDiceValues()));
		// Then print out actual score ( just call .toString() on ScoreCard )
		System.out.println(scoreCard);
	}

}
