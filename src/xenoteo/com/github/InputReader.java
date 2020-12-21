package xenoteo.com.github;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     * @return data converted to integer array
     */
    public int[] readInputFileToIntArray(String filename){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                input.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return this.listToIntArray(input);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     * @return data converted to long array
     */
    public long[] readInputFileToLongArray(String filename){
        try {
            List<Long> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                input.add(Long.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return listToLongArray(input);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     * @param filename the name of the file to read data from
     * @return data converted to string list
     */
    public List<String> readInputFileToStringList(String filename){
        try {
            List<String> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
            return input;
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
    private int[] listToIntArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * Converts a list to a long array.
     * @param list to convert
     * @return long array
     */
    private long[] listToLongArray(List<Long> list){
        long[] arr = new long[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
