package xenoteo.com.github.day20.part2;

import java.util.Arrays;

/**
 * Class representing a tile.
 */
public class Tile {
    /**
     * The tile's ID.
     */
    public final int id;

    /**
     * The tile's pixels.
     */
    final boolean[][] data;

    public Tile(int id, boolean[][] data) {
        this.id = id;
        this.data = data;
    }

    /**
     * Rotates a tile clockwise.
     *
     * @return the rotated tile
     */
    public Tile rotate() {
        return new Tile(id, Grid.rotateGrid(data));
    }

    /**
     * Flips a tile.
     *
     * @return the flipped tile
     */
    public Tile flip() {
        return new Tile(id, Grid.flipGrid(data));
    }

    /**
     * Gets the top side of the tile.
     *
     * @return the top side of the tile
     */
    private boolean[] topSide() {
        return data[0];
    }

    /**
     * Gets the bottom side of the tile.
     *
     * @return the bottom side of the tile
     */
    private boolean[] bottomSide() {
        return data[data.length - 1];
    }

    /**
     * Gets the left side of the tile.
     *
     * @return the left side of the tile
     */
    private boolean[] leftSide() {
        var edge = new boolean[data.length];
        for (var y = 0; y < data.length; y++) {
            edge[y] = data[y][0];
        }
        return edge;
    }

    /**
     * Gets the right side of the tile.
     *
     * @return the right side of the tile
     */
    private boolean[] rightSide() {
        var edge = new boolean[data.length];
        for (var y = 0; y < data.length; y++) {
            edge[y] = data[y][data[0].length - 1];
        }
        return edge;
    }

    /**
     * Checks whether a tile fits within provided tiles.
     *
     * @param above  the above tile
     * @param below  the below tile
     * @param left  the left tile
     * @param right  the right tile
     * @return whether a tile fits within provided tiles
     */
    public boolean fits(Tile above, Tile below, Tile left, Tile right) {
        return (above == null || Arrays.equals(this.topSide(), above.bottomSide()))
                && (below == null || Arrays.equals(this.bottomSide(), below.topSide()))
                && (left == null || Arrays.equals(this.leftSide(), left.rightSide()))
                && (right == null || Arrays.equals(this.rightSide(), right.leftSide()));
    }
}
