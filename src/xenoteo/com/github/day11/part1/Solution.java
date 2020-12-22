package xenoteo.com.github.day11.part1;

/**
 * The seat layout fits neatly on a grid. Each position is either floor (.), an empty seat (L), or an occupied seat (#).
 * Running seats rearrangements according to required rules. All decisions are based on the number of occupied seats
 * adjacent to a given seat (one of the eight positions immediately up, down, left, right, or diagonal from the seat).
 * The following rules are applied to every seat simultaneously:
 *  - If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
 *  - If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
 *  - Otherwise, the seat's state does not change.
 * Floor (.) never changes; seats don't move, and nobody sits on the floor.
 *
 * At some point the chaos stabilizes and further applications of these rules cause no seats to change state.
 * Simulating the seating area by applying the seating rules repeatedly until no seats change state.
 */
public class Solution {
    private static final char OCCUPIED = '#';
    private static final char EMPTY = 'L';
    private static final char FLOOR = '.';
    private char[][] layout;

    /**
     * Counts how many seats end up occupied at the point
     * when further applications of the rules cause no seats to change state.
     * @param layout the layout
     * @return how many seats end up occupied
     */
    public int occupiedSeatsNumber(char[][] layout){
        this.layout = layout;
        int changes;
        do {
            changes = runOneRearrangementRound();
        } while (changes > 0);
        return countAllOccupied(this.layout);
    }

    /**
     * Runs one rearrangements round according to required rules.
     * @return number of changes launched during a round
     */
    private int runOneRearrangementRound(){
        int changes = 0;
        char[][] copy = copyLayout(layout);
        for (int i = 0; i < layout.length; i++){
            for (int j = 0; j < layout[0].length; j++){
                if (layout[i][j] == FLOOR){
                    copy[i][j] = FLOOR;
                }
                else if (layout[i][j] == OCCUPIED){
                    int neighbours = countOccupiedAdjacentSeats(layout, i, j);
                    if (neighbours >= 4){
                        copy[i][j] = EMPTY;
                        changes++;
                    }
                    else {
                        copy[i][j] = OCCUPIED;
                    }
                }
                else if (layout[i][j] == EMPTY){
                    int neighbours = countOccupiedAdjacentSeats(layout, i, j);
                    if (neighbours == 0){
                        copy[i][j] = OCCUPIED;
                        changes++;
                    }
                    else {
                        copy[i][j] = EMPTY;
                    }
                }
            }
        }
        layout = copy;
        return changes;
    }

    /**
     * Counts all the occupied seats in the layout.
     * @param layout the layout
     * @return the number of occupied seats
     */
    private int countAllOccupied(char[][] layout){
        int count = 0;
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                if (layout[i][j] == OCCUPIED)
                    count++;
            }
        }
        return count;
    }

    /**
     * Creates a copy of the layout.
     * @param layout the layout to copy
     * @return a copy of the layout
     */
    private char[][] copyLayout(char[][] layout){
        char[][] copy = new char[layout.length][layout[0].length];
        for (int i = 0; i < layout.length; i++){
            System.arraycopy(layout[i], 0, copy[i], 0, layout[0].length);
        }
        return copy;
    }

    /**
     * Counts the number of occupied adjacent seats for the given position.
     * @param layout the layout
     * @param i a row index
     * @param j a column index
     * @return the number of occupied adjacent seats
     */
    private int countOccupiedAdjacentSeats(char[][] layout, int i, int j){
        int maxI = layout.length - 1;
        int maxJ = layout[0].length - 1;
        int count = 0;
        if (i == 0 && j == 0){
            if (layout[0][1] == OCCUPIED)
                count++;
            if (layout[1][1] == OCCUPIED)
                count++;
            if (layout[1][0] == OCCUPIED)
                count++;
        }
        else if (i == 0 && j == maxJ){
            if (layout[0][maxJ - 1] == OCCUPIED)
                count++;
            if (layout[1][maxJ - 1] == OCCUPIED)
                count++;
            if (layout[1][maxJ] == OCCUPIED)
                count++;
        }
        else if (i == maxI && j == 0){
            if (layout[maxI - 1][0] == OCCUPIED)
                count++;
            if (layout[maxI - 1][1] == OCCUPIED)
                count++;
            if (layout[maxI][1] == OCCUPIED)
                count++;
        }
        else if (i == maxI && j == maxJ){
            if (layout[maxI][maxJ - 1] == OCCUPIED)
                count++;
            if (layout[maxI - 1][maxJ - 1] == OCCUPIED)
                count++;
            if (layout[maxI - 1][maxJ] == OCCUPIED)
                count++;
        }
        else if (i == 0){
            if (layout[i][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j] == OCCUPIED)
                count++;
            if (layout[i + 1][j + 1] == OCCUPIED)
                count++;
            if (layout[i][j + 1] == OCCUPIED)
                count++;
        }
        else if (i == maxI){
            if (layout[i][j - 1] == OCCUPIED)
                count++;
            if (layout[i - 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i - 1][j] == OCCUPIED)
                count++;
            if (layout[i - 1][j + 1] == OCCUPIED)
                count++;
            if (layout[i][j + 1] == OCCUPIED)
                count++;
        }
        else if (j == 0){
            if (layout[i - 1][j] == OCCUPIED)
                count++;
            if (layout[i - 1][j + 1] == OCCUPIED)
                count++;
            if (layout[i][j + 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j + 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j] == OCCUPIED)
                count++;
        }
        else if (j == maxJ){
            if (layout[i - 1][j] == OCCUPIED)
                count++;
            if (layout[i - 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j] == OCCUPIED)
                count++;
        }
        else {
            if (layout[i][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i + 1][j] == OCCUPIED)
                count++;
            if (layout[i + 1][j + 1] == OCCUPIED)
                count++;
            if (layout[i][j + 1] == OCCUPIED)
                count++;
            if (layout[i - 1][j - 1] == OCCUPIED)
                count++;
            if (layout[i - 1][j] == OCCUPIED)
                count++;
            if (layout[i - 1][j + 1] == OCCUPIED)
                count++;
        }
        return count;
    }
}
