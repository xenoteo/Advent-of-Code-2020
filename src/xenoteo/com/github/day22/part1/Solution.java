package xenoteo.com.github.day22.part1;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 *
 * Playing a game of Combat.
 *
 * Before the game starts, the cards are split so each player has their own deck. Then, the game consists of a series
 * of rounds: both players draw their top card, and the player with the higher-valued card wins the round. The winner
 * keeps both cards, placing them on the bottom of their own deck so that the winner's card is above the other card.
 * If this causes a player to have all of the cards, they win, and the game ends.
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
        while (!player1Cards.isEmpty() && !player2Cards.isEmpty()){
            int player1Move = player1Cards.poll();
            int player2Move = player2Cards.poll();
            if (player1Move > player2Move){
                player1Cards.add(player1Move);
                player1Cards.add(player2Move);
            }
            else {
                player2Cards.add(player2Move);
                player2Cards.add(player1Move);
            }
        }
        if (player1Cards.isEmpty())
            return countWinnerScore(player2Cards);
        else
            return countWinnerScore(player1Cards);
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
