package xenoteo.com.github.day20.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * Class proceeding input file.
 *
 * Input file consist of squared tiles, each of them is preceded by its ID; all the tiles are divided by an empty line.
 *
 * Example of one tile:
 * <pre>
 *     Tile 3167:
 *     .##..#...#
 *     ##.#......
 *     .##......#
 *     #.....#..#
 *     ........##
 *     .#.......#
 *     ###.#.....
 *     ###.....##
 *     #..#....#.
 *     ..####..##
 * </pre>
 *
 * Class parsing the input file to the list of tile objects.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return the list of tiles
     */
    public List<Tile> readInputFile(URL path){
        try {
            List<Tile> tiles = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            int lastId = -1;
            List<String> lastTileLines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty() && lastId != -1){
                    tiles.add(new Tile(lastId, parseStringsToBoolean2D(lastTileLines)));
                    lastTileLines = new ArrayList<>();
                }
                else if (line.contains("Tile")){
                    lastId = Integer.parseInt(line.substring(5, line.length() - 1));
                }
                else {
                    lastTileLines.add(line);
                }
            }
            tiles.add(new Tile(lastId, parseStringsToBoolean2D(lastTileLines)));
            scanner.close();
            return tiles;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Parses the list of strings to the 2D boolean array.
     *
     * '#' char is parsed to the true pixel, and ' ' char is parsed to the false pixel.
     *
     * @param lines  the list of lines
     * @return 2D boolean array
     */
    private boolean[][] parseStringsToBoolean2D(List<String> lines){
        int width = lines.size();
        boolean[][] data = new boolean[width][width];
        for (int i = 0; i < width; i++){
            char[] line = lines.get(i).toCharArray();
            for (int j = 0; j < width; j++){
                if (line[j] == '#')
                    data[i][j] = true;
            }
        }
        return data;
    }
}
