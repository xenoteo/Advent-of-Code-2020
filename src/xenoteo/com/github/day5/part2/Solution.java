package xenoteo.com.github.day5.part2;

import java.util.List;

/**
 * Decoding airplane pass. Instead of zones or groups, the airline uses binary space partitioning to seat people.
 * A seat might be specified like FBFBBFFRLR, where F means "front", B means "back", L means "left", and R means "right".
 *
 * The first 7 characters will either be F or B;
 * these specify exactly one of the 128 rows on the plane (numbered 0 through 127).
 * Each letter tells which half of a region the given seat is in;
 * F means to take the lower half and B means to take the upper half.
 *
 * The last three characters will be either L or R;
 * these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7).
 * L means to keep the lower half, while R means to keep the upper half.
 */
public class Solution {

    /**
     * Finding the only one free pass ID from given passes.
     * Pass ID = row * 8 + column.
     * Wanted pass ID is not at very front or back, that is the seats with IDs +1 and -1 from wanted will be in a list.
     * @param passes passes to analyze
     * @return the highest seat ID
     */
    public int findFreeSeatId(List<String> passes){
        int[] ids = new int[128 * 8];
        for (String pass : passes){
            int id = countRow(pass) * 8 + countColumn(pass);
            ids[id]++;
        }
        for (int id = 1; id < ids.length - 1; id++){
            if (ids[id] == 0 && ids[id - 1] == 1 && ids[id + 1] == 1)
                return id;
        }
        return -1;
    }

    /**
     * Finding the row using given pass.
     * @param pass the pass
     * @return row of the pass
     */
    private int countRow(String pass){
        int lower = 0;
        int upper = 127;
        for (int i = 0; i < 7; i++){
            int mid = upper - (upper - lower) / 2;
            if (pass.charAt(i) == 'F')
                upper = mid - 1;
            else
                lower = mid;
        }
        return lower;
    }

    /**
     * Finding the column using given pass.
     * @param pass the pass
     * @return column of the pass
     */
    private int countColumn(String pass){
        int lower = 0;
        int upper = 7;
        for (int i = 7; i < 10; i++){
            int mid = upper - (upper - lower) / 2;
            if (pass.charAt(i) == 'L')
                upper = mid - 1;
            else
                lower = mid;
        }
        return lower;
    }
}