package xenoteo.com.github.day6.part2;

import xenoteo.com.github.day6.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> groups = new InputReader()
                .readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day6/input.txt");
        System.out.println(new Solution().sumOfGroupCounts(groups));
    }
}
