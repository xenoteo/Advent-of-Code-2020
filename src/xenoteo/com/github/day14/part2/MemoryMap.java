package xenoteo.com.github.day14.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * Memory map keeping the order of added key-value pairs.
 */
public class MemoryMap {
    private final List<Integer> positions;
    private final List<Integer> values;

    public MemoryMap() {
        positions = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * Adds the new value to the provided position.
     * @param position the position
     * @param value the value
     */
    public void put(int position, int value){
        positions.add(position);
        values.add(value);
    }

    /**
     * Checks whether the map is empty.
     * @return whether the map is empty
     */
    public boolean isEmpty(){
        return positions.isEmpty();
    }

    /**
     * Returns the size of the map.
     * @return the size of the map
     */
    public int size(){
        return positions.size();
    }

    /**
     * Returns the value located at the provided index.
     * @param i the index
     * @return the value at index
     */
    public int getValueAtIndex(int i){
        return values.get(i);
    }

    /**
     * Returns the position located at the provided index.
     * @param i the index
     * @return the position at index
     */
    public int getPositionAtIndex(int i){
        return positions.get(i);
    }
}
