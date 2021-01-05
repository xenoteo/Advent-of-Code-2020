package xenoteo.com.github.day19.part1;

import xenoteo.com.github.day19.InputReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day19/inputs/input.txt");
        Map<Integer, String> autonomousRules = reader.getAutonomousRules();
        Map<Integer, List<List<Integer>>> dependentRules = reader.getDependentRules();
        List<String> messages = reader.getMessages();
        System.out.println(new Solution().messagesMatchingRule0(autonomousRules, dependentRules, messages));
    }
}
