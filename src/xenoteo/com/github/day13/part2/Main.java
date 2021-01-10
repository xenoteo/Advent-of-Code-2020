package xenoteo.com.github.day13.part2;

import xenoteo.com.github.day13.InputReader;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        HashMap<Integer, Integer> buses = new InputReader()
                .readInputFileToBusIdMap(Main.class.getResource(filePath));
        System.out.println(new Solution().findEarliestTimestamp(buses));
    }
}
