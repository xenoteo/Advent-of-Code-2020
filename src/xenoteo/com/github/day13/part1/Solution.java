package xenoteo.com.github.day13.part1;

import java.util.List;

/**
 * Each bus has an ID number that also indicates how often the bus leaves for the airport.
 * Bus schedules are defined based on a timestamp that measures the number of minutes since some fixed reference
 * point in the past. At timestamp 0, every bus simultaneously departed from the sea port. After that, each bus travels
 * to the airport, then various other locations, and finally returns to the sea port to repeat its journey forever.
 *
 * The time this loop takes a particular bus is also its ID number: the bus with ID 5 departs from the sea port
 * at timestamps 0, 5, 10, 15, and so on. The bus with ID 11 departs at 0, 11, 22, 33, and so on.
 * If you are there when the bus departs, you can ride that bus to the airport!
 *
 * To save time, the goal is to figure out the earliest bus you can take to the airport.
 *
 * Finding the ID of the earliest bus you can take to the airport multiplied by the number of minutes
 * you'll need to wait for that bus.
 */
public class Solution {

    /**
     * Finds the ID of the earliest bus you can take to the airport multiplied by the number of minutes
     * you'll need to wait for that bus.
     * @param timestamp the earliest timestamp you could depart on a bus
     * @param buses the bus IDs
     * @return the ID of the earliest bus you can take to the airport multiplied by the number of minutes
     * you'll need to wait for that bus
     */
    public int busIdMultipliedByMinutesToWait(int timestamp, List<Integer> buses){
        int minTime = Integer.MAX_VALUE;
        int bestId = -1;
        for (int id : buses){
            int time = timestamp % id == 0 ? timestamp : (timestamp / id + 1) * id;
            if (time < minTime){
                bestId = id;
                minTime = time;
            }
        }
        return bestId * (minTime - timestamp);
    }
}
