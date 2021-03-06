package xenoteo.com.github;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to integer array
     */
    public int[] readInputFileToIntArray(URL path){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return input.stream().mapToInt(Integer::intValue).toArray();    // converting list to array
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to long array
     */
    public long[] readInputFileToLongArray(URL path){
        try {
            List<Long> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(Long.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return input.stream().mapToLong(Long::longValue).toArray(); // converting list to array
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to string list
     */
    public List<String> readInputFileToStringList(URL path){
        try {
            List<String> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
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
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to 2D char array
     */
    public char[][] readInputFileTo2DCharArray(URL path){
        return stringListTo2DCharArray(readInputFileToStringList(path));
    }

    /**
     * Converts a list of strings to a 2D char array.
     *
     * @param list  to convert
     * @return 2D char array
     */
    private char[][] stringListTo2DCharArray(List<String> list){
        char[][] arr = new char[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++){
            String line = list.get(i);
            for (int j = 0; j < line.length(); j++){
                arr[i][j] = line.charAt(j);
            }
        }
        return arr;
    }
}
