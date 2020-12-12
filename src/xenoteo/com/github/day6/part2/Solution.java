package xenoteo.com.github.day6.part2;

import java.util.List;

/**
 * The form asks a series of 26 yes-or-no questions marked a through z.
 * Identifying the questions for which everyone in a group answers "yes".
 *
 * For each of the people in the group, writing down the questions for which they answer "yes", one per line. For example:
 *  abcx
 *  abcy
 *  abcz
 * In this group, there are 3 questions to which everyone answered "yes": a, b and c.
 */
public class Solution {

    /**
     * Finding a sum of group's counts of questions for which everyone in a group answered "yes".
     * Complexity is O(G * P), where N is a number of groups and P is a number of people in the groups.
     * @param groups list of groups, representing list of sequences of questions for which people from the group answered "yes"
     * @return sum of group's counts of questions for which anyone in a group answered "yes"
     */
    public int sumOfGroupCounts(List<List<String>> groups){
        int generalCount = 0;
        for (List<String> group : groups){
            generalCount += countQuestions(group, countFrequencies(group));
        }
        return generalCount;
    }

    /**
     * Counts frequencies of "yes" answers for each of the questions.
     * @param group list of sequences of questions for which people from the group answered "yes"
     * @return frequencies of "yes" answers
     */
    private int[] countFrequencies(List<String> group){
        int[] frequencies = new int[26];
        for (String person : group){
            for (char c : person.toCharArray()) {
                frequencies[c - 'a']++;
            }
        }
        return frequencies;
    }

    /**
     * Counts questions for which everyone in a group answered "yes".
     * @param group list of sequences of questions for which people from the group answered "yes"
     * @param frequencies frequencies of "yes" answers for each of the questions
     * @return count of questions for which anyone in a group answered "yes"
     */
    private int countQuestions(List<String> group, int[] frequencies){
        int groupSize = group.size();
        int count = 0;
        for (int frequency : frequencies){
            if (frequency == groupSize)
                count++;
        }
        return count;
    }
}