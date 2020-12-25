/**
 * 
 */
package cards;

/**
 * @author nhalstead
 *
 */
public class Deck {
    private ArrayBasedStack<Card> deck;
    private ArrayBasedStack<Card> discard;

    /**
     * contains Card objects in a stack
     * 
     * @param cardLimit
     *            max number of cards initially allowed
     */
    public Deck(int cardLimit) {
        deck = new ArrayBasedStack<>(cardLimit);
        discard = new ArrayBasedStack<>(cardLimit);
    }


    /**
     * Creates a new deck with an initial 52 card limit
     */
    public Deck() {
        deck = new ArrayBasedStack<>(52);
        discard = new ArrayBasedStack<>(52);
    }


    /**
     * creates a standard deck of cards (unshuffled)
     */
    public void setupClassic() {
        deck = new ArrayBasedStack<>(52);
        discard = new ArrayBasedStack<>(52);

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                try {
                    add(new Card(rank, suit));
                }
                catch (InvalidRankException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (InvalidSuitException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Tells if the deck is empty or not
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }


    /**
     * Tells if the discard is full or not
     * 
     * @return true if full, false otherwise
     */
    public boolean isDiscardFull() {
        return discard.capacity()==discard.size();
    }


    /**
     * adds new Card to top of Deck
     * 
     * @param card
     *            new Card object added to Deck
     */
    public void add(Card card) {
        deck.push(card);
    }


    /**
     * shuffles deck randomly
     */
    public void shuffle() {
        for (int n = 0; n < deck.size(); n++) {
            int index = (int)(deck.size() * Math.random());
            deck.get(n).swap(deck.get(index));
        }
    }
    
    /**
     * reverse order of the deck, leaves discard untouched
     */
    public void reverseDeck() {
        Object[] temp = deck.toArray();
        //Card[] reverse = (Card[])temp;
        deck.clear();
        for(int i = temp.length-1; i>=0; i--) {
            Card tempCard = (Card)temp[i];
            deck.push(tempCard);
        }
        
    }


    /**
     * pops a Card object off of the deck stack
     * 
     * @return Card object added to discard, null if empty
     */
    public Card draw() {
        if(deck.isEmpty()) {
            return null;
        }
        return deck.pop();
    }


    /**
     * pushes Card object onto the discard stack
     * 
     * @param card
     *            Card object being added to discard
     */
    public void discard(Card card) {
        discard.push(card);
    }

}
