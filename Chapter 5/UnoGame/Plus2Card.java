
public class Plus2Card extends UnoCard {
	public Plus2Card(String color) {
		super(color);
		setValue(-3);
	}
	
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		if (!(deck.cardsLeft() <= 0)) {
			hand.drawCard(deck.dealCard());
			hand.drawCard(deck.dealCard());
			System.out.println("Sorry " + "The next player had to draw 2 cards");
		} else {
			System.out.println("No more cards in the deck, continue playing");
		}
		
	}
	
	public String toString() {
		return ("+2, value: " + getValue() + " color: " + this.getColor());
	}
}
