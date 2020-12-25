/**
 * 
 */
package cards;

/**
 * @author nhalstead
 *
 */
@SuppressWarnings("serial")
public class InvalidRankException extends Exception {

    /**
     * Prints a message
     * 
     * @param rank
     *            the int representing the rank of the invalid Card object
     */
    public InvalidRankException(int rank) {
        super(
            "Your rank is invalid. It must be an int 0-3 inclusive.\nYour suit: "
                + rank);
    }
}
