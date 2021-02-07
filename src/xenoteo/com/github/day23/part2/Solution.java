package xenoteo.com.github.day23.part2;

/**
 * The crab is going to mix up some cups, and you have to predict where they'll end up.
 *
 * The cups will be arranged in a circle and labeled clockwise. The crab starts arranging many cups in a circle on the
 * raft - one million (1000000) in total. (For example, if the labeling were 54321, the cups would be numbered 5, 4, 3,
 * 2, 1, and then start counting up from 6 until one million is reached.) In this way, every number from one through one
 * million is used exactly once.
 *
 * Before the crab starts, it will designate the first cup in the list as the current cup. The crab is then going to
 * do 10000000 moves.
 *
 * Each move, the crab does the following actions:
 * <ul>
 *     <li>
 *         The crab picks up the three cups that are immediately clockwise of the current cup. They are removed from
 *         the circle; cup spacing is adjusted as necessary to maintain the circle.
 *     </li>
 *     <li>
 *         The crab selects a destination cup: the cup with a label equal to the current cup's label minus one. If this
 *         would select one of the cups that was just picked up, the crab will keep subtracting one until it finds a cup
 *         that wasn't just picked up. If at any point in this process the value goes below the lowest value on any
 *         cup's label, it wraps around to the highest value on any cup's label instead.
 *     </li>
 *     <li>
 *         The crab places the cups it just picked up so that they are immediately clockwise of the destination cup.
 *         They keep the same order as when they were picked up.
 *     </li>
 *     <li>
 *         The crab selects a new current cup: the cup which is immediately clockwise of the current cup.
 *     </li>
 * </ul>
 *
 * Class finding the multiplication of the labels of two cups that will end up immediately clockwise of cup 1.
 */
public class Solution {

    /**
     * Finds the multiplication of the labels of two cups that will end up immediately clockwise of cup 1 after
     * 10000000 moves.
     *
     * @param cupsString  the string representing cups labeling
     * @return the multiplication of the labels of two cups that will end up immediately clockwise of cup 1
     */
    public long multiplicationOfCupsLabelsWithStars(String cupsString){
        int[] cupsList = cupsList(cupsString);
        playGame(cupsList, cupsString.charAt(0) - '0');
        return (long) cupsList[1] * cupsList[cupsList[1]];
    }

    /**
     * Plays the Crab's game according to the rules.
     *
     * @param cupsList  the array representing cups linked list
     * @param first  the cup to start with
     */
    private void playGame(int[] cupsList, int first){
        int current = first;
        for (int i = 0; i < 10_000_000; i++){
            int cup1 = cupsList[current];
            int cup2 = cupsList[cup1];
            int cup3 = cupsList[cup2];

            int destination = current == 1 ? 1_000_000 : current - 1;
            while (destination == cup1 || destination == cup2 || destination == cup3){
                destination = destination == 1 ? 1_000_000 : destination - 1;
            }

            int next = cupsList[destination];
            cupsList[current] = cupsList[cup3];
            cupsList[cup3] = next;
            cupsList[destination] = cup1;

            current = cupsList[current];
        }
    }

    /**
     * Creates a linked list on array, placing at every index (except 0) the cup coming the next after the number
     * representing this index.
     *
     * @param cupsString  the string representing cups labeling
     * @return the array representing cups linked list
     */
    private int[] cupsList(String cupsString){
        int[] cupsList = new int[1_000_001];
        int prev = cupsString.charAt(0) - '0';
        cupsList[1_000_000] = prev;
        for (int i = 1; i < cupsString.length(); i++){
            cupsList[prev] = cupsString.charAt(i) - '0';
            prev = cupsList[prev];
        }
        for (int i = cupsString.length() + 1; i < cupsList.length; i++){
            cupsList[prev] = i;
            prev = i;
        }
        return cupsList;
    }
}
