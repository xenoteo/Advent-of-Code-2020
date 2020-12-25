package xenoteo.com.github.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file.
 *
 * Input example:
 * "939
 * 7,13,x,x,59,x,31,19".
 *
 * The first line is the earliest timestamp you could depart on a bus.
 * The second line lists the bus IDs that are in service according to the shuttle company.
 */
public class InputReader {

    /**
     * Reads the timestamp from the input file.
     * @param filename the filename
     * @return the timestamp
     */
    public int readTimestampFromInputFile(String filename){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            int timestamp = Integer.parseInt(scanner.nextLine());
            scanner.close();
            return timestamp;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Entries that show x must be out of service, so you decide to ignore them.
     * Reads the buses IDs (without out of service ones) to an integer list from the input file.
     * @param filename the filename
     * @return a list of buses IDs
     */
    public List<Integer> readInputFileToBusIdList(String filename){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            scanner.nextLine();
            String busesLine = scanner.nextLine();
            String[] buses = busesLine.split(",");
            for (String bus : buses){
                if (!bus.equals("x")){
                    input.add(Integer.parseInt(bus));
                }
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
     * Reads the buses IDs to a map (with their position in the list) from the input file.
     * @param filename the filename
     * @return buses IDs with their positions in the list
     */
    public HashMap<Integer, Integer> readInputFileToBusIdMap(String filename){
        try {
            HashMap<Integer, Integer> map = new HashMap<>();
            Scanner scanner = new Scanner(new File(filename));
            scanner.nextLine();
            String busesLine = scanner.nextLine();
            String[] buses = busesLine.split(",");
            for (int i = 0; i < buses.length; i++){
                if (!buses[i].equals("x")){
                    map.put(i, (Integer.parseInt(buses[i])));
                }
            }
            scanner.close();
            return map;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
