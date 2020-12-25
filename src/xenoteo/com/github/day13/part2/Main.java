package xenoteo.com.github.day13.part2;

import xenoteo.com.github.day13.InputReader;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> buses = new InputReader()
                .readInputFileToBusIdMap("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day13/input.txt");
        System.out.println(new Solution().findEarliestTimestamp(buses));
    }

    public static void print(HashMap<Integer, Integer> buses){
        for (Map.Entry<Integer, Integer> pair : buses.entrySet()){
            System.out.printf("%-3d: %d\n", pair.getKey(), pair.getValue());
        }
    }
}
