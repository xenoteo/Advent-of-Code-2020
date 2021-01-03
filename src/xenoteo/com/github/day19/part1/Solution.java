package xenoteo.com.github.day19.part1;

import java.util.*;

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
        List<String> possibleFormats = possibleFormatsOfRule(0, autonomousRules, dependentRules, new HashMap<>());
        return countAppropriateMessages(messages, possibleFormats);
    }

    /**
     * Counts messages matching at least one of the provided formats.
     * @param messages the list of messages
     * @param possibleFormats the list of possible formats
     * @return the number of messages matching at least one of the provided formats
     */
    private int countAppropriateMessages(List<String> messages, List<String> possibleFormats){
        int count = 0;
        for (String message : messages){
            if (possibleFormats.contains(message))
                count++;
        }
        return count;
    }

    /**
     * Finds a list of possible formats for a given rule.
     * @param ruleIndex the index of a rule
     * @param autonomousRules the map of autonomous rules
     * @param dependentRules the map of dependent rules
     * @param memoryMap a memory map used for dynamic programming
     * @return a list of possible formats for a given rule
     */
    private List<String> possibleFormatsOfRule(int ruleIndex,
                                               Map<Integer, String> autonomousRules,
                                               Map<Integer, List<List<Integer>>> dependentRules,
                                               Map<Integer, List<String>> memoryMap){
        if (memoryMap.containsKey(ruleIndex))
            return memoryMap.get(ruleIndex);

        if (autonomousRules.containsKey(ruleIndex)) {
            memoryMap.put(ruleIndex, List.of(autonomousRules.get(ruleIndex)));
            return memoryMap.get(ruleIndex);
        }

        List<String> possibleFormats = new ArrayList<>();   // list to return

        for (List<Integer> dependency : dependentRules.get(ruleIndex)){
            List<StringBuilder> formats = List.of(new StringBuilder());    // formats for one dependency
            for (int index : dependency){
                List<String> tailFormats = possibleFormatsOfRule(index, autonomousRules, dependentRules, memoryMap);
                formats = updateFormats(formats, tailFormats);
            }
            formats.forEach(format -> possibleFormats.add(format.toString()));
        }

        memoryMap.put(ruleIndex, possibleFormats);
        return possibleFormats;
    }

    /**
     * Adds every tail format to every head format.
     * @param headFormats the list of head formats
     * @param tailFormats the lift of tail formats
     * @return the list of merged formats
     */
    private List<StringBuilder> updateFormats(List<StringBuilder> headFormats, List<String> tailFormats){
        List<StringBuilder> newFormats = new ArrayList<>();
        for (StringBuilder head : headFormats){
            for (String tail : tailFormats) {
                newFormats.add(new StringBuilder(head).append(tail));
            }
        }
        return newFormats;
    }
}
