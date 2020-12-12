package xenoteo.com.github.day5.part2;

import xenoteo.com.github.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> passes = new InputReader()
                .readInputFileToStringList("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day5/input.txt");
        System.out.println(new Solution().findFreeSeatId(passes));
    }
}
