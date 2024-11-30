//Henry Lam
//11/29/24
//CPSC-39-12111

//package linkedLists;

/**
 * Main class to implement a simplified Blackjack card game.
 * Includes comments on each end brace for clarity.
 */

import java.util.Scanner;

public class CardGame { // Start of CardGame class.

    public static void main(String[] args) { // Start of main method.
        Scanner scanner = new Scanner(System.in); // Scanner for player input.
        Deck deck = new Deck(); // Initialize the deck.
        deck.shuffle(); // Shuffle the deck before starting.

        LinkedList playerHand = new LinkedList(); // Player's hand.
        LinkedList dealerHand = new LinkedList(); // Dealer's hand.

        // Deal initial cards to player and dealer.
        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());

        displayHandStatus(playerHand, dealerHand, false); // Display initial hand status.

        boolean playerTurn = true; // Tracks if it is the player's turn.

        // Player's turn loop.
        while (playerTurn) { // Start of player's turn loop.
            System.out.println("Would you like to (1) Hit or (2) Stand?");
            int choice = scanner.nextInt(); // Get player's choice.

            if (choice == 1) { // Start of if (player chooses Hit).
                Card newCard = deck.deal();
                playerHand.add(newCard);
                System.out.println("You drew: " + newCard);
                displayHandStatus(playerHand, dealerHand, false);

                if (calculateHandValue(playerHand) > 21) { // Start of if (player busts).
                    System.out.println("Bust! You lose.");
                    return; // Exit the game if player busts.
                } // End of if (player busts).
            } else if (choice == 2) { // Start of else-if (player chooses Stand).
                playerTurn = false; // End player's turn.
            } else { // Start of else (invalid input).
                System.out.println("Invalid choice. Please enter 1 or 2.");
            } // End of else.
        } // End of player's turn loop.

        // Dealer's turn loop.
        System.out.println("Dealer's turn:");
        while (calculateHandValue(dealerHand) < 17) { // Start of dealer's turn loop.
            Card newCard = deck.deal();
            dealerHand.add(newCard);
            System.out.println("Dealer drew: " + newCard);
        } // End of dealer's turn loop.

        displayHandStatus(playerHand, dealerHand, true); // Display final hand status.

        // Determine the winner.
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (dealerValue > 21 || playerValue > dealerValue) { // Start of if (player wins).
            System.out.println("You win!");
        } else if (playerValue < dealerValue) { // Start of else-if (dealer wins).
            System.out.println("Dealer wins!");
        } else { // Start of else (tie).
            System.out.println("It's a tie!");
        } // End of else.
    } // End of main method.

    /**
     * Calculates the total value of a hand (linked list of cards).
     */
    private static int calculateHandValue(LinkedList hand) { // Start of calculateHandValue method.
        int total = 0; // Tracks the total value of the hand.
        boolean hasAce = false; // Tracks if the hand contains an Ace.

        Link current = hand.head; // Start from the head of the list.

        while (current != null) { // Start of while loop (iterate through hand).
            Card card = current.getCard();
            total += card.getValue();

            if (card.getRank().equals("ace")) { // Start of if (card is Ace).
                hasAce = true;
            } // End of if (card is Ace).

            current = current.getNext(); // Move to the next card.
        } // End of while loop (iterate through hand).

        // Adjust for Ace if total exceeds 21.
        if (hasAce && total > 21) { // Start of if (adjust for Ace).
            total -= 10; // Reduce total by 10 to treat Ace as 1.
        } // End of if (adjust for Ace).

        return total;
    } // End of calculateHandValue method.

    /**
     * Displays the current status of the player's and dealer's hands, including scores.
     */
    private static void displayHandStatus(LinkedList playerHand, LinkedList dealerHand, boolean showDealerAll) { // Start of displayHandStatus method.
        System.out.println("Your cards: " + playerHand);
        System.out.println("Your current score: " + calculateHandValue(playerHand));

        if (showDealerAll) { // Start of if (reveal all dealer cards).
            System.out.println("Dealer's cards: " + dealerHand);
            System.out.println("Dealer's current score: " + calculateHandValue(dealerHand));
        } else { // Start of else (hide dealer's cards).
            System.out.println("Dealer's face-up card: " + dealerHand.head.getCard());
        } // End of else.
    } // End of displayHandStatus method.
} // End of CardGame class.
