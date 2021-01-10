package xenoteo.com.github.day7.part1;

import xenoteo.com.github.day7.InputReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        Map<String, List<String>> rules = new InputReader().readInputFileIntoRuleMap(Main.class.getResource(filePath));
        System.out.println(new Solution().countColorsContainingColor(rules, "shiny gold"));
    }
}
