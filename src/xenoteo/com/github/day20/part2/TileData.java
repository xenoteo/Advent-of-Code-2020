package xenoteo.com.github.day20.part2;

import java.util.Arrays;
import java.util.List;

public class TileData {
    char[][] pixels;
    char[][] sides;     // upper, right, bottom, left
    public final int width;

    public TileData(List<String> lines) {
        width = lines.size();
        setUpPixels(lines);
        setUpSides();
    }

    public TileData(char[][] pixels) {
        width = pixels.length;
        this.pixels = pixels;
        setUpSides();
    }

    private void setUpSides(){
        sides = new char[4][width];
        sides[0] = pixels[0];
        sides[2] = reverse(pixels[width - 1]);

        sides[1] = new char[width];
        sides[3] = new char[width];
        for (int i = 0; i < width; i++){
            sides[1][i] = pixels[i][width - 1];
            sides[3][width - 1 - i] = pixels[i][0];
        }
    }

    private void setUpPixels(List<String> lines){
        pixels = new char[width][width];
        for (int i = 0; i < lines.size(); i++){
            pixels[i] = lines.get(i).toCharArray();
        }
    }

    /**
     * Reverses char array.
     *
     * @param arr  a char array
     * @return reversed char array
     */
    static char[] reverse(char[] arr){
        char[] reversed = new char[arr.length];
        for (int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public TileData rotate(){   // TODO
        return null;
    }

}
