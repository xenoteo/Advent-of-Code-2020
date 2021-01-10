package xenoteo.com.github.day10.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] arr = new InputReader().readInputFileToIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().numberOfAdapterArrangements(arr));
    }
}
