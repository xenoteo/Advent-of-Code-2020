package xenoteo.com.github.day14.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Reading data from input file. Reading all the bitmasks to the list,
 * and all the parts of memory assignments to the list of hashmaps.
 *
 * Input example:
 * "mask = 1110X01101XX1100110X0000X0000X001100
 * mem[45076] = 584
 * mem[54926] = 29718
 * mem[18560] = 3999638
 * mem[4865] = 1007977570
 * mask = 01X10X010100X001111110X1X1XX10110XX1
 * mem[28725] = 172494865
 * mem[60439] = 7496408
 * mem[55184] = 111489".
 */
public class InputReader {
    private List<String> masks;
    private List<HashMap<Integer, Integer>> assignments;

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     */
    public void readInputFile(String filename){
        try {
            masks = new ArrayList<>();
            assignments = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            HashMap<Integer, Integer> lastMap = new HashMap<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("mask")){
                    if(!lastMap.isEmpty()) {
                        assignments.add(lastMap);
                        lastMap = new HashMap<>();
                    }
                    masks.add(line.substring(7));
                }
                else if (line.contains("mem")){
                    lastMap.put(
                            Integer.parseInt(line.substring(4, line.indexOf(']'))),
                            Integer.parseInt(line.substring(line.indexOf('=') + 2))
                    );
                }
            }
            assignments.add(lastMap);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets the list of all the bitmasks.
     * @return list of the bitmasks
     */
    public List<String> getMasks() {
        return masks;
    }

    /**
     * Gets the list of all the parts of memory assignments.
     * @return list of the parts of memory assignments
     */
    public List<HashMap<Integer, Integer>> getAssignments() {
        return assignments;
    }
}
