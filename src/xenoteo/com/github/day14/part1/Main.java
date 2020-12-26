package xenoteo.com.github.day14.part1;

import xenoteo.com.github.day14.InputReader;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day14/input.txt");
        List<String> masks = reader.getMasks();
        List<HashMap<Integer, Integer>> assignments = reader.getAssignments();
        System.out.println(new Solution().sumOfAllValuesInMemory(masks, assignments));
    }
}
