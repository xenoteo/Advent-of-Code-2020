package xenoteo.com.github.day15.part2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 30000000;
        List<Integer> startingNumbers = List.of(14, 8, 16, 0, 1, 17);
        System.out.println(new Solution().findNthNumber(startingNumbers, n));
    }
}
