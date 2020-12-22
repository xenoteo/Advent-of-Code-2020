package xenoteo.com.github.day11.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        char[][] layout = new InputReader()
                .readInputFileTo2DCharArray("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day11/input.txt");
        System.out.println(new Solution().occupiedSeatsNumber(layout));
    }
}
