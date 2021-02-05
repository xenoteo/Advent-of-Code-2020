package xenoteo.com.github.day22.part2;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Class representing a deck state (the configuration of the first and second players' cards).
 */
public class DeckState {
    /**
     * The list of the first player's cards.
     */
    private final LinkedList<Integer> player1Cards;

    /**
     * The list of the second player's cards.
     */
    private final LinkedList<Integer> player2Cards;

    public DeckState(LinkedList<Integer> player1Cards, LinkedList<Integer> player2Cards) {
        this.player1Cards = player1Cards;
        this.player2Cards = player2Cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckState deckState = (DeckState) o;
        return Objects.equals(player1Cards, deckState.player1Cards) && Objects.equals(player2Cards, deckState.player2Cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Cards, player2Cards);
    }
}
