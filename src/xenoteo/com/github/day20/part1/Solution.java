package xenoteo.com.github.day20.part1;

import xenoteo.com.github.day20.Tile;

import java.util.*;

/**
 * The camera array consists of many cameras; rather than produce a single square image, they produce many smaller
 * square image tiles that need to be reassembled back into a single image. Each camera in the camera array returns
 * a single monochrome image tile with a random unique ID number. The tiles arrived in a random order. Worse yet,
 * the camera array appears to be malfunctioning: each image tile has been rotated and flipped to a random orientation.
 *
 * The task is to reassemble the original image by orienting the tiles so they fit together.
 */
public class Solution {

    /**
     * Multiplying together the IDs of the four corner tiles.
     * @param tiles a list of tiles
     * @return multiplication of four corner IDs
     */
    public long cornersIdMultiplication(List<Tile> tiles){
        assignNeighboursToTiles(tiles);
        return countCornersMultiplication(tiles);

    }

    /**
     * Assigns neighbours to all tiles.
     * @param tiles a list of tiles
     */
    private void assignNeighboursToTiles(List<Tile> tiles){
        for (int i = 0; i < tiles.size() - 1; i++){
            Tile firstTile = tiles.get(i);
            for (int j = i + 1; j < tiles.size(); j++){
                Tile secondTile = tiles.get(j);
                if (firstTile.matches(secondTile)){
                    firstTile.assignNeighbour(secondTile);
                }
            }
        }
    }

    /**
     * Counts the multiplication of corner tile IDs.
     * @param tiles a list of tiles
     * @return multiplication of four corner IDs
     */
    private long countCornersMultiplication(List<Tile> tiles) {
        return tiles.stream().filter(tile -> tile.getNeighboursNumber() == 2)
                .mapToLong(Tile::getId).reduce(1, (a, b) -> a * b);
    }
}
