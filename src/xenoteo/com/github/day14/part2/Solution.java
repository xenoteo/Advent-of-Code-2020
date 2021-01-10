package xenoteo.com.github.day14.part2;

import java.util.*;

/**
 * The bitmask is always given as a string of 36 bits, written with the most significant bit on the left and
 * the least significant bit on the right.
 *
 * A bitmask act as a memory address decoder. Immediately before a value is written to memory, each bit in the bitmask
 * modifies the corresponding bit of the destination memory address in the following way:
 *     If the bitmask bit is 0, the corresponding memory address bit is unchanged.
 *     If the bitmask bit is 1, the corresponding memory address bit is overwritten with 1.
 *     If the bitmask bit is X, the corresponding memory address bit is floating.
 *
 * A floating bit is not connected to anything and instead fluctuates unpredictably. In practice, this means the
 * floating bits will take on all possible values, potentially causing many memory addresses to be written all at once.
 *
 * The initialization program can either update the bitmask or write a value to memory.
 *
 * Finding the sum of all values left in memory after the initialization program completes.
 */
public class Solution {
    private static final int MASK_LENGTH = 36;

    /**
     * Finds the sum of all values left in memory after the initialization program completes.
     * @param masks list of all the masks
     * @param assignments list of the parts of memory assignments
     * Mask i corresponds to the part of assignments at the index i.
     * @return the sum of all values left in memory after the initialization program completes
     */
    public long sumOfAllValuesInMemory(List<String> masks, List<LinkedHashMap<Integer, Integer>> assignments){
        HashMap<String, Integer> memory = fillMemory(masks, assignments);
        return findMemorySum(memory);
    }

    /**
     * Fills the memory with provided values to assign changing their addresses using provided masks.
     * @param masks masks used for address encoding
     * @param assignments values and positions where to assign them
     * @return filled memory
     */
    private HashMap<String, Integer> fillMemory(List<String> masks, List<LinkedHashMap<Integer, Integer>> assignments){
        HashMap<String, Integer> memory = new HashMap<>();
        for (int i = 0; i < masks.size(); i++){
            String mask = masks.get(i);
            for (Map.Entry<Integer, Integer> pair : assignments.get(i).entrySet()){
                StringBuilder addressBuilder = create36bitsBinaryRepresentation(pair.getKey());
                encodeNumberUsingMask(addressBuilder, mask);
                Set<String> addresses = createAllPossibleAddresses(addressBuilder);
                putValueToAddresses(memory, addresses, pair.getValue());
            }
        }
        return memory;
    }

    /**
     * Creates a StringBuilder representing provided number in 36 bits.
     * @param number the number
     * @return a StringBuilder representing provided number in 36 bits
     */
    private StringBuilder create36bitsBinaryRepresentation(int number){
        String binaryString = Integer.toBinaryString(number);
        return new StringBuilder("0".repeat(MASK_LENGTH - binaryString.length()) + binaryString);
    }

    /**
     * Encodes provided number using provided mask.
     * @param numberBuilder the binary number represented by StringBuilder
     * @param mask the binary mask represented by String
     */
    private void encodeNumberUsingMask(StringBuilder numberBuilder, String mask){
        for (int k = 0; k < MASK_LENGTH; k++){
            char maskChar = mask.charAt(k);
            if (maskChar != '0'){
                numberBuilder.setCharAt(k, maskChar);
            }
        }
    }

    /**
     * Creates all possible addresses using an address with floating bits.
     * @param addressBuilder an address with floating bits.
     * @return all possible addresses
     */
    private Set<String> createAllPossibleAddresses(StringBuilder addressBuilder){
        Set<String> addresses = new HashSet<>();
        fillAddresses(addresses, addressBuilder, 0);
        return addresses;
    }

    /**
     * Puts a given value to given addresses of memory.
     * @param memory the memory
     * @param addresses addresses
     * @param value the value
     */
    private void putValueToAddresses(HashMap<String, Integer> memory, Set<String> addresses, int value){
        for (String address : addresses){
            memory.put(address, value);
        }
    }

    /**
     * Fills the set of all possible addresses using an address with floating bits.
     * @param addresses a set of all possible addresses
     * @param addressBuilder an address with floating bits
     * @param i an index of current bit
     */
    private void fillAddresses(Set<String> addresses, StringBuilder addressBuilder, int i){
        if (i >= addressBuilder.length()){
            addresses.add(addressBuilder.toString());
        }
        else if (addressBuilder.charAt(i) == 'X'){
            addressBuilder.setCharAt(i, '0');
            fillAddresses(addresses, new StringBuilder(addressBuilder), i + 1);

            addressBuilder.setCharAt(i, '1');
            fillAddresses(addresses, new StringBuilder(addressBuilder), i + 1);
        }
        else {
            fillAddresses(addresses, addressBuilder, i + 1);
        }
    }

    /**
     * Finds the sum of all the values in the memory.
     * @param memory map of the memory (position -> value)
     * @return sum of all the values in the memory
     */
    private long findMemorySum(HashMap<String, Integer> memory){
        long sum = 0;
        for (Map.Entry<String, Integer> pair : memory.entrySet()){
            sum += pair.getValue();
        }
        return sum;
    }
}
