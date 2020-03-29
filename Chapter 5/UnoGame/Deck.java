/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards and that can
 *  also optionally include two Jokers.
 */
public class Deck {

    private UnoCard[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int cardsUsed;

   
    public Deck() {
        deck = new UnoCard[108];
        int cardCt = 0; // How many cards have been created so far.
        //deal all cards of each suit
        for (int currentColorValue = 0; currentColorValue <= 3; currentColorValue++) {
        	String currentColor = "";
        	switch (currentColorValue) {
        		case 0:
        			currentColor = "Blue";
        			break;
        		case 1:
        			currentColor = "Red";
        			break;
        		case 2:
        			currentColor = "Yellow";
        			break;
        		default:
        			currentColor = "Green";
        		
        	}
        	
    		//18 "1 - 9"regular cards
    		for (int i = 0; i < 2; i++) {
    			for(int currentValue = 1; currentValue <= 9; currentValue++) {
        			// (1)***fill in lines to create Card objects in each slot of the Card[] named 'deck'
        			deck[cardCt] = new RegularCard(currentColor,currentValue);
        			cardCt++;
        		}
    		}
    		
    		// 1 "0" card
    		deck[cardCt] = new RegularCard(currentColor, 0);
			cardCt++;
			
    		// 2 DrawTwo cards
    		deck[cardCt] = new Plus2Card(currentColor);
    		cardCt++;
    		
    		deck[cardCt] = new Plus2Card(currentColor);
    		cardCt++;
    		
    		//2 Skip Cards
    		deck[cardCt] = new DenialCard(currentColor);
    		cardCt++;
    		deck[cardCt] = new DenialCard(currentColor);
    		cardCt++;
    		
    		//2 Reverse Cards
    		deck[cardCt] = new ReverseCard(currentColor);
    		cardCt++;
    		deck[cardCt] = new ReverseCard(currentColor);
    		cardCt++;
        }	
        //4 wild cards
        deck[cardCt] = new WildCard();
        cardCt++;
        deck[cardCt] = new WildCard();
        cardCt++;
        deck[cardCt] = new WildCard();
        cardCt++;
        deck[cardCt] = new WildCard();
        cardCt++;
        
        //4 Plus4 wild cards
        deck[cardCt] = new Plus4Card();
        cardCt++;
        deck[cardCt] = new Plus4Card();
        cardCt++;
        deck[cardCt] = new Plus4Card();
        cardCt++;
        deck[cardCt] = new Plus4Card();
        cardCt++;
        
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() { 	
    		//***(3) Go through and place the Cards in 'deck' in a random order.
    		// Make sure every place in the Card[] 'deck'
    		// is still filled with Cards, however,
    		// to avoid a NullPointerException
    		for (int i = 0; i < deck.length; i++) {
    			int position = (int)(Math.random() * 108);
    			UnoCard temp = deck[position];
    			deck[position] = deck[i];
    			deck[i] = temp;
    		}

    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck.  The return value would be
     * 52 or 54 (depending on whether the deck includes Jokers)
     * when the deck is first created or after the deck has been
     * shuffled.  It decreases by 1 each time the dealCard() method
     * is called.
     */
    public int cardsLeft() { 
        return deck.length - cardsUsed;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the cardsLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public UnoCard dealCard() {

        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
    	cardsUsed++;
    	return deck[cardsUsed - 1];
    }

    public String toString() {
    		String str = "";
    		for(int i = 0; i < deck.length; i++) {
    			str += deck[i].toString();
    			if(i == deck.length - 1)
    				str += ".";
    			else
    				str += ", ";
    			if(i > 0 && i % 4 == 0)
    				str += "\n";
    		}
    		return str;
    }

} // end class Deck
