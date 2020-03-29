import java.util.Scanner;

public class WildCard extends UnoCard {
	//color of wildCards is rainbow
	public WildCard() {
		super("Rainbow");
		setValue(-1);
	}
	
	public void takeAction(Hand hand, Deck deck, Direction direction) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which color (last player), Blue, Yellow, Red, Green");
		setColor((scanner.nextLine()));
	}
	

	public String toString() {
		return ("WildCard, value: " + getValue() + " color: " + this.getColor());
	}
}
