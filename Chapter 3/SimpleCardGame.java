public class SimpleCardGame {
	/*This is a simplified card game like "Blackjack"
	It is you versus the computer, but the computer does nothing except deal cards.
	Each turn within the round, you can tell the computer to "hit" or "stand"
	To 'hit' is to ask for another card. To 'stand' is to hold your total and end your game.
	
	Possible cards (with point values) are: "Ace" (1), "2" (2), "3" (3), "4" (4), "5" (5), "6" (6), 
	"7" (7), "8" (8), "9" (9), "10" (10), "Jack" (10), "Queen" (10), "King" (10)
	Note there are no suits. 
	
	The round ends when you either (a) reach 21  or (b) go over 21 or (c) 'stand' 
	At the end of the round, if your score is...
	1-12 --> you lose 2 tokens
	13-15 --> you lose 1 token
	16-17 --> you win 1 token
	18-20 --> you win 2 tokens  
	Exactly 21 --> you win 5 tokens   
	Go over 21 --> you lose 5 tokens
	
	You start off with 10 tokens.  
	If you reach 20 tokens, you win.  
	If you lose all your tokens, you lose the game.  
	Print out if you won/lost, along with how many rounds it took you. 
	*/
	public static void main(String[] args) {
        System.out.println("***Welcome to the Simple Card Game!***\n");
        System.out.println("Each turn within the round, you can choose to (h) hit or (s) stand\n");
        System.out.println("Each round goes until either (a) you reach 21  (b) you go over 21 or (c) you 'stand'");
        System.out.println("At the end of the round, a score of 1-12 means you lose 2 tokens\n"
        		+ "A score of 13-15 means you lose 1 token\nA score of 16 or 17 means you win 1 token\nA score of 18-20 means you win 2 tokens\n"
        		+ "A score of exactly 21 means you win 5 tokens\nA score of over 21 means You lose 5 tokens.\n");
        
        
        System.out.println("Play as many rounds as necessary to finish the game.");
        System.out.println("The game ends when you reach 20 tokens (you win), or you drop to 0 or lower tokens (you lose).");

        
        // In each round, keep displaying the user's current points and prompting the user to either hit or stand. 
        // Each ROUND goes until either (a) you reach 21  (b) you go over 21 or (c) you 'stand'  
        // At the end of each round, assign tokens based on the chart above, and display the total tokens  
        // The GAME goes until either you win (by reaching 20 tokens) or you lose (by reaching 0 or less tokens)
        // At the end of the game, print out if you won/lost, along with how many rounds it took you.
        
        // Feel free to use the variables/comments/starter code below (or not) in your implementation...
        // Declare, initialize variables 
        int roundsPlayed = 0;
        int currentTokens = 10;
        int yourScoreThisRound = 0;
        
        // Continually play ROUNDS until the game is finished. Call the playRound() method.
        while (currentTokens < 20 && currentTokens > 0) {
        	roundsPlayed++;
        	currentTokens = playRound(currentTokens);
        }
        // Now we know we either won or lost the GAME.  Print win/loss message, along with rounds played. 
        if (currentTokens >= 20) {
        	System.out.println("You won!!!");
        } else {
        	System.out.println("You lost...");
        }
        System.out.println("this took you:" + roundsPlayed + " rounds");
	}
	
	/**
	 * This function simulates playing a round of the simple card game. 
	 * Each turn within the round, you can tell the computer to "hit" or "stand"
	 * The round ends when you (a) you reach 21  or (b) you go over 21 or (c) you 'stand' 
	 * 
	 * @param tokens the current amount of tokens you have entering the round
	 * @return the result of the round. Possibilities: gain/lose either 5 points or 2 points or 1 point
	 */
	public static int playRound(int tokens) {
        System.out.println("Current total: " + tokens + " tokens.\n");
        System.out.println("***Starting a new round!***");  
        System.out.println("Remember: try to get really close to 21 without going over!");
        
        char move = 'h';
        int currentScoreThisRound = 0; 
        
        // Keep playing the round as long as...(think of the conditions for the round to keep going)
	    while (currentScoreThisRound < 21 && currentScoreThisRound >= 0 && move == ('h')) {
    		// Get input from the user for the next turn, check it for correctness. 
        	System.out.println("Current score this round: " + currentScoreThisRound + " points.");
        	System.out.print("Move? (h) hit or (s) stand: ");
        	move = Character.toLowerCase(TextIO.getlnChar());
	        
	        // Now we know the char is 'h' or 's' (you checked the input, right?)
        	if (move == 'h') {
        		currentScoreThisRound += dealRandomCard();
        	} else {
        		break;
        	}
        	
	    }
	    
	    if (currentScoreThisRound < 13) {
	    	tokens -= 2;
	    } else if (currentScoreThisRound < 15) {
	    	tokens--;
	    } else if (currentScoreThisRound < 18) {
	    	tokens++;
	    } else if (currentScoreThisRound < 21) {
	    	tokens += 2;
	    } else if (currentScoreThisRound == 21) {
	    	tokens += 5;
	    } else {
	    	tokens -= 5;
	    }
	   
        // The round is finished, return the result of the round back to main()
        return tokens; // fix this
	}
	
	/**
	 * This helper method 'deals' a random card by generating a 
	 * random integer from 1 - 13, printing out the name of the card
	 * associated with that number, e.g. "You drew a 4."  or "You drew a King."
	 * and then returns the point value associated with that card. 
	 * Possible cards (with point values) are: "Ace" (1), "2" (2), "3" (3), "4" (4), "5" (5), "6" (6), 
	 * "7" (7), "8" (8), "9" (9), "10" (10), "Jack" (10), "Queen" (10), "King" (10)
	 * Practice USING A SWITCH STATEMENT
	 * 
	 * @return the point value associated with the card
	 */
	public static int dealRandomCard() {
		int deal = (int)(Math.random() * 14);
		switch (deal) {
			case 1:
				System.out.println("You drew an ace");
				return 1;
			case 2:
				System.out.println("You drew a 2");
				return 2;
			case 3:
				System.out.println("You drew a 3");
				return 3;
			case 4:
				System.out.println("You drew a 4");
				return 4;
			case 5:
				System.out.println("You drew a 5");
				return 5;
			case 6:
				System.out.println("You drew a 6");
				return 6;
			case 7:
				System.out.println("You drew a 7");
				return 7;
			case 8:
				System.out.println("You drew a 8");
				return 8;
			case 9:
				System.out.println("You drew a 9");
				return 9;
			case 10:
				System.out.println("You drew a King");
				return 10;
			case 11:
				System.out.println("You drew a Queen");
				return 10;
			case 12:
				System.out.println("You drew a Jack");
				return 10;
			
		}
		return 0; // fix this
	}
	
}
