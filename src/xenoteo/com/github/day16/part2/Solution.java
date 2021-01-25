package xenoteo.com.github.day16.part2;

import java.util.*;

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
 * Class discarding tickets containing invalid values entirely;
 * using the remaining valid tickets to determine which field is which.
 */
public class Solution {

    /**
     * Determines which field is which and finds a multiplication of 6 departure values.
     *
     * @param rules  the rules for ticket fields
     * @param myTicket  the ticket to analyze
     * @param nearbyTickets  the list of tickets
     * @return ticket scanning error rate
     */
    public long multiplicationOfSixDepartureValues(Map<String, List<Integer>> rules,
                                                  List<Integer> myTicket,
                                                  List<List<Integer>> nearbyTickets){
        discardInvalidTickets(rules, nearbyTickets);
        List<Integer> departureIndexes = findDepartureIndexes(rules, nearbyTickets);
        return multiplicateDepartureValues(myTicket, departureIndexes);
    }

    /**
     * Finds invalid tickets and removes them from the list.
     *
     * @param rules  the rules for ticket fields
     * @param nearbyTickets  the list of tickets
     */
    private void discardInvalidTickets(Map<String, List<Integer>> rules, List<List<Integer>> nearbyTickets){
        List<List<Integer>> ticketsToDelete = new ArrayList<>();
        for (List<Integer> ticket : nearbyTickets){
            for (int value : ticket){
                if (!validValue(rules, value)) {
                    ticketsToDelete.add(ticket);
                    break;
                }
            }
        }
        for (List<Integer> ticket : ticketsToDelete){
            nearbyTickets.remove(ticket);
        }
    }

    /**
     * Checks whether exists at least one rule which can be satisfied by provided value.
     *
     * @param rules  the rules
     * @param value  the value to analyze
     * @return whether exists at least one rule which can be satisfied by provided value
     */
    private boolean validValue(Map<String, List<Integer>> rules, int value){
        boolean atLeastOnePasses = false;
        for (Map.Entry<String, List<Integer>> pair : rules.entrySet()){
            List<Integer> rule = pair.getValue();
            if ((value >= rule.get(0) && value <= rule.get(1)) || (value >= rule.get(2) && value <= rule.get(3))) {
                atLeastOnePasses = true;
                break;
            }
        }
        return atLeastOnePasses;
    }

    /**
     * Determines which field is which and finds 6 indexes of departure values.
     *
     * @param rules  the rules for ticket fields
     * @param nearbyTickets  the list of tickets
     * @return 6 indexes of departure values
     */
    private List<Integer> findDepartureIndexes(Map<String, List<Integer>> rules, List<List<Integer>> nearbyTickets){
        String[] ruleIndexes = findRuleIndexes(rules, nearbyTickets);
        List<Integer> departureIndexes = new ArrayList<>();
        for (int i = 0; i < ruleIndexes.length; i++){
            if (ruleIndexes[i].contains("departure"))
                departureIndexes.add(i);
        }
        return departureIndexes;
    }

    /**
     * Determines which field is which.
     *
     * @param rules  the rules for ticket fields
     * @param nearbyTickets  the list of tickets
     * @return an array with ticket fields in the right order
     */
    private String[] findRuleIndexes(Map<String, List<Integer>> rules, List<List<Integer>> nearbyTickets){
        String[] ruleIndexes = new String[rules.size()];
        Map<String, List<Integer>> rulesPossibleIndexes = fillRulesPossibleIndexesMap(rules, nearbyTickets);
        int setFieldsCounter = 0;
        while (setFieldsCounter < ruleIndexes.length){
            for (Map.Entry<String, List<Integer>> pair : rulesPossibleIndexes.entrySet()){
                List<Integer> indexes = pair.getValue();
                if (indexes.size() == 1){
                    int index = indexes.get(0);
                    ruleIndexes[index] = pair.getKey();
                    removeIndexFromRulesPossibleIndexes(rulesPossibleIndexes, index);
                    setFieldsCounter++;
                }
            }
        }
        return ruleIndexes;
    }

    /**
     * Fills the map of possible ticket fields indexes.
     *
     * @param rules  the rules for ticket fields
     * @param nearbyTickets  the list of tickets
     * @return filled map of possible ticket fields indexes
     */
    private Map<String, List<Integer>> fillRulesPossibleIndexesMap(Map<String, List<Integer>> rules,
                                                                   List<List<Integer>> nearbyTickets){
        Map<String, List<Integer>> rulesPossibleIndexes = new HashMap<>();
        int ticketLength = nearbyTickets.get(0).size();
        for (Map.Entry<String, List<Integer>> pair : rules.entrySet()){
            List<Integer> possibleIndexes = new ArrayList<>();
            List<Integer> rule = pair.getValue();
            for (int i = 0; i < ticketLength; i++){
                boolean rightIndex = true;
                for (List<Integer> ticket : nearbyTickets){
                    int value = ticket.get(i);
                    if (value < rule.get(0) || (value > rule.get(1) && value < rule.get(2)) || value > rule.get(3)){
                        rightIndex = false;
                        break;
                    }
                }
                if (rightIndex){
                    possibleIndexes.add(i);
                }
            }
            rulesPossibleIndexes.put(pair.getKey(), possibleIndexes);
        }
        return rulesPossibleIndexes;
    }

    /**
     * Removes an index from rules possible indexes map.
     *
     * @param rulesPossibleIndexes  the rules possible indexes map
     * @param i  an index to remove
     */
    private void removeIndexFromRulesPossibleIndexes(Map<String, List<Integer>> rulesPossibleIndexes, int i){
        for (Map.Entry<String, List<Integer>> pair : rulesPossibleIndexes.entrySet()){
            List<Integer> rule = pair.getValue();
            if (rule.contains(i))
                rule.remove((Integer) i);
        }
    }

    /**
     * Multiplies 6 departure values.
     *
     * @param myTicket  a ticket values
     * @param departureIndexes  6 indexes of departure values
     * @return a multiplication of 6 departure values
     */
    private long multiplicateDepartureValues(List<Integer> myTicket, List<Integer> departureIndexes){
        long multiplication = 1;
        for (int i : departureIndexes){
            multiplication *= myTicket.get(i);
        }
        return multiplication;
    }
}
