package xenoteo.com.github.day7.part2;

import xenoteo.com.github.day7.InputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        Map<String, HashMap<String, Integer>> rules = new InputReader()
                .readInputFileIntoRuleMapWithNumbers(Main.class.getResource(filePath));
        System.out.println(new Solution().countBagsContainedByColor(rules, "shiny gold"));
    }
}