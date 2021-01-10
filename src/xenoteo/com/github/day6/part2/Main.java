package xenoteo.com.github.day6.part2;

import xenoteo.com.github.day6.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<List<String>> groups = new InputReader().readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution().sumOfGroupCounts(groups));
    }
}
