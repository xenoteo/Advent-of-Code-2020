package xenoteo.com.github.day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 * Reads lines of directions and converts them to the list of lists of directions.
 *
 * Input example:
 * <pre>
 *     sesenwnenenewseeswwswswwnenewsewsw
 *     neeenesenwnwwswnenewnwwsewnenwseswesw
 *     seswneswswsenwwnwse
 *     nwnwneseeswswnenewneswwnewseswneseene
 * </pre>
 *
 * This input would be converted to the following list:
 * <pre>
 *     [[SE, SE, NW, NE, NE, NE, W, SE, E, SW, W, SW, SW, W, NE, NE, W, SE, W, SW],
 *     [NE, E, E, NE, SE, NW, NW, W, SW, NE, NE, W, NW, W, SE, W, NE, NW, SE, SW, E, SW],
 *     [SE, SW, NE, SW, SW, SE, NW, W, NW, SE],
 *     [NW, NW, NE, SE, E, SW, SW, NE, NE, W, NE, SW, W, NE, W, SE, SW, NE, SE, E, NE]]
 * </pre>
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return the list of lists of directions
     */
    public List<List<Direction>> readInputFile(URL path){
        List<List<Direction>> input = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine(), input);
            }
            scanner.close();
            return input;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Processes one line converting it to the list of directions.
     *
     * @param line  the line
     * @param input  the list of lists of directions
     */
    private void processLine(String line, List<List<Direction>> input){
        char[] chars = line.toCharArray();
        int i = 0;
        List<Direction> directions = new LinkedList<>();
        while (i < chars.length){
            if (chars[i] == 'e' || chars[i] == 'w'){
                directions.add(Direction.directionFromString("" + chars[i]));
                i++;
            }
            else {
                directions.add(Direction.directionFromString("" + chars[i] + chars[i + 1]));
                i += 2;
            }
        }
        input.add(directions);
    }
}
