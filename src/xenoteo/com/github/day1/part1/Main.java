package xenoteo.com.github.day1.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] nums = new InputReader().readInputFileToIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().multiplyRightPair(nums, 2020));
    }
}
