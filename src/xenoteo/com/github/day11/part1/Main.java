package xenoteo.com.github.day11.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        char[][] layout = new InputReader().readInputFileTo2DCharArray(Main.class.getResource(filePath));
        System.out.println(new Solution().occupiedSeatsNumber(layout));
    }
}
