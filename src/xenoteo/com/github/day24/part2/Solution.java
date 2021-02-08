package xenoteo.com.github.day24.part2;

import xenoteo.com.github.day24.Direction;
import xenoteo.com.github.day24.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
 * Every day, the tiles are all flipped according to the following rules:
 * <ul>
 *     <li>Any black tile with zero or more than 2 black tiles immediately adjacent to it is flipped to white.</li>
 *     <li>Any white tile with exactly 2 black tiles immediately adjacent to it is flipped to black.</li>
 * </ul>
 *
 * Here, tiles immediately adjacent means the six tiles directly touching the tile in question.
 *
 * The rules are applied simultaneously to every tile; put another way, it is first determined which tiles need to be
 * flipped, then they are all flipped at the same time.
 *
 * Class counting how many tiles will be black after 100 days.
 */
public class Solution {

    /**
     * Counts how many tiles will be black after 100 days.
     *
     * @param directionsList  the list of lists of tiles
     * @return the number of black tiles after 100 days
     */
    public int countBlackTilesAfter100Days(List<List<Direction>> directionsList){
        Set<Point> blacks = initBlackTiles(directionsList);
        Set<Point> neighbourWhites = neighbourWhites(blacks);
        for (int i = 0; i < 100; i++){
            Set<Point> newBlacks = new HashSet<>();
            for (Point black : blacks){
                int blackNeighbours = countBlackNeighbours(black.neighbours(), blacks);
                if (blackNeighbours == 1 || blackNeighbours == 2)
                    newBlacks.add(black);
            }
            for (Point white : neighbourWhites){
                int blackNeighbours = countBlackNeighbours(white.neighbours(), blacks);
                if (blackNeighbours == 2)
                    newBlacks.add(white);
            }
            blacks = newBlacks;
            neighbourWhites = neighbourWhites(blacks);
        }
        return blacks.size();
    }

    /**
     * Finds the set of initial black tiles.
     *
     * @param directionsList  the list of lists of directions
     * @return the set of initial black tiles
     */
    private Set<Point> initBlackTiles(List<List<Direction>> directionsList){
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
        return blacks;
    }

    /**
     * Finds the set of neighbour white tiles for a set of black tiles.
     * @param blacks  the set of black tiles
     * @return the set of neighbour white tiles
     */
    private Set<Point> neighbourWhites(Set<Point> blacks){
        return blacks.stream()
                .map(Point::neighbours)
                .flatMap(List::stream)
                .filter(point -> !blacks.contains(point))
                .collect(Collectors.toSet());
    }

    /**
     * Counts the number of black neighbours of the given tile.
     *
     * @param neighbours  the list of tile's neighbours
     * @param blacks  the set of black tiles
     * @return the number of black neighbours of the given tile
     */
    private int countBlackNeighbours(List<Point> neighbours, Set<Point> blacks){
        return (int) neighbours.stream()
                .filter(blacks::contains)
                .count();
    }
}
