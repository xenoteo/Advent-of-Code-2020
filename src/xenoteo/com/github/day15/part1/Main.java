package xenoteo.com.github.day15.part1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> startingNumbers = List.of(14, 8, 16, 0, 1, 17);
        System.out.println(new Solution().find2020thNumber(startingNumbers));
    }
}
