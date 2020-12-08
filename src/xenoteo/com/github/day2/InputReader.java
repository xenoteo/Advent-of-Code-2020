package xenoteo.com.github.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file containing passwords with their password policies and converting them to lists.
 */
public class InputReader {
    private final List<Integer> lowests;
    private final List<Integer> highests;
    private final List<Character> letters;
    private final List<String> passwords;

    public InputReader(){
        lowests = new ArrayList<>();
        highests = new ArrayList<>();
        letters = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    public void readInputFile(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
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

    public List<Integer> getLowests() {
        return lowests;
    }

    public List<Integer> getHighests() {
        return highests;
    }

    public List<Character> getLetters() {
        return letters;
    }

    public List<String> getPasswords() {
        return passwords;
    }
}
