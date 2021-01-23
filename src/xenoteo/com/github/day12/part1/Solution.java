package xenoteo.com.github.day12.part1;

import xenoteo.com.github.day12.Actions;

import java.util.List;

/**
 * The navigation instructions consists of a sequence of single-character actions paired with integer input values.
 * <ul>
 *     <li>Action N means to move north by the given value.</li>
 *     <li>Action S means to move south by the given value.</li>
 *     <li>Action E means to move east by the given value.</li>
 *     <li>Action W means to move west by the given value.</li>
 *     <li>Action L means to turn left the given number of degrees.</li>
 *     <li>Action R means to turn right the given number of degrees.</li>
 *     <li>Action F means to move forward by the given value in the direction the ship is currently facing.</li>
 * </ul>
 *
 * The ship starts by facing east. Only the L and R actions change the direction the ship is facing.
 *
 * Class finding the Manhattan distance (sum of the absolute values of its east/west position and its north/south position)
 * between the final location (when all the actions proceeded) and the ship's starting position.
 */
public class Solution {

    /**
     * Moves a ship according to provided actions and finds the Manhattan distance between the final location
     * and the ship's starting position.
     *
     * @param actions  the list of actions to perform on a ship
     * @param values  the list of values for the actions
     * @return the Manhattan distance between the final location and the ship's starting position
     */
    public int manhattanDistance(List<Actions> actions, List<Integer> values){
        int direction = 0;
        int east = 0;
        int north = 0;
        for (int i = 0; i < actions.size(); i++){
            switch (actions.get(i)){
                case EAST -> east += values.get(i);
                case WEST -> east -= values.get(i);
                case NORTH -> north += values.get(i);
                case SOUTH -> north -= values.get(i);
                case LEFT -> direction = (direction + values.get(i)) % 360;
                case RIGHT -> direction = (direction + 360 - values.get(i)) % 360;
                case FORWARD -> {
                    if (direction == 0) east += values.get(i);
                    else if (direction == 90) north += values.get(i);
                    else if (direction == 180) east -= values.get(i);
                    else if (direction == 270) north -= values.get(i);
                }
            }
        }
        return Math.abs(east) + Math.abs(north);
    }
}
