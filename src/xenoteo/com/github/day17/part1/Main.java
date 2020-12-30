package xenoteo.com.github.day17.part1;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        char[][] states = new InputReader()
                .readInputFileTo2DCharArray("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day17/input.txt");
        System.out.println(new Solution().activeCubesAfter6Cycles(states));
    }
}
