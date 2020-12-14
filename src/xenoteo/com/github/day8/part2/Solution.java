package xenoteo.com.github.day8.part2;

import xenoteo.com.github.day8.Instructions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The boot code is represented as a text file with one instruction per line of text.
 * Each instruction consists of an operation (acc, jmp, or nop) and an argument (a signed number like +4 or -20).
 *  acc increases or decreases a single global value called the accumulator by the value given in the argument.
 *  jmp jumps to a new instruction relative to itself.
 *  nop stands for No OPeration - it does nothing. The instruction immediately below it is executed next.
 *
 * Program contains infinite loop.
 * The program is supposed to terminate by attempting to execute an instruction immediately
 * after the last instruction in the file. By changing exactly one jmp or nop, the boot code can be repaired.
 *
 * Fixing a program and finding what the value of the accumulator is after the program terminates.
 */
public class Solution {

    /**
     * Fixing a program and finding what the value of the accumulator is after the program terminates.
     * @param instructions instructions
     * @param arguments arguments
     * @return value of the accumulator is after the program terminates
     */
    public int lastValueBeforeTermination(List<Instructions> instructions, List<Integer> arguments){
        fixProgram(instructions, arguments);
        int op = 0;
        int accumulator = 0;
        while (op < instructions.size()){
            int argument = arguments.get(op);
            switch (instructions.get(op)) {
                case ACC -> {
                    accumulator += argument;
                    op++;
                }
                case JMP -> op += argument;
                default -> op++;
            }
        }
        return accumulator;
    }

    /**
     * Fixes a program trying to change every nop and jmp operation until program does not contain a loop.
     * @param instructions instructions
     * @param arguments arguments
     */
    private void fixProgram(List<Instructions> instructions, List<Integer> arguments){
        int op = 0;
        boolean fixed = false;
        while (!fixed && op < instructions.size()) {
            Instructions instruction = instructions.get(op);
            if (instruction != Instructions.ACC) {
                Instructions fixedOperation = instruction == Instructions.NOP ? Instructions.JMP : Instructions.NOP;
                instructions.set(op, fixedOperation);

                if (!loops(instructions, arguments, op))
                    fixed = true;
                else
                    instructions.set(op, instruction);
            }

            if (instruction == Instructions.JMP)
                op += arguments.get(op);
            else
                op++;
        }
    }

    /**
     * Checks whether program contains a loop.
     * @param instructions instructions
     * @param arguments arguments
     * @param op index of operation to start from
     * @return whether program contains a loop
     */
    private boolean loops(List<Instructions> instructions, List<Integer> arguments, int op){
        Set<Integer> executed = new HashSet<>();
        while (op < instructions.size() && executed.add(op)){
            if (instructions.get(op) == Instructions.JMP)
                op += arguments.get(op);
            else
                op++;
        }
        return op < instructions.size();
    }
}
