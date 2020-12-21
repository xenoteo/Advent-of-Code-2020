package xenoteo.com.github.day9.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        long[] arr = new InputReader()
                .readInputFileToLongArray("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day9/input.txt");
        System.out.println(new Solution().encryptionWeakness(arr));
    }
}
