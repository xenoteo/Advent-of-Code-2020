package xenoteo.com.github.day24.part1;

import xenoteo.com.github.day24.Direction;
import xenoteo.com.github.day24.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<List<Direction>> directionsList = new InputReader().readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution().countBlackTiles(directionsList));
    }
}
