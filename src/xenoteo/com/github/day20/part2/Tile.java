package xenoteo.com.github.day20.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a tile with its data and neighbours.
 */
public class Tile {
    public final int id;
    public final int width;
    private TileData[] tileData;
    private final List<Tile> neighbours;

    public Tile(int id, List<String> lines) {
        this.id = id;
        width = lines.size();
        setUpTileData(lines);
        neighbours = new ArrayList<>();
    }

    public String toString() {
        return "" + id;
    }

    private void setUpTileData(List<String> lines){
        tileData= new TileData[4];
        tileData[0] = new TileData(lines);
//        tileData[1] = tileData[0].rotate();
//        tileData[2] = tileData[0].rotate().rotate();
//        tileData[3] = tileData[0].rotate().rotate().rotate();
    }

    public List<Tile> getNeighbours() {
        return neighbours;
    }

    /**
     * Checks whether provided tile cans be a neighbour.
     *
     * @param tile  a tile
     * @return whether provided tile matches
     */
    public boolean matches(Tile tile){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (Arrays.equals(this.tileData[0].sides[i], tile.tileData[0].sides[j])
                        || Arrays.equals(this.tileData[0].sides[i], TileData.reverse(tile.tileData[0].sides[j])))
                    return true;
            }
        }
        return false;
    }

    /**
     * Assigns neighbour to the tile.
     *
     * @param tile a  tile-future neighbour
     */
    public void assignNeighbour(Tile tile){
        this.neighbours.add(tile);
        tile.neighbours.add(this);
    }
}
