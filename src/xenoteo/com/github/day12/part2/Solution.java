package xenoteo.com.github.day12.part2;

import xenoteo.com.github.day12.Actions;

import java.util.List;

/**
 * The navigation instructions consists of a sequence of single-character actions paired with integer input values.
 *     Action N means to move the waypoint north by the given value.
 *     Action S means to move the waypoint south by the given value.
 *     Action E means to move the waypoint east by the given value.
 *     Action W means to move the waypoint west by the given value.
 *     Action L means to rotate the waypoint around the ship left (counter-clockwise) the given number of degrees.
 *     Action R means to rotate the waypoint around the ship right (clockwise) the given number of degrees.
 *     Action F means to move forward to the waypoint a number of times equal to the given value.
 *
 * The waypoint starts 10 units east and 1 unit north relative to the ship.
 * The waypoint is relative to the ship; that is, if the ship moves, the waypoint moves with it.
 *
 * Finding the Manhattan distance (sum of the absolute values of its east/west position and its north/south position)
 * between the final location (when all the actions proceeded) and the ship's starting position.
 */
public class Solution {

    /**
     * Moves a ship according to provided actions and finds the Manhattan distance between the final location
     * and the ship's starting position.
     * @param actions actions to perform on a ship
     * @param values values for the actions
     * @return the Manhattan distance between the final location and the ship's starting position
     */
    public int manhattanDistance(List<Actions> actions, List<Integer> values){
        int shipEast = 0;
        int shipNorth = 0;
        int waypointEast = 10;
        int waypointNorth = 1;
        for (int i = 0; i < actions.size(); i++){
            switch (actions.get(i)){
                case EAST -> waypointEast += values.get(i);
                case WEST -> waypointEast -= values.get(i);
                case NORTH -> waypointNorth += values.get(i);
                case SOUTH -> waypointNorth -= values.get(i);
                case FORWARD -> {
                    int val = values.get(i);
                    int oldShipEast = shipEast;
                    int oldShipNorth = shipNorth;
                    shipEast += (waypointEast - shipEast) * val;
                    shipNorth += (waypointNorth - shipNorth) * val;
                    waypointEast = shipEast + (waypointEast - oldShipEast);
                    waypointNorth = shipNorth + (waypointNorth - oldShipNorth);
                }
                case LEFT -> {
                    int degrees = values.get(i);
                    while (degrees > 0){
                        int oldWaypointNorth = waypointNorth;
                        int oldWaypointEast = waypointEast;
                        waypointNorth = shipNorth + oldWaypointEast - shipEast;
                        waypointEast = shipEast - oldWaypointNorth + shipNorth;
                        degrees -= 90;
                    }
                }
                case RIGHT -> {
                    int degrees = values.get(i);
                    while (degrees > 0){
                        int oldWaypointNorth = waypointNorth;
                        int oldWaypointEast = waypointEast;
                        waypointNorth = shipNorth - oldWaypointEast + shipEast;
                        waypointEast = shipEast + oldWaypointNorth - shipNorth;
                        degrees -= 90;
                    }
                }
            }
        }
        return Math.abs(shipEast) + Math.abs(shipNorth);
    }
}
