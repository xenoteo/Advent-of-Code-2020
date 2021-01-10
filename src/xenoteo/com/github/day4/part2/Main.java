package xenoteo.com.github.day4.part2;

import xenoteo.com.github.day4.InputReader;
import xenoteo.com.github.day4.Passport;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Passport> passports = new InputReader().readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution().countValidPassports(passports));
    }
}