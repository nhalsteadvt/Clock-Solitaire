/**
 * 
 */
package cards;

/**
 * @author nhalstead
 *
 */
public class Runner {

    /**
     * @param args
     *            unused
     * @throws InvalidSuitException
     *             if suit invalid
     * @throws InvalidRankException
     *             if rank invalid
     */
    public static void main(String[] args)
        throws InvalidRankException,
        InvalidSuitException {
        Deck deck = new Deck(52);
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(rank, suit));
            }
        }

        deck.shuffle();

// while (!deck.isEmpty()) {
// System.out.println(deck.draw());
// }

        int total = 1000000;
        int won = 0;
        for (int i = 0; i < total; i++) {
            ClockSolitaire game = new ClockSolitaire();
            if (game.play()) {
                won++;
            }
        }
        double winPercentage = 100 * (double)won / total;
        System.out.println(won + "/" + total + "\t" + winPercentage + "%");

    }

}
