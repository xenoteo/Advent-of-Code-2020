package xenoteo.com.github.day7.part2;

import xenoteo.com.github.day7.InputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, HashMap<String, Integer>> rules = new InputReader()
                .readInputFileIntoRuleMapWithNumbers("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day7/input.txt");
        System.out.println(new Solution().countBagsContainedByColor(rules, "shiny gold"));
    }
}