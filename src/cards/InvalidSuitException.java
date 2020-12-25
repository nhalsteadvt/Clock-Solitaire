/**
 * 
 */
package cards;

/**
 * @author nhalstead
 *
 */
@SuppressWarnings("serial")
public class InvalidSuitException extends Exception {

    /**
     * Prints a message
     * 
     * @param suit
     *            the int representing the suit of the invalid Card object
     */
    public InvalidSuitException(int suit) {
        super(
            "Your suit is invalid. It must be an int 0-3 inclusive.\nYour suit: "
                + suit);
    }
}
