package xenoteo.com.github.day20;

import java.util.*;

/**
 * Class representing a tile with its data and neighbours.
 */
public class Tile {
    private final int id;
    private final List<String> lines;
    private char[][] sides;         // upper, right, bottom, left
    private final int width;
    private int neighboursNumber = 0;

    public Tile(int id, List<String> lines) {
        this.id = id;
        this.lines = lines;
        width = lines.size();
        setUpSides();
    }

    public int getId() {
        return id;
    }

    public char[][] getSides() {
        return sides;
    }

    public int getWidth() {
        return width;
    }

    public int getNeighboursNumber(){
        return neighboursNumber;
    }

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * Sets up all the sides based on the list of lines, reading all the sides in the clockwise direction.
     */
    private void setUpSides(){
        sides = new char[4][width];

        sides[0] = lines.get(0).toCharArray();
        sides[2] = reverse(lines.get(width - 1).toCharArray());

        sides[1] = new char[width];
        sides[3] = new char[width];
        for (int i = 0; i < width; i++){
            sides[1][i] = lines.get(i).charAt(width - 1);
            sides[3][width - 1 - i] = lines.get(i).charAt(0);
        }
    }

    /**
     * Reverses char array.
     * @param arr a char array
     * @return reversed char array
     */
    private char[] reverse(char[] arr){
        char[] reversed = new char[arr.length];
        for (int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    /**
     * Checks whether provided tile cans be a neighbour.
     * @param tile a tile
     * @return whether provided tile matches
     */
    public boolean matches(Tile tile){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (Arrays.equals(sides[i], tile.sides[j])
                        || Arrays.equals(sides[i], reverse(tile.sides[j])))
                    return true;
            }
        }
        return false;
    }

    /**
     * Assigns neighbour to the tile.
     * @param tile a tile-future neighbour
     */
    public void assignNeighbour(Tile tile){
        neighboursNumber++;
        tile.neighboursNumber++;
    }
}
