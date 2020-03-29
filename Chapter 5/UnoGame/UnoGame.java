import java.util.Scanner;
public class UnoGame {
	private Deck unoDeck = new Deck();
	private Hand[] unoHands;
	private PileCard pileCard = new PileCard("Red",0);
	private Direction clockWise = new Direction(true);
	private int player = 0;
	
	public UnoGame(int players) {
		unoHands = new Hand[players];
		for (int i = 0; i < players; i++) {
			unoHands[i] = new Hand(unoDeck);
		}
	}
	
	public void playGame() {
		System.out.println("MAKE SURE TO READ THE README FOR THE SPECIFIC RULES OF THIS GAME, I UNDERSTAND THERE ARE MANY VARIATIONS OF UNO BUT THIS IS THE ONE I KNOW");
		System.out.println("Also, action cards have a value, each type has their own value, which is negative, this is just so I can differentiate easily between action cards");
		System.out.println("Also, I assume valid input so if it asks for a number, give a number, asks for a color give a color");
		System.out.println("But its fine if you play a card that doesn't match the color or number, as I will just ask you again");
		System.out.println("If you are unable to play any valid card, I will draw 2 cards for you automatically");
		System.out.println("Scroll up to see the record of the game");
		Scanner scanner = new Scanner(System.in);
		//System.out.println("The Uno Deck:");
		//System.out.println(unoDeck);
		unoDeck.shuffle();
		//deal 7 cards to each hand
		for (int i = 0; i < unoHands.length; i++) {
			for (int j = 0; j < 7; j++) {
				unoHands[i].drawCard(unoDeck.dealCard());
			}
		}
		
		//deal 1 card to the pile to get initial color and value, make sure it isn't a wild or plus4 card
		UnoCard tempCard;
		do {
			tempCard = unoDeck.dealCard();
		} while((tempCard instanceof WildCard) || (tempCard instanceof Plus4Card));
		
		pileCard.setPileColor(tempCard.getColor());
		pileCard.setPileValue(tempCard.getValue());

		boolean gameOver = false;
		//let user decide any card to play, as long as it matches color and number if needed
		//int nextPlayer = 0;
		while (!gameOver) {
			//player = nextPlayer;
			playRound(scanner);
			System.out.println("====================New Round=====================");
			if (clockWise.getClockWise()) {
				player = (player + 1) % unoHands.length;
			} else {
				player = (player + unoHands.length - 1) % unoHands.length;
			}
			int whoWins = checkZeroCards();
			if (whoWins > - 1) {
				System.out.println("Player " + whoWins + " has won");
				gameOver = true;
			}
			
		}
		
	}	
	public int checkZeroCards() {
		//go through all hands to see if they have a length of zero
		//return which player has hand length 0, else return -1 if none of them have it
		for (int i = 0; i < unoHands.length; i++) {
			if (unoHands[i].getLength() == 0) {
				return i;
			}
		}
		return -1;
	}
	
	
	public void playRound(Scanner scanner) {
		currentStatus(player);
		UnoCard userCard;
		int index;
		boolean hasCard = true;
		
		//see if hand has the card at all
		for (int i = 0; i < unoHands[player].getLength(); i++) {
			UnoCard currCard =  unoHands[player].showCard(i);
			//card works if either wild/plus 4 card, same color, same value, or lack of value
			if (currCard instanceof WildCard || currCard instanceof Plus4Card || currCard.getColor().equals(pileCard.getPileColor()) || currCard.getValue() == pileCard.getPileValue()) {
				break;
			}
			if (i == unoHands[player].getLength() - 1) {
				hasCard = false;
			}
		}
		if (hasCard) {
			//let player choose a card
			do {
				System.out.println("Player " + player + " , play card index, make sure it matches the color or number if needed: ");
				index = Integer.parseInt(scanner.nextLine());
				userCard = unoHands[player].showCard(index);
			} while (!(userCard instanceof WildCard || userCard instanceof Plus4Card || userCard.getColor().equals(pileCard.getPileColor()) || userCard.getValue() == pileCard.getPileValue()));
			UnoCard temp1 = unoHands[player].removeCard(index);
			
			//special case, if it is a denial card, then the action is just add 1 to player or - 1 depending on the direction
			if (temp1 instanceof DenialCard) {
				if (clockWise.getClockWise()) {
					player++;
				} else {
					player--;
				}
			}
			
			//decide which player to take action on depending on direction
			
			if (clockWise.getClockWise()) {
				temp1.takeAction(unoHands[(player + 1) % (unoHands.length)], unoDeck, clockWise);
			} else {
				temp1.takeAction(unoHands[(player + unoHands.length - 1) % (unoHands.length)], unoDeck, clockWise);
			}
			pileCard.setPileColor(temp1.getColor());
			pileCard.setPileValue(temp1.getValue());
			
		} else {
			//if player doesn't have card, draw 2
			if (!(unoDeck.cardsLeft() <= 0)) {
				unoHands[player].drawCard(unoDeck.dealCard());
				unoHands[player].drawCard(unoDeck.dealCard());
				System.out.println("Sorry player " + player + " you had no choice except to draw 2 cards");
			} else {
				System.out.println("No more cards in the deck, continue playing");
			}
			
		}
		

		
		
	}
	public void currentStatus(int player) {
		System.out.println("Current Game Status, direction " + clockWise);
		System.out.println("Cards left: " + unoDeck.cardsLeft());
		String print = "Color on top of pile: " + pileCard.getPileColor() + ", Number on top of pile: " + pileCard.getPileValue();
		System.out.println(print);
		System.out.println();
		System.out.println("Player " + (player) + " Hand");
		System.out.println(unoHands[player]);
		
	}
}
