package xenoteo.com.github.day20.part2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Tile> tiles = new InputReader().readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution().waterRough(tiles));
    }
}
