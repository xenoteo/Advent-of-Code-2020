package xenoteo.com.github.day10.part1;

import java.util.Arrays;

/**
 * Given a list of all of the joltage adapters in a bag.
 * Each of joltage adapters is rated for a specific output joltage. Any given adapter can take an input 1, 2, or 3 jolts
 * lower than its rating and still produce its rated output joltage. In addition, the device has a built-in joltage
 * adapter rated for 3 jolts higher than the highest-rated adapter in the bag.
 *
 * The charging outlet has an effective joltage rating of 0.
 *
 * If using every adapter in the bag at once, what is the distribution of joltage differences between the charging
 * outlet, the adapters, and a device?
 */
public class Solution {

    /**
     * Finds the number of 1-jolt differences multiplied by the number of 3-jolt differences.
     * @param arr an input array representing given adapters
     * @return the number of 1-jolt differences multiplied by the number of 3-jolt differences
     */
    public int multiplicationOf1JoltDiffAnd3JoltDiff(int[] arr){
        int count1Diff = 0;
        int count3Diff = 0;
        Arrays.sort(arr);
        int lastJoltage = 0;
        for (int joltage : arr) {
            int diff = joltage - lastJoltage;
            if (diff == 1)
                count1Diff++;
            else if (diff == 3)
                count3Diff++;
            lastJoltage = joltage;
        }
        count3Diff++;
        return count1Diff * count3Diff;
    }
}