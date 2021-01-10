package xenoteo.com.github.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * Proceeding input file, reading bag colors rules
 * and traversing them to a hashmap from color to list of another colors than can be contained by key-color.
 */
public class InputReader {

    /**
     * Reads input file and traverses color rules to a hash map.
     *
     * For example the following input:
     *  "vibrant beige bags contain 2 posh silver bags.
     *  bright bronze bags contain 1 shiny yellow bag, 5 muted green bags, 3 dark gray bags.
     *  bright orange bags contain no other bags."
     * is converted to the following map:
     *  vibrant beige -> [posh silver]
     *  bright bronze -> [shiny yellow, muted green, dark gray]
     *  bright orange -> []
     *
     * @param path the path of the file
     * @return hash map representing bag color rules
     */
    public Map<String, List<String>> readInputFileIntoRuleMap(URL path){
        try {
            Map<String, List<String>> rules = new HashMap<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String rule = scanner.nextLine();
                String[] parts = rule.split(" bags contain ");  // dividing a line into two parts,
                                                                    // where the first part is a key-color,
                                                                    // and the second part is a "dirty" list of colors
                List<String> colors = getColorsFromString(parts[1]);    // "clear" list of colors
                addColorDependencies(rules, parts[0], colors);
            }
            scanner.close();
            return rules;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets list of colors from the second part of one rule string (the part after words " bags contain ").
     * @param line the second part of one rule string
     * @return "clear" list of colors
     */
    private List<String> getColorsFromString(String line){
        List<String> colors = new LinkedList<>();
        String[] dirtyColors = line.split(" bag, | bags, | bag\\.| bags\\.");   // colors with numbers
                                                                                    // at the beginning of the string
        for (String dirtyColor : dirtyColors) {
            if (!dirtyColor.startsWith("no other")) {
                colors.add(dirtyColor.substring(dirtyColor.indexOf(' ') + 1));
            }
        }
        return colors;
    }

    /**
     * Updates color dependencies.
     * If key-color is already present in a map, new colors are added, otherwise new entry is created.
     * @param rules map of rules
     * @param keyColor key color
     * @param colors colors to be added to a key color
     */
    private void addColorDependencies(Map<String, List<String>> rules, String keyColor, List<String> colors){
        if (rules.containsKey(keyColor))
            rules.get(keyColor).addAll(colors);
        else
            rules.put(keyColor, colors);
    }

    /**
     * Reads input file and traverses color rules to a hash map (with number of bags).
     *
     * For example the following input:
     *  "vibrant beige bags contain 2 posh silver bags.
     *  bright bronze bags contain 1 shiny yellow bag, 5 muted green bags, 3 dark gray bags.
     *  bright orange bags contain no other bags."
     * is converted to the following map:
     *  vibrant beige -> [posh silver -> 2]
     *  bright bronze -> [shiny yellow -> 1, muted green -> 5, dark gray -> 3]
     *  bright orange -> []
     *
     * @param path the path of the file
     * @return hash map representing bag color rules
     */
    public Map<String, HashMap<String, Integer>> readInputFileIntoRuleMapWithNumbers(URL path){
        try {
            Map<String, HashMap<String, Integer>> rules = new HashMap<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String rule = scanner.nextLine();
                String[] parts = rule.split(" bags contain ");  // dividing a line into two parts,
                                                                    // where the first part is a key-color,
                                                                    // and the second part is a "dirty" list of colors
                HashMap<String, Integer> colorsMap = getColorsWithNumbersFromString(parts[1]);
                addColorDependencies(rules, parts[0], colorsMap);
            }
            scanner.close();
            return rules;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets map of colors (with number of occurrences) from the second part of one rule string
     * (the part after words " bags contain ").
     * @param line the second part of one rule string
     * @return map of colors with number of their occurrences
     */
    private HashMap<String, Integer> getColorsWithNumbersFromString(String line){
        HashMap<String, Integer> colors = new HashMap<>();
        String[] dirtyColors = line.split(" bag, | bags, | bag\\.| bags\\.");   // colors with numbers
                                                                                    // at the beginning of the string
        for (String dirtyColor : dirtyColors) {
            if (!dirtyColor.startsWith("no other")) {
                int split = dirtyColor.indexOf(' ');
                colors.put(dirtyColor.substring(split + 1), Integer.parseInt(dirtyColor.substring(0, split)));
            }
        }
        return colors;
    }

    /**
     * Updates color dependencies.
     * If key-color is already present in a map, new colors are added, otherwise new entry is created.
     * @param rules map of rules
     * @param keyColor key color
     * @param colors colors to be added to a key color
     */
    private void addColorDependencies(Map<String, HashMap<String, Integer>> rules,
                                      String keyColor,
                                      HashMap<String, Integer> colors){
        if (rules.containsKey(keyColor))
            rules.get(keyColor).putAll(colors);
        else
            rules.put(keyColor, colors);
    }
}