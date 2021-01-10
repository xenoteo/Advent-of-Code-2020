package xenoteo.com.github.day8.part2;

import xenoteo.com.github.day8.InputReader;
import xenoteo.com.github.day8.Instructions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader inputReader = new InputReader();
        inputReader.readInputFile(Main.class.getResource(filePath));
        List<Instructions> instructions = inputReader.getInstructions();
        List<Integer> arguments = inputReader.getArguments();
        System.out.println(new Solution().lastValueBeforeTermination(instructions, arguments));
    }
}
