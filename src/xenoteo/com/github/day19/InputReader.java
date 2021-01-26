package xenoteo.com.github.day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 *
 * Input example:
 * <pre>
 *     0: 4 1 5
 *     1: 2 3 | 3 2
 *     2: 4 4 | 5 5
 *     3: 4 5 | 5 4
 *     4: "a"
 *     5: "b"
 *
 *     ababbb
 *     bababa
 *     abbbab
 *     aaabbb
 *     aaaabbb
 * </pre>
 *
 * Class reading dependent and independent rules to different maps, as well as reading all the messages to the list of strings.
 */
public class InputReader {
    private Map<Integer, String> autonomousRules;
    private Map<Integer, List<List<Integer>>> dependentRules;
    private List<String> messages;

    /**
     * Initializes class maps and a list.
     */
    private void setUpMaps(){
        this.autonomousRules = new HashMap<>();
        this.dependentRules = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     */
    public void readInputFile(URL path){
        setUpMaps();
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));

            List<String> ruleLines = new ArrayList<>();
            boolean readingRules = true;
            while (scanner.hasNextLine() && readingRules) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    readingRules = false;
                else
                    ruleLines.add(line);
            }
            proceedRuleLines(ruleLines);

            while (scanner.hasNextLine()) {
                messages.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Sets autonomous and dependent rules based on provided lines containing rules.
     *
     * @param ruleLines  lines containing rules
     */
    private void proceedRuleLines(List<String> ruleLines){
        for (String line : ruleLines){
            String[] parts = line.split(": ");
            int index = Integer.parseInt(parts[0]);
            if (line.contains("\"")){
                proceedAutonomousRule(index, parts[1]);
            }
            else {
                proceedDependentRule(index, parts[1].split(" "));
            }
        }
    }

    /**
     * Proceeds autonomous rule line.
     *
     * @param index  a rule index
     * @param ruleLine  a line containing a rule
     */
    private void proceedAutonomousRule(int index, String ruleLine){
        String rule = ruleLine.substring(1, ruleLine.length() - 1);
        autonomousRules.put(index, rule);
    }

    /**
     * Proceeds dependent rule line.
     *
     * @param index  a rule index
     * @param numbers  an array of numbers strings (or "|" dividing different sub-rules)
     */
    private void proceedDependentRule(int index, String[] numbers){
        List<List<Integer>> dependencies = new ArrayList<>();
        List<Integer> lastSubRule = new ArrayList<>();
        for (String number : numbers){
            if (number.equals("|")){
                dependencies.add(lastSubRule);
                lastSubRule = new ArrayList<>();
            }
            else {
                lastSubRule.add(Integer.parseInt(number));
            }
        }
        dependencies.add(lastSubRule);
        dependentRules.put(index, dependencies);
    }

    /**
     * Gets the map of autonomous rules.
     *
     * @return autonomous rules
     */
    public Map<Integer, String> getAutonomousRules() {
        return autonomousRules;
    }

    /**
     * Gets the map of dependent rules.
     *
     * @return dependent rules
     */
    public Map<Integer, List<List<Integer>>> getDependentRules() {
        return dependentRules;
    }

    /**
     * Gets the list of messages.
     *
     * @return the list of messages
     */
    public List<String> getMessages() {
        return messages;
    }
}

