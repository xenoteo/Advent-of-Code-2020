package xenoteo.com.github.day7.part1;

import xenoteo.com.github.day7.InputReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> rules = new InputReader()
                .readInputFileIntoRuleMap("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day7/input/input.txt");
        System.out.println(new Solution().countColorsContainingColor(rules, "shiny gold"));
    }
}
