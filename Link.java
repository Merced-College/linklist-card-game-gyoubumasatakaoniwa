//Henry Lam
//11/28/24
//CPSC-39-12111

/**
 * Represents a node in a linked list that holds a card.
 * Comments added for each end brace for clarity.
 */

public class Link { // Start of Link class.

    private Card card; // The card object this link holds.
    private Link next; // Reference to the next link in the list.

    // Constructor for Link.
    public Link(Card card) { // Start of constructor.
        this.card = card;
        this.next = null;
    } // End of constructor.

    // Getter for the card.
    public Card getCard() { // Start of getCard method.
        return card;
    } // End of getCard method.

    // Getter for the next link.
    public Link getNext() { // Start of getNext method.
        return next;
    } // End of getNext method.

    // Setter for the next link.
    public void setNext(Link next) { // Start of setNext method.
        this.next = next;
    } // End of setNext method.

    @Override
    public String toString() { // Start of toString method.
        return card.toString();
    } // End of toString method.
} // End of Link class.
