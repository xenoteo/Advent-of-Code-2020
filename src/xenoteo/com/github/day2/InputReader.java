package xenoteo.com.github.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file containing passwords with their password policies and converting them to lists.
 */
public class InputReader {
    /**
     * The list of the starting indexes.
     */
    private final List<Integer> lowests;
    /**
     * The list of the ending indexes.
     */
    private final List<Integer> highests;
    /**
     * The list of policy characters.
     */
    private final List<Character> letters;
    /**
     * The list of passwords.
     */
    private final List<String> passwords;

    public InputReader(){
        lowests = new ArrayList<>();
        highests = new ArrayList<>();
        letters = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    /**
     * Reads input file data.
     * @param path the path of the file
     */
    public void readInputFile(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String[] range = scanner.next().split("-");
                lowests.add(Integer.valueOf(range[0]));
                highests.add(Integer.valueOf(range[1]));
                letters.add(scanner.next().charAt(0));
                passwords.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets the list of the starting indexes.
     * @return the list of the starting indexe
     */
    public List<Integer> getLowests() {
        return lowests;
    }

    /**
     * Gets the list of the ending indexes.
     * @return the list of the ending indexes
     */
    public List<Integer> getHighests() {
        return highests;
    }

    /**
     * Gets the list of policy characters.
     * @return the list of policy characters.
     */
    public List<Character> getLetters() {
        return letters;
    }

    /**
     * Gets the list of passwords.
     * @return the list of passwords.
     */
    public List<String> getPasswords() {
        return passwords;
    }
}
