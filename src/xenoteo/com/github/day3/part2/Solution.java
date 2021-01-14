package xenoteo.com.github.day3.part2;

import java.util.List;

/**
 * There is a map of the open squares (.) and trees (#). These aren't the only trees, though;
 * the same pattern repeats to the right many times.
 * Starting in the top-left corner need to reach the bottom (below the bottom-most row on your map)
 * following slopes:
 *  - right 1, down 1
 *  - right 3, down 1
 *  - right 5, down 1
 *  - right 7, down 1
 *  - right 1, down 2
 *
 * Class counting how many trees can be encountered starting at the top-left corner of the map and following given slopes,
 * and then multiplying founded results together.
 */
public class Solution {

    /**
     * Counts how many trees can be encountered starting at the top-left corner of the map
     * and following given slopes.
     *
     * Iterates over a map sample using modulo operation.
     *
     * Complexity is O(H), where H is number of rows in a map.
     *
     * @param map  to traverse
     * @return number of trees on the way
     */
    public int countTrees(char[][] map, int rightStep, int downStep){
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < map.length){
            if (map[i][j] == '#')
                count++;
            i += downStep;
            j = (j + rightStep) % map[0].length;
        }
        return count;
    }

    /**
     * Given a list of slopes (one slope is a list of 2 elements, where the first represents rightStep and
     * the second represents downStep), counts trees on all the ways and multiplies founded numbers together.
     *
     * @param map  to analyse
     * @param slopes  to iterate over
     * @return number of trees encountered on each of the listed slopes
     */
    public long multiplySlopes(char[][] map, List<List<Integer>> slopes){
        long multiplication = 1;
        for (List<Integer> slope : slopes){
            multiplication *= countTrees(map, slope.get(0), slope.get(1));
        }
        return multiplication;
    }
}
