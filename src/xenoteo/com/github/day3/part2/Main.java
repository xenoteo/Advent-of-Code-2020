package xenoteo.com.github.day3.part2;

import xenoteo.com.github.InputReader;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        char[][] map = new InputReader().readInputFileTo2DCharArray(Main.class.getResource(filePath));
        List<List<Integer>> slopes = getDefaultSlopes();
        System.out.println(new Solution().multiplySlopes(map, slopes));
    }

    /**
     * Generates default slopes according to requirements.
     *
     * @return list of default slopes
     */
    private static List<List<Integer>> getDefaultSlopes(){
        List<List<Integer>> slopes = new LinkedList<>();
        slopes.add(List.of(1, 1));
        slopes.add(List.of(3, 1));
        slopes.add(List.of(5, 1));
        slopes.add(List.of(7, 1));
        slopes.add(List.of(1, 2));
        return slopes;
    }
}