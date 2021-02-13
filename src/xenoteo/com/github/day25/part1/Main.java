package xenoteo.com.github.day25.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] keys = new InputReader().readInputFileToIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().encryptionKey(keys[0], keys[1]));
    }
}
