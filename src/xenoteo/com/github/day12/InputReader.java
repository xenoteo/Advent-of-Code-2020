package xenoteo.com.github.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file.
 *
 * Input example:
 * "F10
 * N3
 * F7
 * R90
 * F11".
 */
public class InputReader {
    private List<Actions> actions;
    private List<Integer> values;

    /**
     * Reads data from the input file with provided filename.
     * Writes actions to a list of actions and arguments to a list of values.
     * @param filename the name of the file to read data from
     */
    public void readInputFile(String filename) {
        actions = new ArrayList<>();
        values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String act = line.substring(0, 1);
                String argument = line.substring(1);
                actions.add(Actions.actionFromString(act));
                values.add(Integer.valueOf(argument));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets a list of actions.
     * @return a list of actions
     */
    public List<Actions> getActions() {
        return actions;
    }

    /**
     * Gets a list of values.
     * @return a list of values
     */
    public List<Integer> getValues() {
        return values;
    }
}
