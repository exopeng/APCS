public class DeckTester {

	public static void main(String[] args) {
		Deck testDeck = new Deck(false);
		
		System.out.println(testDeck);
		
		testDeck.shuffle();
		
		System.out.println("Shuffled deck");
		
		System.out.println(testDeck);
	}
}
