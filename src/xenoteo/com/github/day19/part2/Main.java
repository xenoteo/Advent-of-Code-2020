package xenoteo.com.github.day19.part2;

import xenoteo.com.github.day19.InputReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        Map<Integer, String> autonomousRules = reader.getAutonomousRules();
        Map<Integer, List<List<Integer>>> dependentRules = reader.getDependentRules();
        List<String> messages = reader.getMessages();
        System.out.println(new Solution().messagesMatchingRule0(autonomousRules, dependentRules, messages));
    }
}