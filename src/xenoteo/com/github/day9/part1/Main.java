package xenoteo.com.github.day9.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        long[] arr = new InputReader()
                .readInputFileToLongArray(Main.class.getResource(filePath));
        System.out.println(new Solution().firstInvalidNumber(arr));
    }
}
