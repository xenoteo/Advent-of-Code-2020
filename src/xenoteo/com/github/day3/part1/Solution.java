package xenoteo.com.github.day3.part1;

/**
 * Having a map of the open squares (.) and trees (#). These aren't the only trees, though;
 * the same pattern repeats to the right many times.
 * Starting in the top-left corner need to reach the bottom (below the bottom-most row on your map)
 * following a slope of right 3, down 1.
 *
 * Counting how many trees can be encountered starting at the top-left corner of the map
 * and following a slope of right 3 and down 1.
 */
public class Solution {

    /**
     * Iterating over a map sample using modulo operation.
     * Complexity is O(H), where H is number of rows in a map.
     * @param map to traverse
     * @return number of trees on the way
     */
    public int countTrees(char[][] map){
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < map.length){
            if (map[i][j] == '#')
                count++;
            i++;
            j = (j + 3) % map[0].length;
        }
        return count;
    }
}
