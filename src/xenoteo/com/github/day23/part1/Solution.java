package xenoteo.com.github.day23.part1;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * The crab is going to mix up some cups, and you have to predict where they'll end up.
 *
 * The cups will be arranged in a circle and labeled clockwise. For example, if the labeling were 32415, there would be
 * five cups in the circle; going clockwise around the circle from the first cup, the cups would be labeled
 * 3, 2, 4, 1, 5, and then back to 3 again.
 *
 * Before the crab starts, it will designate the first cup in the list as the current cup. The crab is then going to
 * do 100 moves.
 *
 * Each move, the crab does the following actions:
 * <ul>
 *     <li>
 *         The crab picks up the three cups that are immediately clockwise of the current cup. They are removed from
 *         the circle; cup spacing is adjusted as necessary to maintain the circle.
 *     </li>
 *     <li>
 *         The crab selects a destination cup: the cup with a label equal to the current cup's label minus one. If this
 *         would select one of the cups that was just picked up, the crab will keep subtracting one until it finds a cup
 *         that wasn't just picked up. If at any point in this process the value goes below the lowest value on any
 *         cup's label, it wraps around to the highest value on any cup's label instead.
 *     </li>
 *     <li>
 *         The crab places the cups it just picked up so that they are immediately clockwise of the destination cup.
 *         They keep the same order as when they were picked up.
 *     </li>
 *     <li>
 *         The crab selects a new current cup: the cup which is immediately clockwise of the current cup.
 *     </li>
 * </ul>
 *
 * Class finding what order the cups will be in after the crab is done. To give an answer, starting after the cup
 * labeled 1 collect the other cups' labels clockwise into a single string with no extra characters; each number except
 * 1 should appear exactly once.
 *
 * Using the labeling, class simulates 100 moves.
 */
public class Solution {

    /**
     * Finds that the labels are on the cups after cup 1 after 100 moves.
     *
     * @param cupsString  the string representing cups labeling
     * @return the labels on the cups after cup 1 after 100 moves
     */
    public String cupsLabelsAfter100Moves(String cupsString){
        LinkedList<Integer> cupsList = stringToLinkedList(cupsString);
        int currentCupIndex = 0;
        for (int i = 0; i < 100; i++){
            int currentCupValue = cupsList.get(currentCupIndex);
            LinkedList<Integer> picked = pick3(cupsList, currentCupIndex);
            int destinationCupIndex = destinationCupIndex(cupsList,  currentCupValue);
            placeCups(cupsList, destinationCupIndex, picked);
            currentCupIndex = (cupsList.indexOf(currentCupValue) + 1) % 9;
        }
        return cupsToFinalString(cupsList);
    }

    /**
     * Converts the string of labels to the linked list of labels.
     *
     * @param cupsString  the string representing cups labeling
     * @return the linked list representing cups labeling
     */
    private LinkedList<Integer> stringToLinkedList(String cupsString){
        return cupsString.chars().map(ch -> ch - '0').boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Picks (removes from the given list) 3 cups starting right after the provided index.
     * Treating the list like a circle.
     *
     * @param cupsList  the linked list representing cups labeling
     * @param currentCupIndex  the index to start picking after
     * @return the list of picked cups
     */
    private LinkedList<Integer> pick3(LinkedList<Integer> cupsList, int currentCupIndex){
        LinkedList<Integer> cupsListCopy = new LinkedList<>(cupsList);
        LinkedList<Integer> picked = new LinkedList<>();
        int i = (currentCupIndex + 1) % 9;
        while (picked.size() != 3){
            int cup = cupsListCopy.get(i);
            picked.add(cup);
            cupsList.remove((Integer) cup);
            i = (i + 1) % 9;
        }
        return picked;
    }

    /**
     * Finds the index of the destination cup in a list of cups without 3 picked elements.
     *
     * @param cupsList  the linked list representing cups labeling
     * @param currentCupValue  the value of the current cup
     * @return the index of the destination cup
     */
    private int destinationCupIndex(LinkedList<Integer> cupsList, int currentCupValue){
        int destinationCupValue = currentCupValue - 1;
        destinationCupValue = destinationCupValue > 0 ? destinationCupValue : 9;
        while (true){
            if (cupsList.contains(destinationCupValue))
                return cupsList.indexOf(destinationCupValue);
            destinationCupValue = destinationCupValue - 1;
            destinationCupValue = destinationCupValue > 0 ? destinationCupValue : 9;
        }
    }

    /**
     * Places picked cups after the given index.
     *
     * @param cupsList  the linked list representing cups labeling
     * @param destinationCupIndex  the index to insert cups after
     * @param picked  the list of picked cups
     */
    private void placeCups(LinkedList<Integer> cupsList, int destinationCupIndex, LinkedList<Integer> picked){
        LinkedList<Integer> tail = cupsList.stream()
                .filter(cup -> cupsList.indexOf(cup) > destinationCupIndex)
                .collect(Collectors.toCollection(LinkedList::new));
        cupsList.removeAll(tail);
        cupsList.addAll(picked);
        cupsList.addAll(tail);
    }

    /**
     * Converts the final list of cups to the string representing cups labeling to the right of the cup with a label 1.
     * @param cupsList   the linked list representing cups labeling
     * @return the string representing cups labeling to the right of the cup with a label 1
     */
    private String cupsToFinalString(LinkedList<Integer> cupsList){
        int splitIndex = cupsList.indexOf(1);
        LinkedList<Integer> resultList = cupsList.stream()
                .filter(cup -> cupsList.indexOf(cup) > splitIndex)
                .collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> tail = cupsList.stream()
                .filter(cup -> cupsList.indexOf(cup) < splitIndex)
                .collect(Collectors.toCollection(LinkedList::new));
        resultList.addAll(tail);
        return resultList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
