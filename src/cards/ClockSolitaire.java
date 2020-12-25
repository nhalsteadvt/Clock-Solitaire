/**
 * 
 */
package cards;

/**
 * @author nhalstead
 *
 */
public class ClockSolitaire {
    private Deck mainDeck;
    private Deck[] clock;
    private Card inHand;

    public ClockSolitaire() {
        mainDeck = new Deck();
        mainDeck.setupClassic();
        mainDeck.shuffle();

        clock = new Deck[13];

        for (int round = 0; round < 4; round++) {
            for (int hour = 0; hour < 13; hour++) {
                if (round == 0) {
                    clock[hour] = new Deck(4);
                }
                clock[hour].add(mainDeck.draw());
            }
        }
        inHand = clock[0].draw();
    }


    /**
     * performs one in-game action
     */
    public void step() {
        int moveTo = inHand.getRank();
        if (moveTo == 13) {
            moveTo = 0;
        }
        clock[moveTo].discard(inHand);
        inHand = clock[moveTo].draw();
    }


    /**
     * 
     * @return true if game won, false otherwise
     */
    public boolean play() {
        while (!isGameOver()) {
            step();
        }

        boolean won = isGameWon() ? true : false;
        String msg = won ? "won" : "lost";
        System.out.println("You " + msg + "!");
        return won;
    }


    public boolean isGameOver() {
        return isGameLost() || isGameWon();
    }


    public boolean isGameLost() {
        return clock[0].isDiscardFull();
    }


    public boolean isGameWon() {
        for (int i = 1; i < 13; i++) {
            if (!clock[i].isDiscardFull()) {
                return false;
            }
        }
        return true;
    }
}
