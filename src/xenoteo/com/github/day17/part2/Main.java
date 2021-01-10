package xenoteo.com.github.day17.part2;

import xenoteo.com.github.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        char[][] states = new InputReader().readInputFileTo2DCharArray(Main.class.getResource(filePath));
        System.out.println(new Solution().activeCubesAfter6Cycles(states));
    }
}
