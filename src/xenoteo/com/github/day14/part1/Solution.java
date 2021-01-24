package xenoteo.com.github.day14.part1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The bitmask is always given as a string of 36 bits, written with the most significant bit on the left and
 * the least significant bit on the right. The current bitmask is applied to values immediately before they are
 * written to memory: a 0 or 1 overwrites the corresponding bit in the value, while an X leaves the bit in the
 * value unchanged. The initialization program  can either update the bitmask or write a value to memory.
 *
 * Class finding the sum of all values left in memory after the initialization program completes.
 */
public class Solution {

    /**
     * Finds the sum of all values left in memory after the initialization program completes.
     * Mask i corresponds to the part of assignments at the index i.
     *
     * @param masks  list of all the masks
     * @param assignments  list of the parts of memory assignments
     * @return the sum of all values left in memory after the initialization program completes
     */
    public long sumOfAllValuesInMemory(List<String> masks, List<LinkedHashMap<Integer, Integer>> assignments){
        HashMap<Integer, Long> memory = fillMemory(masks, assignments);
        return findMemorySum(memory);
    }

    /**
     * Fills the memory with provided values to assign changing them using provided masks.
     *
     * @param masks  masks used for numbers encoding
     * @param assignments  values and positions where to assign them
     * @return the filled memory
     */
    private HashMap<Integer, Long> fillMemory(List<String> masks, List<LinkedHashMap<Integer, Integer>> assignments){
        HashMap<Integer, Long> memory = new HashMap<>();
        for (int i = 0; i < masks.size(); i++){
            String mask = masks.get(i);
            int maskLength = mask.length();
            for (Map.Entry<Integer, Integer> pair : assignments.get(i).entrySet()){
                String numberString = Integer.toBinaryString(pair.getValue());
                StringBuilder numberBuilder =
                        new StringBuilder("0".repeat(maskLength - numberString.length()) + numberString);
                for (int k = 0; k < maskLength; k++){
                    if (mask.charAt(k) == '0')
                        numberBuilder.setCharAt(k, '0');
                    else if (mask.charAt(k) == '1')
                        numberBuilder.setCharAt(k, '1');
                }
                memory.put(pair.getKey(), Long.parseLong(numberBuilder.toString(), 2));
            }
        }
        return memory;
    }

    /**
     * Finds the sum of all the values in the memory.
     *
     * @param memory  map of the memory (position -> value)
     * @return the sum of all the values in the memory
     */
    private long findMemorySum(HashMap<Integer, Long> memory){
        long sum = 0;
        for (Map.Entry<Integer, Long> pair : memory.entrySet()){
            sum += pair.getValue();
        }
        return sum;
    }
}
