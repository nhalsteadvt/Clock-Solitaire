/**
 * 
 */
package cards;

/**
 * 
 * @author nhalstead
 *         Contains information for a Card object.
 *         rank represents the number on the card (1=A, 2, 3, ..., 13=King)
 *         suit is an integer representing the suit of the card:
 *         Diamonds, Spades, Hearts, Clubs
 */
public class Card {
    private int rank;
    private int suit;

    /**
     * Creates a Card object
     * 
     * @param rank
     *            number on the card, 1-13 inclusive (1=A, 2, 3, ..., 13=King)
     * @param suit
     *            an int, 0-3 inclusive, representing the suit of the card:
     *            0=Diamonds, 1=Spades, 2=Hearts, 3=Clubs
     * @throws InvalidRankException
     *             if the rank argument passed is invalid
     * @throws InvalidSuitException
     *             if the suit argument passed is invalid
     */
    public Card(int rank, int suit)
        throws InvalidRankException,
        InvalidSuitException {
        if (!isValidRank(rank)) {
            throw new InvalidRankException(rank);
        }

        if (!isValidSuit(suit)) {
            throw new InvalidSuitException(suit);
        }

        this.rank = rank;
        this.suit = suit;
    }


    /**
     * getter method for the rank of the Card
     * 
     * @return int representing Card's rank
     */
    public int getRank() {
        return rank;
    }


    /**
     * getter method for the rank of the Card
     * 
     * @return int representing Card's suit
     */
    public int getSuit() {
        return suit;
    }


    public boolean swap(Card other) {
        if (this.equals(other)) {
            return false;
        }

        int tempRank = this.rank;
        this.rank = other.rank;
        other.rank = tempRank;

        int tempSuit = this.suit;
        this.suit = other.suit;
        other.suit = tempSuit;

        return true;
    }


    /**
     * Checks if input is a valid rank for a Card object
     * 
     * @param rank
     *            int representing the rank
     * @return true if rank is valid (1-13 inclusive)
     */
    private boolean isValidRank(int rank) {
        if (rank < 1 || rank > 13) {
            return false;
        }
        return true;
    }


    /**
     * Checks if input is a valid suit for a Card object
     * 
     * @param suit
     *            int representing the suit
     * @return true if suit is valid (0-3 inclusive)
     */
    private boolean isValidSuit(int suit) {
        if (suit < 0 || suit > 3) {
            return false;
        }
        return true;
    }


    public String rankToString() {
        if (!isValidRank(rank)) {
            new InvalidRankException(rank);
        }

        String[] names = new String[] { "Ace", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        return names[rank - 1];
    }


    public String suitToString() {
        if (!isValidSuit(suit)) {
            new InvalidSuitException(suit);
        }

        switch (suit) {
            case 0:
                return "Diamonds";
            case 1:
                return "Spades";
            case 2:
                return "Hearts";
            case 3:
                return "Clubs";
            default:
                return "This state should be impossible";
        }
    }


    /**
     * the toString method
     */
    @Override
    public String toString() {
        return rankToString() + " of " + suitToString();
    }


    /**
     * the equals method
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Card that = (Card)other;
        if (this.rank - that.rank + this.suit - that.suit != 0) {
            return false;
        }
        return true;
    }

}
