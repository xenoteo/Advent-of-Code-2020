package xenoteo.com.github.day3.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        char[][] map = new InputReader().readInputFileTo2DCharArray(Main.class.getResource(filePath));
        System.out.println(new Solution().countTrees(map));
    }
}
