package xenoteo.com.github.day19.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * The rules for valid messages are numbered and build upon each other. For example:
 *
 *  0: 1 2
 *  1: "a"
 *  2: 1 3 | 3 1
 *  3: "b"
 *
 * Some of the rules have multiple lists of sub-rules separated by a pipe (|). This means that at least one list of
 * sub-rules must match.
 *
 * Some of the rules do contain loops.
 *
 * Determining the number of messages that completely match rule 0.
 */
public class Solution {

    /**
     * Determines the number of messages that completely match rule 0.
     * @param autonomousRules the map of autonomous rules
     * @param dependentRules the map of dependent rules
     * @param messages the list of messages
     * @return the number of messages that completely match rule 0
     */
    public int messagesMatchingRule0(Map<Integer, String> autonomousRules,
                                     Map<Integer, List<List<Integer>>> dependentRules,
                                     List<String> messages){
        String ruleFormat = ruleFormat(0, autonomousRules, dependentRules, new HashMap<>());
        return countAppropriateMessages(messages, ruleFormat);
    }

    /**
     * Counts messages matching provided format.
     * @param messages the list of messages
     * @param regex provided format
     * @return the number of messages matching privided format
     */
    private int countAppropriateMessages(List<String> messages, String regex){
        int count = 0;
        for (String message : messages){
            for (int n = 1; n <=  5; n++){
                String format = regex.replace("n", "" + n);
                Pattern pattern = Pattern.compile(format);
                if (pattern.matcher(message).matches()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Finds regex representing a format of the provided rule.
     * @param ruleIndex a rule's index
     * @param autonomousRules the map of autonomous rules
     * @param dependentRules the map of dependent rules
     * @param memoryMap a memory map used for dynamic programming
     * @return regex representing a format of the provided rule
     */
    private String ruleFormat(int ruleIndex,
                              Map<Integer, String> autonomousRules,
                              Map<Integer, List<List<Integer>>> dependentRules,
                              Map<Integer, String> memoryMap){
        if (memoryMap.containsKey(ruleIndex)){
            return memoryMap.get(ruleIndex);
        }

        // special case
        if (ruleIndex == 8) {
            String specialCase = "(" + ruleFormat(42, autonomousRules, dependentRules, memoryMap) + ")+";
            memoryMap.put(ruleIndex, specialCase);
        }

        // special case
        else if (ruleIndex == 11) {
            String specialCase =
                    "(" + ruleFormat(42, autonomousRules, dependentRules, memoryMap) + "){n}"
                            + "(" + ruleFormat(31, autonomousRules, dependentRules, memoryMap) + "){n}";
            memoryMap.put(ruleIndex, specialCase);
        }

        else if (autonomousRules.containsKey(ruleIndex)) {
            memoryMap.put(ruleIndex, autonomousRules.get(ruleIndex));
        }

        else {
            StringBuilder format = new StringBuilder("(");
            for (List<Integer> dependency : dependentRules.get(ruleIndex)){
                for (int index : dependency){
                    format.append(ruleFormat(index, autonomousRules, dependentRules, memoryMap));
                }
                format.append("|");
            }
            format.setCharAt(format.length() - 1, ')');

            memoryMap.put(ruleIndex, format.toString());
        }

        return memoryMap.get(ruleIndex);
    }
}
