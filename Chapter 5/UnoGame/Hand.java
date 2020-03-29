import java.util.ArrayList;

public class Hand {
	private ArrayList<UnoCard> hand;
	
	public Hand(Deck deck) {
		hand = new ArrayList<UnoCard>();
	}
	
	public void drawCard(UnoCard card) {
		hand.add(card);
	}
	
	public UnoCard removeCard(int position) {
		UnoCard toRemove = hand.get(position);
		hand.remove(position);
		return toRemove;
	}
	
	public UnoCard showCard(int i) {
		return hand.get(i);
	}
	
	public int getLength() {
		return hand.size();
	}
	public String toString() {
		String str = "";
		for(int i = 0; i < hand.size(); i++) {
			str += "Card " + i + ": ";
			str += (hand.get(i)).toString() + "\n";
		}
		return str;
	}
}
