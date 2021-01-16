package xenoteo.com.github.day9.part2;

import java.util.HashMap;
import java.util.Map;

/**
 * XMAS (eXchange-Masking Addition System) starts by transmitting a preamble of 25 numbers. After that,
 * each number should be the sum of any two of the 25 immediately previous numbers. The two numbers will have
 * different values, and there might be more than one such pair.
 *
 * Encryption weakness is a sum of the smallest and largest number in a contiguous set
 * of at least two numbers in a list which sum to the invalid number.
 *
 * Class finding the encryption weakness.
 */
public class Solution {
    /**
     * Right (the last) index of the 25 immediately previous numbers before the first invalid number.
     */
    private int invalidRight;

    /**
     * First invalid number.
     */
    private long invalidNumber;

    /**
     * Left (the first) index of a contiguous set of at least two numbers in the list which sum to the invalid number.
     */
    private int leftOfSet;

    /**
     * Right (the last) index of a contiguous set of at least two numbers in the list which sum to the invalid number.
     */
    private int rightOfSet;

    /**
     * Finds encryption weakness, that is a sum of the smallest and largest number in a contiguous set
     * of at least two numbers in a list which sum to the invalid number.
     *
     * Complexity is O(N).
     *
     * @param arr  an input array
     * @return the encryption weakness
     */
    public long encryptionWeakness(long[] arr){
        setUpFirstInvalidNumber(arr);
        setUpContiguousSet(makeSumMap(arr, invalidRight), invalidNumber);
        return max(arr, leftOfSet, rightOfSet) + min(arr, leftOfSet, rightOfSet);
    }

    /**
     * Sets up the first invalid number
     * (that is number that cannot be made by sum of any two of the 25 immediately previous numbers),
     * as well as sets up the last index of the 25 immediately previous numbers before the first invalid number.
     *
     * Complexity is O(25^2 * N).
     *
     * @param arr  an array of numbers
     */
    private void setUpFirstInvalidNumber(long[] arr){
        int left = 0;
        int right = 24;
        for (int i = 25; i < arr.length; i++){
            if (!isValid(arr, left, right, arr[i])) {
                invalidRight = right;
                invalidNumber = arr[i];
                return;
            }
            else {
                left++;
                right++;
            }
        }
    }

    /**
     * Checks whether provided number is valid,
     * that is whether it can be made by sum of any two of the 25 previous numbers.
     *
     * Complexity is O((right - left)^2).
     *
     * @param arr  an arrays of numbers
     * @param left  an index of the first of 25 numbers
     * @param right  an index if the last of 25 numbers
     * @param num  a number to check
     * @return whether number is valid
     */
    private boolean isValid(long[] arr, int left, int right, long num) {
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                if (arr[i] + arr[j] == num)
                    return true;
            }
        }
        return false;
    }

    /**
     * Creates a map of sums at the certain moment (index) starting from 0 and ending at provided index.
     *
     * @param arr  an array of numbers
     * @param right  an index to stop (inclusive)
     * @return a map of sums at indexes
     */
    private HashMap<Integer, Long> makeSumMap(long[] arr, int right){
        HashMap<Integer, Long> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i <= right; i++){
            sum += arr[i];
            map.put(i, sum);
        }
        return map;
    }

    /**
     * Sets up a contiguous set of at least two numbers in the list which sum to the invalid number.
     *
     * Complexity is O(N).
     *
     * @param map  a map of sums
     * @param invalid  an invalid number
     */
    private void setUpContiguousSet(HashMap<Integer, Long> map, long invalid){
        for (Map.Entry<Integer, Long> pair : map.entrySet()){
            long sum = pair.getValue() + invalid;
            if (map.containsValue(sum)){
                leftOfSet = pair.getKey();
                rightOfSet = getKey(map, sum);
            }
        }
    }

    /**
     * Gets key by value in a hash map.
     *
     * @param map  a map
     * @param value  a value
     * @return the key by value
     */
    private int getKey(HashMap<Integer, Long> map, long value){
        for (Map.Entry<Integer, Long> pair : map.entrySet()){
            if (pair.getValue() == value)
                return pair.getKey();
        }
        return -1;
    }

    /**
     * Finds maximum value in a given range.
     *
     * @param arr  an array of numbers
     * @param left  the first index of a range to analyze
     * @param right  the last index of a range to analyze
     * @return the max value
     */
    private long max(long[] arr, int left, int right){
        long maxNum = arr[left];
        for (int i = left; i <= right; i++){
            maxNum = Math.max(maxNum, arr[i]);
        }
        return maxNum;
    }

    /**
     * Finds minimum value in a given range.
     *
     * @param arr  an array of numbers
     * @param left  the first index of a range to analyze
     * @param right  the last index of a range to analyze
     * @return the min value
     */
    private long min(long[] arr, int left, int right){
        long minNum = arr[left];
        for (int i = left; i <= right; i++){
            minNum = Math.min(minNum, arr[i]);
        }
        return minNum;
    }

}
