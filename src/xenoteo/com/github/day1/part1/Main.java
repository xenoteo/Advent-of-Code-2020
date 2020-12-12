package xenoteo.com.github.day1.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        int[] nums = new InputReader()
                .readInputFileToIntArray("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day1/input.txt");
        System.out.println(new Solution().multiplyRightPair(nums, 2020));
    }
}
