package xenoteo.com.github.day8.part1;

import xenoteo.com.github.day8.InputReader;
import xenoteo.com.github.day8.Instructions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        inputReader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day8/input.txt");
        List<Instructions> instructions = inputReader.getInstructions();
        List<Integer> arguments = inputReader.getArguments();
        System.out.println(new Solution().lastValueBeforeLoop(instructions, arguments));
    }
}
