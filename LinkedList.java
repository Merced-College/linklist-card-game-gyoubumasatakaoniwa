//Henry Lam
//11/28/24
//CPSC-39-12111

/**
 * A simple linked list implementation for storing cards.
 * Comments added for each end brace for clarity.
 */

public class LinkedList { // Start of LinkedList class.

    Link head; // Head of the linked list.

    // Adds a new card to the end of the list.
    public void add(Card card) { // Start of add method.
        Link newLink = new Link(card);

        if (head == null) { // Start of if (list is empty).
            head = newLink; // Set new link as the head.
        } else { // Start of else (list is not empty).
            Link current = head;

            while (current.getNext() != null) { // Start of while loop (traverse to end of list).
                current = current.getNext();
            } // End of while loop (traverse to end of list).

            current.setNext(newLink); // Append new link at the end.
        } // End of else.
    } // End of add method.

    @Override
    public String toString() { // Start of toString method.
        StringBuilder sb = new StringBuilder();
        Link current = head;

        while (current != null) { // Start of while loop (traverse the list).
            sb.append(current).append(" ");
            current = current.getNext();
        } // End of while loop (traverse the list).

        return sb.toString().trim();
    } // End of toString method.
} // End of LinkedList class.
