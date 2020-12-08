package xenoteo.com.github.day1.part2;

import java.util.Arrays;

/**
 * Finding the three entries that sum to x and then multiply those three numbers together.
 */
public class Solution {

    /**
     * Sorting an array and using three pointers. The first one is fixed (in the range [0, size - 2]),
     * the next two move until three numbers will sum to x.
     * Complexity is O(N^2).
     * @param nums an input array
     * @param x a desired sum
     * @return multiplication of three numbers from an array that sum to x
     */
    public int multiplyRightTrinity(int[] nums, int x){
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++){
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right){
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == x)
                    return nums[left] * nums[mid] * nums[right];
                else if (sum < 2020)
                    mid++;
                else
                    right--;
            }
        }
        return 0;
    }
}
