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
        String possibleFormat = possibleFormatsOfRule(0, autonomousRules, dependentRules, new HashMap<>());
        return countAppropriateMessages(messages, possibleFormat);
    }

    private int countAppropriateMessages(List<String> messages, String possibleFormat){
        Pattern pattern;
        int count = 0;
        for (String message : messages){
            for (int n = 1; n <=  5; n++){
                String format = possibleFormat.replace("n", "" + n);
                pattern = Pattern.compile(format);
                if (pattern.matcher(message).matches()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private String possibleFormatsOfRule(int ruleIndex,
                                         Map<Integer, String> autonomousRules,
                                         Map<Integer, List<List<Integer>>> dependentRules,
                                         Map<Integer, String> memoryMap){
        if (memoryMap.containsKey(ruleIndex))
            return memoryMap.get(ruleIndex);

        if (autonomousRules.containsKey(ruleIndex)) {
            memoryMap.put(ruleIndex, autonomousRules.get(ruleIndex));
            return memoryMap.get(ruleIndex);
        }

        StringBuilder format = new StringBuilder("(");
        for (List<Integer> dependency : dependentRules.get(ruleIndex)){
            boolean recursiveDivided = false;
            for (int i = 0; i < dependency.size(); i++){
                int index = dependency.get(i);
                if (index == ruleIndex){
                    format.insert(0, "(");
                    if (i == dependency.size() - 1){
                        format.append(")+");
                    }
                    else {
                        recursiveDivided = true;
                        format.append("){n}(");
                    }
                }
                else
                    format.append(possibleFormatsOfRule(index, autonomousRules, dependentRules, memoryMap));
            }
            if (recursiveDivided){
                format.append("){n}");
            }
            format.append("|");
        }
        format.deleteCharAt(format.length() - 1);
        format.append(")");

        memoryMap.put(ruleIndex, format.toString());
        return memoryMap.get(ruleIndex);
    }
}
