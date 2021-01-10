package xenoteo.com.github.day5.part1;

import xenoteo.com.github.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<String> passes = new InputReader().readInputFileToStringList(Main.class.getResource(filePath));
        System.out.println(new Solution().highestSeatId(passes));
    }
}
