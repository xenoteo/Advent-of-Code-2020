package xenoteo.com.github.day7.part2;

import java.util.*;

/**
 * Given rules specifying the required contents of colored bags,
 * counting how many individual bags are required inside a single shiny gold bag.
 *
 * Rules example:
 *  "shiny gold bags contain 2 dark red bags.
 *  dark red bags contain 2 dark orange bags.
 *  dark orange bags contain 2 dark yellow bags.
 *  dark yellow bags contain 2 dark green bags.
 *  dark green bags contain 2 dark blue bags.
 *  dark blue bags contain 2 dark violet bags.
 *  dark violet bags contain no other bags."
 * In this example, a single shiny gold bag must contain 126 other bags.
 */
public class Solution {

    /**
     * Counting how many individual bags are required inside a single bag of desired color.
     * @param rules hash map representing rules
     * @param wantedColor color to be searched
     * @return how many individual bags are required inside a single bag of desired color
     */
    public int countBagsContainedByColor(Map<String, HashMap<String, Integer>> rules,
                                         String wantedColor){
        int count = 0;
        for (Map.Entry<String, Integer> pair : rules.get(wantedColor).entrySet()){
            count += pair.getValue() * (countBagsContainedByColor(rules, pair.getKey()) + 1);
        }
        return count;
    }
}