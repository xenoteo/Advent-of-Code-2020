package xenoteo.com.github.day16.part1;

import java.util.List;

/**
 * The rules for ticket fields specify a list of fields that exist somewhere on the ticket and the valid ranges of
 * values for each field.
 *
 * Each ticket is represented by a single line of comma-separated values. The values are the numbers on the ticket in
 * the order they appear; every ticket has the same format.
 *
 * Determining which tickets are completely invalid; these are tickets that contain values which aren't valid for any
 * field.
 *
 * Class adding together all of the invalid values produces the ticket scanning error rate and
 * finding ticket scanning error rate.
 */
public class Solution {

    /**
     * Finds ticket scanning error rate.
     *
     * @param rules  the rules for ticket fields
     * @param nearbyTickets  the list of tickets
     * @return ticket scanning error rate
     */
    public int findTicketScanningErrorRate(List<List<Integer>> rules, List<List<Integer>> nearbyTickets){
        int errorRate = 0;
        for (List<Integer> ticket : nearbyTickets){
            for (int value : ticket){
                if (!validValue(rules, value))
                    errorRate += value;
            }
        }
        return errorRate;
    }

    /**
     * Checks whether exists at least one rule which can be satisfied by provided value.
     *
     * @param rules  the list of rules
     * @param value  the value to analyze
     * @return whether exists at least one rule which can be satisfied by provided value
     */
    private boolean validValue(List<List<Integer>> rules, int value){
        boolean atLeastOnePasses = false;
        for (List<Integer> rule : rules){
            if ((value >= rule.get(0) && value <= rule.get(1)) || (value >= rule.get(2) && value <= rule.get(3))) {
                atLeastOnePasses = true;
                break;
            }
        }
        return atLeastOnePasses;
    }
}
