package xenoteo.com.github.day24.part1;

import xenoteo.com.github.day24.Direction;
import xenoteo.com.github.day24.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The tiles are all hexagonal; they need to be arranged in a hex grid with a very specific color pattern.
 *
 * The tiles are all white on one side and black on the other. They start with the white side facing up. The lobby is
 * large enough to fit whatever pattern might need to appear there.
 *
 * Given a list of the tiles that need to be flipped over. Each line in the list identifies a single tile that needs
 * to be flipped by giving a series of steps starting from a reference tile in the very center of the room. (Every line
 * starts from the same reference tile.)
 *
 * Because the tiles are hexagonal, every tile has six neighbors: east, southeast, southwest, west, northwest, and
 * northeast. These directions are given in your list, respectively, as e, se, sw, w, nw, and ne. A tile is identified
 * by a series of these directions with no delimiters; for example, esenee identifies the tile you land on if you start
 * at the reference tile and then move one tile east, one tile southeast, one tile northeast, and one tile east.
 *
 * Each time a tile is identified, it flips from white to black or from black to white. Tiles might be flipped more
 * than once. For example, a line like esew flips a tile immediately adjacent to the reference tile, and a line like
 * nwwswee flips the reference tile itself.
 *
 * Class counting how many tiles are left with the black side up after all of the instructions have been followed.
 */
public class Solution {

    /**
     * Counts the number of black tiles left after all of the instructions have been followed.
     *
     * @param directionsList  the list of lists of directions
     * @return the number of black tiles left after all of the instructions have been followed
     */
    public int countBlackTiles(List<List<Direction>> directionsList){
        Set<Point> blacks = new HashSet<>();
        for (List<Direction> directions : directionsList){
            Point point = new Point();
            for (Direction direction : directions){
                point.update(direction);
            }
            if (blacks.contains(point))
                blacks.remove(point);
            else
                blacks.add(point);
        }
        return blacks.size();
    }
}
