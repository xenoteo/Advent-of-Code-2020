package xenoteo.com.github.day3.part1;

import xenoteo.com.github.day3.InputReader;

public class Main {
    public static void main(String[] args) {
        char[][] map = new InputReader()
                .readMap("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day3/input.txt");
        System.out.println(new Solution().countTrees(map));
    }
}
