package xenoteo.com.github.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 *
 * Input example:
 * <pre>
 *     acc +3
 *     acc +25
 *     acc +11
 *     nop +56
 *     jmp +110
 *     jmp +479
 * </pre>
 */
public class InputReader {
    private List<Instructions> instructions;
    private List<Integer> arguments;

    /**
     * Reads data from the input file with provided filename and
     * writes instructions to a list of instructions and arguments to a list of arguments.
     *
     * @param path  the path of the file
     */
    public void readInputFile(URL path) {
        instructions = new ArrayList<>();
        arguments = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String op = line.substring(0, 3);
                String argument = line.substring(4);
                instructions.add(Instructions.instructionFromString(op));
                arguments.add(Integer.valueOf(argument));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets a list of instructions.
     *
     * @return the instruction list
     */
    public List<Instructions> getInstructions() {
        return instructions;
    }

    /**
     * Gets a list of arguments.
     *
     * @return the argument list
     */
    public List<Integer> getArguments() {
        return arguments;
    }
}