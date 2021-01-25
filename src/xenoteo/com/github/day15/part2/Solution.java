package xenoteo.com.github.day15.part2;

import java.util.*;

/**
 * In the game, the players take turns saying numbers. They begin by taking turns reading from a list of starting
 * numbers. Then, each turn consists of considering the most recently spoken number:
 * <ul>
 *     <li>If that was the first time the number has been spoken, the current player says 0.</li>
 *     <li>
 *         Otherwise, the number had been spoken before; the current player announces how many turns apart the number
 *         is from when it was previously spoken.
 *     </li>
 * </ul>
 *
 * Class finding what number will be the Nth number spoken.
 */
public class Solution {

    /**
     * Given starting numbers, finds what number will be the Nth number spoken.
     * Using occurrences map to remember the two last occurrences of numbers.
     * Time complexity is O(N).
     *
     * @param startingNumbers  the list of starting numbers
     * @param n  N
     * @return the number that will be the Nth number spoken
     */
    public int findNthNumber(List<Integer> startingNumbers, int n){
        Map<Integer, List<Integer>> occurrencesMap = makeOccurrencesMapOfStartingNumbers(startingNumbers);
        int count = startingNumbers.size();
        int lastNumber = startingNumbers.get(count - 1);
        while (count < n){
            List<Integer> occurrences = occurrencesMap.getOrDefault(lastNumber, Collections.emptyList());
            lastNumber = (occurrences.size() < 2) ? 0 : (occurrences.get(1) - occurrences.get(0));
            updateOccurrencesMap(occurrencesMap, lastNumber, count);
            count++;
        }
        return lastNumber;
    }

    /**
     * Updates an occurrences map keeping the length of occurrences list not greater than 2,
     * keeping that way the only two last occurrences of a number.
     *
     * @param occurrencesMap  an occurrences map to update
     * @param number  a number to update
     * @param index  a number's the last occurrence
     */
    private void updateOccurrencesMap(Map<Integer, List<Integer>> occurrencesMap, int number, int index){
        if (occurrencesMap.containsKey(number)){
            List<Integer> occurrences = new ArrayList<>(occurrencesMap.get(number));
            if (occurrences.size() == 2)
                occurrences.remove(0);
            occurrences.add(index);
            occurrencesMap.put(number, occurrences);
        }
        else
            occurrencesMap.put(number, List.of(index));
    }

    /**
     * Fills the occurrences map with starting numbers.
     *
     * @param startingNumbers  the list of starting numbers
     * @return an occurrences map with starting numbers
     */
    private Map<Integer, List<Integer>> makeOccurrencesMapOfStartingNumbers(List<Integer> startingNumbers){
        Map<Integer, List<Integer>> occurrencesMap = new HashMap<>();
        for (int i = 0; i < startingNumbers.size(); i++){
            updateOccurrencesMap(occurrencesMap, startingNumbers.get(i), i);
        }
        return occurrencesMap;
    }
}
