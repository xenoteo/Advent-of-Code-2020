package xenoteo.com.github.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file.
 *
 * Input example:
 *  "acc +3
 *  acc +25
 *  acc +11
 *  nop +56
 *  jmp +110
 *  jmp +479".
 */
public class InputReader {
    private List<Instructions> instructions;
    private List<Integer> arguments;

    /**
     * Reads data from the input file with provided filename.
     * Writes instructions to a list of instructions and arguments to a list of arguments.
     * @param filename the name of the file to read data from
     */
    public void readInputFile(String filename) {
        instructions = new ArrayList<>();
        arguments = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
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
     * @return instruction list
     */
    public List<Instructions> getInstructions() {
        return instructions;
    }

    /**
     * Gets a list of arguments.
     * @return argument list
     */
    public List<Integer> getArguments() {
        return arguments;
    }
}