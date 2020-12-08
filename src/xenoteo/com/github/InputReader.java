package xenoteo.com.github;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file and converting it to an integer array.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     * @return data converted to integer array
     */
    public int[] readInputFile(String filename){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                input.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return listToArray(input);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts a list to an integer array.
     * @param list to convert
     * @return integer array
     */
    private int[] listToArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
