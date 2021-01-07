package xenoteo.com.github.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Proceeding input file.
 *
 * Input file consist of squared tiles, each of them is preceded by its ID; all the tiles are divided by an empty line.
 *
 * Example of one tile:
 *  Tile 3167:
 *  .##..#...#
 *  ##.#......
 *  .##......#
 *  #.....#..#
 *  ........##
 *  .#.......#
 *  ###.#.....
 *  ###.....##
 *  #..#....#.
 *  ..####..##
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     * @return a map representing tiles (index -> list of lines)
     */
    public List<Tile> readInputFile(String filename){
        try {
            List<Tile> tiles = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            int lastId = -1;
            List<String> lastTileLines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty() && lastId != -1){
                    tiles.add(new Tile(lastId, lastTileLines));
                    lastTileLines = new ArrayList<>();
                }
                else if (line.contains("Tile")){
                    lastId = Integer.parseInt(line.substring(5, line.length() - 1));
                }
                else {
                    lastTileLines.add(line);
                }
            }
            tiles.add(new Tile(lastId, lastTileLines));
            scanner.close();
            return tiles;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
