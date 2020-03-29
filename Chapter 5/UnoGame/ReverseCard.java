
public class ReverseCard extends UnoCard {
	public ReverseCard(String color) {
		super(color);
		setValue(-2);
	}
	
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		
		if (direction.getClockWise()) {
			direction.setClockWise(false);
		} else {
			direction.setClockWise(true);
		}
		System.out.println("Direction has been changed to: " + direction);
	}
	public String toString() {
		return ("ReverseCard, value: " + getValue() + " color: " + this.getColor());
	}
}
