
public class RegularCard extends UnoCard {
	public RegularCard(String color, int value) {
		super(color,value);
	}
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		//doesn't do anything as its regular card
	}
	
	public String toString() {
		return ("value: " + this.getValue() + " color: " + this.getColor());
	}
}
