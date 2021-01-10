package xenoteo.com.github.day14.part2;

import xenoteo.com.github.day14.InputReader;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        List<String> masks = reader.getMasks();
        List<LinkedHashMap<Integer, Integer>> assignments = reader.getAssignments();
        System.out.println(new Solution().sumOfAllValuesInMemory(masks, assignments));
    }
}