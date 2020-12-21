package xenoteo.com.github.day10.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        int[] arr = new InputReader()
                .readInputFileToIntArray("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day10/input.txt");
        System.out.println(new Solution().numberOfAdapterArrangements(arr));
    }
}
