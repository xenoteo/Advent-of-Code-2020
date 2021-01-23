package xenoteo.com.github.day11.part2;

/**
 * The seat layout fits neatly on a grid. Each position is either floor (.), an empty seat (L), or an occupied seat (#).
 * Running seats rearrangements according to required rules. All decisions are based on the number of occupied seats
 * adjacent to a given seat (one of the eight positions immediately up, down, left, right, or diagonal from the seat).
 * The following rules are applied to every seat simultaneously:
 * <ul>
 *     <li>If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.</li>
 *     <li>If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.</li>
 *     <li>Otherwise, the seat's state does not change.</li>
 * </ul>
 * Floor (.) never changes; seats don't move, and nobody sits on the floor.
 *
 * At some point the chaos stabilizes and further applications of these rules cause no seats to change state.
 *
 * Class simulating the seating area by applying the seating rules repeatedly until no seats change state.
 */
public class Solution {
    private static final char OCCUPIED = '#';
    private static final char EMPTY = 'L';
    private static final char FLOOR = '.';
    private char[][] layout;

    /**
     * Counts how many seats end up occupied at the point
     * when further applications of the rules cause no seats to change state.
     *
     * @param layout  the layout
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
     *
     * @return the number of changes launched during a round
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
                    int neighbours = countVisibleOccupiedSeats(layout, i, j);
                    if (neighbours >= 5){
                        copy[i][j] = EMPTY;
                        changes++;
                    }
                    else {
                        copy[i][j] = OCCUPIED;
                    }
                }
                else if (layout[i][j] == EMPTY){
                    int neighbours = countVisibleOccupiedSeats(layout, i, j);
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
     *
     * @param layout  the layout
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
     *
     * @param layout  the layout to copy
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
     * Counts the number of visible occupied seats in each of eight directions for the given position.
     *
     * @param layout  the layout
     * @param i  a row index
     * @param j  a column index
     * @return the number of visible occupied seats
     */
    private int countVisibleOccupiedSeats(char[][] layout, int i, int j){
        int count = 0;

        int k = i - 1;
        boolean seen = false;
        while (k >= 0 && !seen){
            if (layout[k][j] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][j] == EMPTY){
                seen = true;
            }
            k--;
        }

        k = i + 1;
        seen = false;
        while (k < layout.length && !seen){
            if (layout[k][j] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][j] == EMPTY){
                seen = true;
            }
            k++;
        }

        int l = j - 1;
        seen = false;
        while (l >= 0 && !seen){
            if (layout[i][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[i][l] == EMPTY){
                seen = true;
            }
            l--;
        }

        l = j + 1;
        seen = false;
        while (l < layout[0].length && !seen){
            if (layout[i][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[i][l] == EMPTY){
                seen = true;
            }
            l++;
        }

        k = i - 1;
        l = j - 1;
        seen = false;
        while (k >= 0 && l >= 0 && !seen){
            if (layout[k][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][l] == EMPTY){
                seen = true;
            }
            l--;
            k--;
        }

        k = i - 1;
        l = j + 1;
        seen = false;
        while (k >= 0 && l < layout[0].length && !seen){
            if (layout[k][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][l] == EMPTY){
                seen = true;
            }
            l++;
            k--;
        }

        k = i + 1;
        l = j - 1;
        seen = false;
        while (k < layout.length && l >= 0 && !seen){
            if (layout[k][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][l] == EMPTY){
                seen = true;
            }
            l--;
            k++;
        }

        k = i + 1;
        l = j + 1;
        seen = false;
        while (k < layout.length && l < layout[0].length && !seen){
            if (layout[k][l] == OCCUPIED){
                seen = true;
                count++;
            }
            else if (layout[k][l] == EMPTY){
                seen = true;
            }
            l++;
            k++;
        }

        return count;
    }
}
