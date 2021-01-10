package xenoteo.com.github.day12.part1;

import xenoteo.com.github.day12.Actions;
import xenoteo.com.github.day12.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        List<Actions> actions = reader.getActions();
        List<Integer> values = reader.getValues();
        System.out.println(new Solution().manhattanDistance(actions, values));
    }
}
