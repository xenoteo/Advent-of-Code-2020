package xenoteo.com.github.day13.part2;

import java.util.HashMap;
import java.util.Map;

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
 * Class finding the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions
 * in the list.
 */
public class Solution {

    /**
     * Finds the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions
     * in the list.
     *
     * @param buses  the bus IDs (with their positions)
     * @return the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions
     * in the list
     */
    public long findEarliestTimestamp(HashMap<Integer, Integer> buses){
        long timestamp = 0;
        long step = 1;
        for (Map.Entry<Integer, Integer> pair : buses.entrySet()){
            int position = pair.getKey();
            int busId = pair.getValue();
            while ((timestamp + position) % busId != 0)
                timestamp += step;
            step *= busId;
        }
        return timestamp;
    }
}
