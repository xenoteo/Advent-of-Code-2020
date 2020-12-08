package xenoteo.com.github.day1.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        int[] nums = new InputReader()
                .readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day1/input.txt");
        System.out.println(new Solution().multiplyRightTrinity(nums, 2020));
    }
}
