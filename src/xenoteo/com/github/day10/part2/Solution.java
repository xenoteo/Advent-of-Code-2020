package xenoteo.com.github.day10.part2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a list of all of the joltage adapters in a bag.
 * Each of joltage adapters is rated for a specific output joltage. Any given adapter can take an input 1, 2, or 3 jolts
 * lower than its rating and still produce its rated output joltage. In addition, the device has a built-in joltage
 * adapter rated for 3 jolts higher than the highest-rated adapter in the bag.
 *
 * The charging outlet has an effective joltage rating of 0.
 */
public class Solution {

    /**
     * Counts the total number of distinct ways of adapter arrangements.
     * @param arr an input array representing given adapters
     * @return the total number of distinct ways of adapter arrangements
     */
    public long numberOfAdapterArrangements(int[] arr){
        Arrays.sort(arr);
        int[] adapters = expandAdaptersArray(arr);
        return countArrangements(adapters, 0, new HashMap<>());
    }

    /**
     * Adds to the sorted array of adapters two adapters: the first one rated by 0 and
     * the second one rated for 3 jolts higher than the highest-rated adapter in the bag.
     * @param sorted the sorted input array representing given adapters
     * @return expanded array of adapters
     */
    private int[] expandAdaptersArray(int[] sorted){
        int[] adapters = new int[sorted.length + 2];
        for (int i = 0; i < sorted.length; i++){
            adapters[i + 1] = sorted[i];
        }
        adapters[adapters.length - 1] = adapters[adapters.length - 2] + 3;
        return adapters;
    }

    /**
     * Counts number of distinct ways of adapter arrangements for a given index(using dynamic programming).
     * @param arr an array representing all sorted adapters
     * @param i an index to analyze
     * @param map a memorizing map (used for dynamic programming)
     * @return number of distinct ways of adapter arrangements for a given index
     */
    private long countArrangements(int[] arr, int i, HashMap<Integer, Long> map){
        if (i == arr.length - 1) return 1;
        if (map.containsKey(i))
            return map.get(i);

        long arrangements = 0;
        int j = i + 1;
        while (j < arr.length && arr[j] - arr[i] <= 3){
            arrangements += countArrangements(arr, j, map);
            j++;
        }
        map.put(i, arrangements);

        return arrangements;
    }
}