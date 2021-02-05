package xenoteo.com.github.day22;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class proceeding input file.
 *
 * Reads players' cards to linked lists.
 *
 * Input example:
 * <pre>
 *     Player 1:
 *     9
 *     2
 *     6
 *     3
 *     1
 *
 *     Player 2:
 *     5
 *     8
 *     4
 *     7
 *     10
 * </pre>
 */
public class InputReader {
    /**
     * The list of the first player's cards.
     */
    private LinkedList<Integer> player1Cards;

    /**
     * The list of the second player's cards.
     */
    private LinkedList<Integer> player2Cards;

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     */
    public void readInputFile(URL path){
        player1Cards = new LinkedList<>();
        player2Cards = new LinkedList<>();
        try {
            LinkedList<Integer> pack = player1Cards;
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Player 2"))
                    pack = player2Cards;
                else if (!line.contains("Player 1") && !line.isEmpty()){
                    pack.add(Integer.parseInt(line));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets the list of the first player's cards.
     *
     * @return the list of the first player's cards
     */
    public LinkedList<Integer> getPlayer1Cards() {
        return player1Cards;
    }

    /**
     * Gets the list of the second player's cards.
     *
     * @return the list of the second player's cards
     */
    public LinkedList<Integer> getPlayer2Cards() {
        return player2Cards;
    }
}
