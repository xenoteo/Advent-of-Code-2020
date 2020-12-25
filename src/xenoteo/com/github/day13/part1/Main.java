package xenoteo.com.github.day13.part1;

import xenoteo.com.github.day13.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int timestamp = reader
                .readTimestampFromInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day13/input.txt");
        List<Integer> buses = reader
                .readInputFileToBusIdList("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day13/input.txt");
        System.out.println(new Solution().busIdMultipliedByMinutesToWait(timestamp, buses));
    }
}
