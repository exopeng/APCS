import java.util.Scanner;

public class Plus4Card extends UnoCard {
	//wild cards have color Rainbow
	//wild cards have value -1
	public Plus4Card() {
		super("Rainbow");
		setValue(-1);
		
	}
	
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		Scanner scanner = new Scanner(System.in);
		if (!(deck.cardsLeft() <= 0)) {
			hand.drawCard(deck.dealCard());
			hand.drawCard(deck.dealCard());
			hand.drawCard(deck.dealCard());
			hand.drawCard(deck.dealCard());
			System.out.println("Sorry " + "The next player had to draw 4 cards");
		} else {
			System.out.println("No more cards in the deck, continue playing");
		}
		
		System.out.print("Which color (last player), Blue, Yellow, Red, Green");
		setColor((scanner.nextLine()));
		
	}
	public String toString() {
		return ("+4, value: " + getValue() + " color: " + this.getColor());
	}
	
}
