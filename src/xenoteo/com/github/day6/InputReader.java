package xenoteo.com.github.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename,
     * converts groups divided by a blank line to list of string lists.
     *
     * @param path  the path of the file
     * @return data converted to list of string lists
     */
    public List<List<String>> readInputFile(URL path){
        try {
            List<List<String>> input = new LinkedList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            List<String> lastGroup = new LinkedList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    input.add(lastGroup);
                    lastGroup = new LinkedList<>();
                }
                else {
                    lastGroup.add(line);
                }
            }
            input.add(lastGroup);
            scanner.close();
            return input;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
