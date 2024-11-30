//Henry Lam
//11/27/24
//CPSC-39-12111

/**
 * Represents a deck of cards.
 * Includes functionality for shuffling and dealing cards.
 * Comments added for each end brace for clarity.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck { // Start of Deck class.

    private ArrayList<Card> cards; // The list of cards in the deck.

    // Constructor that initializes the deck by reading from cards.txt.
    public Deck() { // Start of constructor.
        cards = new ArrayList<>();
        initializeDeck();
    } // End of constructor.

    // Initializes the deck from the predefined cards.txt file.
    private void initializeDeck() { // Start of initializeDeck method.
        String[] suits = {"heart", "diamond", "club", "spade"};
        String[] ranks = {"ace", "king", "queen", "jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two"};
        int[] values = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < suits.length; i++) { // Start of for loop (iterate through suits).
            for (int j = 0; j < ranks.length; j++) { // Start of nested for loop (iterate through ranks).
                cards.add(new Card(suits[i], ranks[j], values[j], ranks[j].charAt(0) + suits[i].substring(0, 1) + ".gif"));
            } // End of nested for loop (iterate through ranks).
        } // End of for loop (iterate through suits).
    } // End of initializeDeck method.

    // Shuffles the deck.
    public void shuffle() { // Start of shuffle method.
        Collections.shuffle(cards);
    } // End of shuffle method.

    // Deals the top card from the deck.
    public Card deal() { // Start of deal method.
        if (!cards.isEmpty()) { // Start of if (deck is not empty).
            return cards.remove(0); // Remove and return the top card.
        } else { // Start of else (deck is empty).
            System.out.println("The deck is empty!");
            return null; // Return null if no cards are left.
        } // End of else.
    } // End of deal method.

    // Returns the number of cards left in the deck.
    public int size() { // Start of size method.
        return cards.size();
    } // End of size method.
} // End of Deck class.
