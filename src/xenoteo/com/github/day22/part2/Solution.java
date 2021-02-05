package xenoteo.com.github.day22.part2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Playing a game of Recursive Combat.
 *
 * Recursive Combat still starts by splitting the cards into two decks. Then, the game consists of a series of rounds
 * with a few changes:
 * <ul>
 *     <li>
 *         Before either player deals a card, if there was a previous round in this game that had exactly the same cards
 *         in the same order in the same players' decks, the game instantly ends in a win for player 1. Previous rounds
 *         from other games are not considered. (This prevents infinite games of Recursive Combat, which everyone agrees
 *         is a bad idea.)
 *     </li>
 *     <li>
 *         Otherwise, this round's cards must be in a new configuration; the players begin the round by each drawing
 *         the top card of their deck as normal.
 *     </li>
 *     <li>
 *         If both players have at least as many cards remaining in their deck as the value of the card they just drew,
 *         the winner of the round is determined by playing a new game of Recursive Combat (see below).
 *     </li>
 *     <li>
 *         Otherwise, at least one player must not have enough cards left in their deck to recurse; the winner of the
 *         round is the player with the higher-value card.
 *     </li>
 * </ul>
 *
 * As in regular Combat, the winner of the round (even if they won the round by winning a sub-game) takes the two cards
 * dealt at the beginning of the round and places them on the bottom of their own deck (again so that the winner's card
 * is above the other card). The winner's card might be the lower-valued of the two cards if they won the round due to
 * winning a sub-game. If collecting cards by winning the round causes a player to have all of the cards, they win, and
 * the game ends.
 *
 * During a round of Recursive Combat, if both players have at least as many cards in their own decks as the number on
 * the card they just dealt, the winner of the round is determined by recursing into a sub-game of Recursive Combat.
 *
 * To play a sub-game of Recursive Combat, each player creates a new deck by making a copy of the next cards in their
 * deck (the quantity of cards copied is equal to the number on the card they drew to trigger the sub-game). During
 * this sub-game, the game that triggered it is on hold and completely unaffected; no cards are removed from players'
 * decks to form the sub-game.
 *
 * Once the game ends, you can calculate the winning player's score. The bottom card in their deck is worth the value
 * of the card multiplied by 1, the second-from-the-bottom card is worth the value of the card multiplied by 2, and so on.
 *
 * Class finding the winning player's score.
 */
public class Solution {

    /**
     * Finds the winning player's score.
     *
     * @param player1Cards  the list of the first player's cards
     * @param player2Cards  the list of the second player's cards
     * @return the winning player's score
     */
    public int winningPlayerScore(LinkedList<Integer> player1Cards, LinkedList<Integer> player2Cards){
        if (recursiveCombat(player1Cards, player2Cards) == 1)
            return countWinnerScore(player1Cards);
        else
            return countWinnerScore(player2Cards);
    }

    /**
     * Plays the game of Recursive Combat and finds the winner (either first or second winner).
     *
     * @param player1Cards  the list of the first player's cards
     * @param player2Cards  the list of the second player's cards
     * @return the number of winner (1 or 2)
     */
    private int recursiveCombat(LinkedList<Integer> player1Cards, LinkedList<Integer> player2Cards){
        Set<DeckState> roundsHistory = new HashSet<>();
        while (!player1Cards.isEmpty() && !player2Cards.isEmpty()){
            if (!roundsHistory.add(new DeckState(new LinkedList<>(player1Cards), new LinkedList<>(player2Cards)))) {
                return 1;
            }
            int player1Move = player1Cards.poll();
            int player2Move = player2Cards.poll();
            if (player1Move <= player1Cards.size() && player2Move <= player2Cards.size()){
                int winner = recursiveCombat(pollN(player1Cards, player1Move), pollN(player2Cards, player2Move));
                if (winner == 1){
                    player1Cards.add(player1Move);
                    player1Cards.add(player2Move);
                }
                else {
                    player2Cards.add(player2Move);
                    player2Cards.add(player1Move);
                }
            }
            else {
                if (player1Move > player2Move){
                    player1Cards.add(player1Move);
                    player1Cards.add(player2Move);
                }
                else {
                    player2Cards.add(player2Move);
                    player2Cards.add(player1Move);
                }
            }

        }
        if (player1Cards.isEmpty())
            return 2;
        else
            return 1;
    }

    /**
     * Creates a copy of list's first n element.
     *
     * @param list  the list
     * @param n  n
     * @return the copy of list's first n element
     */
    private LinkedList<Integer> pollN(LinkedList<Integer> list, int n){
        return new LinkedList<>(list).stream().limit(n).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Counts the winner's score.
     *
     * @param cards  the list of winner's cards
     * @return the winner's score
     */
    private int countWinnerScore(LinkedList<Integer> cards){
        int size = cards.size();
        return IntStream.range(0, size)
                .map(i -> cards.get(i) * (size - i))
                .sum();
    }
}
