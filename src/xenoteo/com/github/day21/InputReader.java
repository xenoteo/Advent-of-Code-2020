package xenoteo.com.github.day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file.
 *
 * Reads the list of ingredients in unknown language and the list of allergens in English from each line to the lists of arrays.
 * The array of ingredients at index i corresponds to the array of allergens at index i.
 *
 * Input line example:
 * <pre>
 *     mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
 * </pre>
 */
public class InputReader {
    /**
     * The list of ingredients arrays in unknown language.
     * The array of ingredients at index i corresponds to the array of allergens at index i.
     */
    private List<String[]> ingredients;

    /**
     * The list of allergens arrays in English.
     * The array of ingredients at index i corresponds to the array of allergens at index i.
     */
    private List<String[]> allergens;

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     */
    public void readInputFile(URL path){
        ingredients = new ArrayList<>();
        allergens = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Processes one line containing ingredients and their allergens and adds new arrays to lists.
     *
     * @param line  the line
     */
    private void processLine(String line){
        String[] parts = line.split("\\(");
        String unknownWords = parts[0];
        String englishWords = parts[1].substring(9, parts[1].length() - 1); // removing the word "contains" and the last paren from the english part
        ingredients.add(unknownWords.split("\\s+"));
        allergens.add(englishWords.split(",\\s+"));
    }

    /**
     * Gets the list of ingredients arrays.
     *
     * @return the list of ingredients arrays
     */
    public List<String[]> getIngredients() {
        return ingredients;
    }

    /**
     * Gets the list of allergens arrays.
     *
     * @return the list of allergens arrays
     */
    public List<String[]> getAllergens() {
        return allergens;
    }
}
