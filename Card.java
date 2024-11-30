//Henry Lam
//11/27/24
//CPSC-39-12111

//package cardGame;

/**
 * Represents a single playing card.
 * Each card has a suit, rank, value, and an associated image file name.
 * Comments added for each end brace for clarity.
 */

public class Card { // Start of Card class.

    private String suit;   // The suit of the card (e.g., "heart").
    private String rank;   // The rank of the card (e.g., "ace").
    private int value;     // The value of the card (e.g., 11 for an ace).
    private String image;  // The file name of the card's image.

    // Constructor to initialize a card.
    public Card(String suit, String rank, int value, String image) { // Start of constructor.
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.image = image;
    } // End of constructor.

    // Getter for the suit of the card.
    public String getSuit() { // Start of getSuit method.
        return suit;
    } // End of getSuit method.

    // Getter for the rank of the card.
    public String getRank() { // Start of getRank method.
        return rank;
    } // End of getRank method.

    // Getter for the value of the card.
    public int getValue() { // Start of getValue method.
        return value;
    } // End of getValue method.

    // Getter for the image file name of the card.
    public String getImage() { // Start of getImage method.
        return image;
    } // End of getImage method.

    // Provides a string representation of the card.
    @Override
    public String toString() { // Start of toString method.
        return rank + " of " + suit + " (value: " + value + ")";
    } // End of toString method.
} // End of Card class.
