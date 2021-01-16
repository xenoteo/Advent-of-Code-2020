package xenoteo.com.github.day9.part1;

/**
 * XMAS (eXchange-Masking Addition System) starts by transmitting a preamble of 25 numbers. After that,
 * each number should be the sum of any two of the 25 immediately previous numbers. The two numbers will have
 * different values, and there might be more than one such pair.
 *
 * Class finding the first invalid number,
 * that is number that cannot be made by sum of any two of the 25 immediately previous numbers.
 */
public class Solution {

    /**
     * Returns the first invalid number,
     * that is number that cannot be made by sum of any two of the 25 immediately previous numbers.
     *
     * @param arr  an array of numbers
     * @return the first invalid number
     */
    public long firstInvalidNumber(long[] arr){
        int left = 0;
        int right = 24;
        for (int i = 25; i < arr.length; i++){
            if (!isValid(arr, left, right, arr[i]))
                return arr[i];
            else {
                left++;
                right++;
            }
        }
        return -1;
    }

    /**
     * Checks whether provided number is valid,
     * that is whether it can be made by sum of any two of the 25 previous numbers.
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
}
