package xenoteo.com.github.day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file.
 *
 * Input example:
 * "
 * class: 1-3 or 5-7
 * row: 6-11 or 33-44
 * seat: 13-40 or 45-50
 *
 * your ticket:
 * 7,1,14
 *
 * nearby tickets:
 * 7,3,47
 * 40,4,50
 * 55,2,20
 * 38,6,12
 * "
 */
public class InputReader {
    /**
     * One rule is 4 numbers: starts and ends of two ranges (in the order of occurrences in the line).
     * The list of such rules.
     */
    private List<List<Integer>> rules;

    /**
     * Each ticket is a list of numbers present in the line.
     * The list of such tickets.
     */
    private List<List<Integer>> nearbyTickets;

    /**
     * Reads input file data to lists.
     * @param filename the filename
     */
    public void readInputFile(String filename){
        rules = new ArrayList<>();
        nearbyTickets = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            boolean readingRules = true;
            while (readingRules && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    readingRules = false;
                }
                else {
                    processRule(line);
                }
            }

            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processTicket(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Processes the string representing one rule.
     * @param line the line with rule to process
     */
    private void processRule(String line){
        List<Integer> rule = new ArrayList<>();

        int split1 = line.indexOf(':') + 2;
        String ranges = line.substring(split1);

        int split2 = ranges.indexOf("or");
        String firstRange = ranges.substring(0, split2 - 1);
        String secondRange = ranges.substring(split2 + 3);

        processRange(rule, firstRange);
        processRange(rule, secondRange);
        rules.add(rule);
    }

    /**
     * Processes the string representing one rule's range.
     * @param rule rule's list to update
     * @param range string representing the range
     */
    private void processRange(List<Integer> rule, String range){
        int split = range.indexOf('-');
        String first = range.substring(0, split);
        String last = range.substring(split + 1);
        rule.add(Integer.parseInt(first));
        rule.add(Integer.parseInt(last));
    }

    /**
     * Processes the string representing a ticket.
     * @param line a line representing a ticket.
     */
    private void processTicket(String line){
        String[] numbers = line.split(",");
        List<Integer> ticket = new ArrayList<>();
        for (String number : numbers){
            ticket.add(Integer.parseInt(number));
        }
        nearbyTickets.add(ticket);
    }

    /**
     * Gets the list of rules.
     * @return the list of rules
     */
    public List<List<Integer>> getRules() {
        return rules;
    }

    /**
     * Gets the list of nearby tickets.
     * @return the list of nearby tickets
     */
    public List<List<Integer>> getNearbyTickets() {
        return nearbyTickets;
    }
}
