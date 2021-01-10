package xenoteo.com.github.day13.part1;

import xenoteo.com.github.day13.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        int timestamp = reader.readTimestampFromInputFile(Main.class.getResource(filePath));
        List<Integer> buses = reader.readInputFileToBusIdList(Main.class.getResource(filePath));
        System.out.println(new Solution().busIdMultipliedByMinutesToWait(timestamp, buses));
    }
}
