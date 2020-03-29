
public class DenialCard extends UnoCard{
	public DenialCard(String color) {
		super(color);
		setValue(-4);
	}
	
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		//add code to skip next player's turn
		System.out.println("Sorry next player, you have been skipped");
		
	}
	public String toString() {
		return ("DenialCard, value: " + getValue() + " color: " + this.getColor());
	}
}
