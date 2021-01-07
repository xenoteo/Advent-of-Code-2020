package xenoteo.com.github.day20.part1;

import xenoteo.com.github.day20.InputReader;
import xenoteo.com.github.day20.Tile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tile> tiles = new InputReader()
                .readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day20/input.txt");
        System.out.println(new Solution().cornersIdMultiplication(tiles));
    }
}
