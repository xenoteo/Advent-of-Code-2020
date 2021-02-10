package xenoteo.com.github.day20.part2;

/**
 * The grid class.
 */
public class Grid {
    /**
     * Rotates the grid clockwise.
     *
     * @param grid  the grid
     * @return the rotated grid
     */
    public static boolean[][] rotateGrid(boolean[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] rotated = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rotated[y][width - x - 1] = grid[x][y];
            }
        }
        return rotated;
    }

    /**
     * Flips the grid.
     *
     * @param grid  the grid
     * @return the flipped grid
     */
    public static boolean[][] flipGrid(boolean[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] flipped = new boolean[height][width];
        for (int y = 0; y < (height / 2); y++) {
            for (int x = 0; x < width; x++) {
                flipped[y][x] = grid[grid.length - y - 1][x];
                flipped[grid.length - y - 1][x] = grid[y][x];
            }
        }
        return flipped;
    }
}
