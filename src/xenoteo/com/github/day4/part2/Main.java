package xenoteo.com.github.day4.part2;

import xenoteo.com.github.day4.InputReader;
import xenoteo.com.github.day4.Passport;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Passport> passports = new InputReader()
                .readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day4/input.txt");
        System.out.println(new Solution().countValidPassports(passports));
    }
}