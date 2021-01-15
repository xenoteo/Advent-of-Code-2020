package xenoteo.com.github.day7.part1;

import java.util.*;

/**
 * Given rules specifying the required contents of colored bags,
 * counting how many bag colors can eventually contain at least one shiny gold bag.
 *
 * Rules example:
 * <pre>
 *     light red bags contain 1 bright white bag, 2 muted yellow bags.
 *     dark orange bags contain 3 bright white bags, 4 muted yellow bags.
 *     bright white bags contain 1 shiny gold bag.
 *     muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
 *     shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
 *     dark olive bags contain 3 faded blue bags, 4 dotted black bags.
 *     vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
 *     faded blue bags contain no other bags.
 *     dotted black bags contain no other bags.
 * </pre>
 *
 * In the above rules, the following options would be available:
 * <ul>
 *     <li>A bright white bag, which can hold your shiny gold bag directly.</li>
 *     <li>A muted yellow bag, which can hold your shiny gold bag directly, plus some other bags.</li>
 *     <li>
 *         A dark orange bag, which can hold bright white and muted yellow bags,
 *         either of which could then hold your shiny gold bag.
 *     </li>
 *     <li>
 *         A light red bag, which can hold bright white and muted yellow bags,
 *         either of which could then hold your shiny gold bag.
 *     </li>
 * </ul>
 * So, in this example, the number of bag colors that can eventually contain at least one shiny gold bag is 4.
 */
public class Solution {

    /**
     * Given rule hash map, counts how many bag colors can eventually contain at least one bag of desired color.
     *
     * @param rules the hash map representing rules
     * @param wantedColor  the color to be searched
     * @return how many bag colors can eventually contain at least one bag of desired color.
     */
    public int countColorsContainingColor(Map<String, List<String>> rules, String wantedColor){
        Set<String> allContaining = new HashSet<>();
        LinkedList<String> colorQueue = new LinkedList<>();
        for (Map.Entry<String, List<String>> pair : rules.entrySet()){
            if (pair.getValue().contains(wantedColor)) {
                colorQueue.add(pair.getKey());
            }
        }
        while (!colorQueue.isEmpty()){
            String color = colorQueue.poll();
            allContaining.add(color);
            for (Map.Entry<String, List<String>> pair : rules.entrySet()){
                if (pair.getValue().contains(color)) {
                    colorQueue.add(pair.getKey());
                }
            }
        }
        return allContaining.size();
    }
}
