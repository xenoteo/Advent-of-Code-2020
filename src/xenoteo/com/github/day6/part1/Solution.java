package xenoteo.com.github.day6.part1;

import java.util.HashSet;
import java.util.List;

/**
 * The form asks a series of 26 yes-or-no questions marked a through z.
 * Identifying the questions for which anyone in a group answers "yes".
 *
 * For each of the people in the group, writing down the questions for which they answer "yes", one per line. For example:
 * <pre>
 *     abcx
 *     abcy
 *     abcz
 * </pre>
 * In this group, there are 6 questions to which anyone answered "yes": a, b, c, x, y, and z.
 * (Duplicate answers to the same question don't count extra; each question counts at most once.)
 */
public class Solution {

    /**
     * Finds a sum of group's counts of questions for which anyone in a group answered "yes".
     *
     * Complexity is O(G * P), where N is a number of groups and P is a number of people in the groups.
     *
     * @param groups  the list of groups, representing list of sequences of questions for which people from the group answered "yes"
     * @return the sum of group's counts of questions for which anyone in a group answered "yes"
     */
    public int sumOfGroupCounts(List<List<String>> groups){
        int generalCount = 0;
        for (List<String> group : groups){
            generalCount += countQuestions(group);
        }
        return generalCount;
    }

    /**
     * Counts the number of questions for which anyone in a group answered "yes".
     *
     * @param group  the list of sequences of questions for which people from the group answered "yes"
     * @return the number of questions for which anyone in a group answered "yes"
     */
    private int countQuestions(List<String> group){
        HashSet<Character> set = new HashSet<>();
        for (String person : group){
            for (char c : person.toCharArray()) {
                set.add(c);
            }
        }
        return set.size();
    }
}