package xenoteo.com.github.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file and converting it to a 2d character array.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     * @param path the path of the file
     * @return data converted to 2d character array
     */
    public char[][] readMap(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
            return stringListToCharArray(lines);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts list of strings to a 2d character array.
     * @param lines list of strings to convert
     * @return 2d character array
     */
    private char[][] stringListToCharArray(List<String> lines){
        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                map[i][j] = lines.get(i).charAt(j);
            }
        }
        return map;
    }
}
