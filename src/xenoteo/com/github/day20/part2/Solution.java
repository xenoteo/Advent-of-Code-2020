package xenoteo.com.github.day20.part2;

import java.util.List;

/**
 * The camera array consists of many cameras; rather than produce a single square image, they produce many smaller
 * square image tiles that need to be reassembled back into a single image. Each camera in the camera array returns
 * a single monochrome image tile with a random unique ID number. The tiles arrived in a random order. Worse yet,
 * the camera array appears to be malfunctioning: each image tile has been rotated and flipped to a random orientation.
 *
 * The borders of each tile are not part of the actual image; starting by removing them.
 * Then removing the gaps to form the actual image.
 *
 * Searching for sea monsters! A sea monster will look like this:
 * <pre>
 *                       #
 *     #    ##    ##    ###
 *      #  #  #  #  #  #
 * </pre>
 *
 * When looking for this pattern in the image, the spaces can be anything; only the # need to match.
 * Also, the image might need to be rotated or flipped before it's oriented correctly to find sea monsters.
 *
 * Class determining how rough the waters are in the sea monsters' habitat by counting the number of #
 * that are not part of a sea monster.
 */
public class Solution {

    /**
     * Determines how rough the waters are in the sea monsters' habitat by counting the number of #
     * that are not part of a sea monster.
     *
     * @param tiles  a list of tiles
     * @return the number of # that are not part of a sea monster
     */
    public int waterRough(List<Tile> tiles){
        assignNeighboursToTiles(tiles);
        return -1;
    }

    /**
     * Assigns neighbours to all tiles.
     *
     * @param tiles  a list of tiles
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

}
