package xenoteo.com.github.day20.part2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The camera array consists of many cameras; rather than produce a single square image, they produce many smaller
 * square image tiles that need to be reassembled back into a single image. Each camera in the camera array returns
 * a single monochrome image tile with a random unique ID number. The tiles arrived in a random order. Worse yet,
 * the camera array appears to be malfunctioning: each image tile has been rotated and flipped to a random orientation.
 *
 * Class reassembles the original image by orienting the tiles so they fit together and by removing their borders
 * (as the borders of each tile are not part of the actual image); then removes the samples of the sea monster:
 * <pre>
 *                       #
 *     #    ##    ##    ###
 *      #  #  #  #  #  #
 * </pre>
 * When looking for this pattern in the image, the spaces can be anything; only the # need to match.
 * Also, the image might need to be rotated or flipped before it's oriented correctly to find sea monsters.
 *
 * Class determining how rough the waters are in the sea monsters' habitat by counting the number of # that are not
 * part of a sea monster.
 */
public class Solution {
    /**
     * The coordinates of the sea monster sample.
     */
    private static final Point[] SEA_MONSTER_COORDINATES = new Point[] {
            new Point(18, 0),
            new Point(0, 1),
            new Point(5, 1),
            new Point(6, 1),
            new Point(11, 1),
            new Point(12, 1),
            new Point(17, 1),
            new Point(18, 1),
            new Point(19, 1),
            new Point(1, 2),
            new Point(4, 2),
            new Point(7, 2),
            new Point(10, 2),
            new Point(13, 2),
            new Point(16, 2)
    };

    /**
     * Counts the water roughness, that is how many # (true pixels) are not part of a sea monster.
     *
     * @param tiles  the list of tiles
     * @return the water roughness
     */
    public int waterRoughness(List<Tile> tiles){
        boolean[][] image = completeImage(tiles);
        image = setupImageCorrectOrientation(image);
        removeAllSeaMonsters(image);
        return imageRoughness(image);
    }

    /**
     * Finds the complete image combining all the tiles without their borders together.
     *
     * @param tiles  the list of tiles
     * @return the complete image
     */
    private boolean[][] completeImage(List<Tile> tiles){
        Map<Integer, Set<Tile>> tilesMap = tilesMap(tiles);
        int length = (int) Math.sqrt(tilesMap.size());
        Map<Point, Tile> arrangement =
                findArrangement(length, tilesMap, new HashMap<>(), new HashSet<>(tilesMap.keySet()), new Point(0, 0));
        int tileLength = tiles.get(0).data.length;
        var imageSize = length * (tileLength - 2);
        boolean[][] image = new boolean[imageSize][imageSize];
        int y = 0;
        for (int row = 0; row < length; row++) {
            for (int tileHeight = 1; tileHeight < tileLength - 1; tileHeight++) {
                int x = 0;
                for (int col = 0; col < length; col++) {
                    boolean[][] tile = arrangement.get(new Point(col, row)).data;
                    for (int tileWidth = 1; tileWidth < tileLength - 1; tileWidth++) {
                        image[y][x] = tile[tileHeight][tileWidth];
                        x++;
                    }
                }
                y++;
            }
        }
        return image;
    }

    /**
     * Makes a map of tiles from tiles' IDs to its all possible variations (rotated and flipped).
     *
     * @param tiles  the list of tiles
     * @return a map of tiles from tiles' IDs to its all possible variations
     */
    private Map<Integer, Set<Tile>> tilesMap(List<Tile> tiles) {
        Map<Integer, Set<Tile>> tilesMap = new HashMap<>();
        for (Tile tile : tiles) {
            tilesMap.put(tile.id, Set.of(
                    tile,
                    tile.rotate(),
                    tile.rotate().rotate(),
                    tile.rotate().rotate().rotate(),
                    tile.flip(),
                    tile.flip().rotate(),
                    tile.flip().rotate().rotate(),
                    tile.flip().rotate().rotate().rotate()));
        }
        return tilesMap;
    }

    /**
     * Fins the right arrangement of tiles.
     *
     * @param length  the number of tiles contained by one image's side
     * @param allTiles  the map of all the tiles
     * @param selectedTiles  the map of selected tiles
     * @param tilesRemaining  the set of IDs of remaining tiles
     * @param point  the point
     * @return  the map from point to tile representing right arrangement
     */
    private Map<Point, Tile> findArrangement(int length,
                                             Map<Integer, Set<Tile>> allTiles,
                                             Map<Point, Tile> selectedTiles,
                                             Set<Integer> tilesRemaining,
                                             Point point) {
        if (tilesRemaining.isEmpty()) {
            return selectedTiles;
        }

        Set<Tile> possibleTiles = allTiles.entrySet().stream()
                .filter(e -> tilesRemaining.contains(e.getKey()))
                .flatMap(e -> e.getValue().stream())
                .filter(tile -> tile.fits(
                        selectedTiles.get(point.move(0, -1)), // above
                        selectedTiles.get(point.move(0, 1)),  // below
                        selectedTiles.get(point.move(-1, 0)), // left
                        selectedTiles.get(point.move(1, 0)))) // right
                .collect(Collectors.toSet());
        if (possibleTiles.isEmpty()) {
            return Map.of();
        }
        for (Tile tile : possibleTiles) {
            selectedTiles.put(point, tile);
            tilesRemaining.remove(tile.id);
            Map<Point, Tile> result =
                    findArrangement(length, allTiles, selectedTiles, tilesRemaining, nextPoint(length, point));
            if (!result.isEmpty()) {
                return result;
            } else {
                selectedTiles.remove(point, tile);
                tilesRemaining.add(tile.id);
            }
        }

        return Map.of();
    }

    /**
     * Finds the next point (the next place where a tile need to be located) of the image.
     *
     * @param length  the number of tiles contained by one image's side
     * @param point  the point
     * @return the next point
     */
    private Point nextPoint(int length, Point point) {
        if (point.y + 1 == length)
            return new Point(point.x + 1, 0);
        else
            return new Point(point.x, point.y + 1);
    }

    /**
     * Sets the image to its right orientation, that is to the orientation where the sea monsters can be found.
     *
     * @param image  the image
     * @return the right orientation of the image
     */
    private boolean[][] setupImageCorrectOrientation(boolean[][] image){
        int rotations = 0;
        while (!imageContainsSeaMonsters(image) && rotations < 4){
            image = Grid.rotateGrid(image);
            rotations++;
        }
        if (imageContainsSeaMonsters(image))
            return image;

        image = Grid.flipGrid(image);
        rotations = 0;
        while (!imageContainsSeaMonsters(image) && rotations < 4){
            image = Grid.rotateGrid(image);
            rotations++;
        }
        return image;
    }

    /**
     * Checks whether the image contains sea monsters.
     *
     * @param image  the image
     * @return whether the image contains sea monsters
     */
    private boolean imageContainsSeaMonsters(boolean[][] image){
        boolean contains = false;
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[0].length; x++) {
                contains |= pointStartsSeaMonster(image, y, x);
            }
        }
        return contains;
    }

    /**
     * Checks whether the point starts a sea monster (from the lower left corner).
     * @param image  the image
     * @param y  y
     * @param x  x
     * @return whether the point starts a sea monster
     */
    private boolean pointStartsSeaMonster(boolean[][] image, int y, int x){
        if (y + 3 > image.length || x + 20 > image[0].length) {
            return false; // out of bounds
        }
        boolean matches = true;
        for (Point point : SEA_MONSTER_COORDINATES) {
            boolean value = image[y + point.y][x + point.x];
            matches &= value;
        }

        return matches;
    }

    /**
     * Removes all the sea monsters from the image.
     *
     * @param image  the image
     */
    private void removeAllSeaMonsters(boolean[][] image) {
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[0].length; x++) {
                if (pointStartsSeaMonster(image, y, x))
                    removeSeaMonster(image, y, x);
            }
        }
    }

    /**
     * Removes one sea monster whose lower left corner is the given point.
     * @param image  the image
     * @param y  y
     * @param x  x
     */
    private void removeSeaMonster(boolean[][] image, int y, int x) {
        for (Point point : SEA_MONSTER_COORDINATES) {
            image[y + point.y][x + point.x] = false;
        }
    }

    /**
     * Counts the image roughness, that is the number of true pixels.
     *
     * @param image  the image
     * @return the image roughness
     */
    private int imageRoughness(boolean[][] image) {
        int count = 0;
        for (boolean[] booleans : image) {
            for (int x = 0; x < image[0].length; x++) {
                if (booleans[x])
                    count++;
            }
        }
        return count;
    }
}
