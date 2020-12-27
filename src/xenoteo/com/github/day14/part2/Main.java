package xenoteo.com.github.day14.part2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day14/input.txt");
        List<String> masks = reader.getMasks();
        List<MemoryMap> assignments = reader.getAssignments();
        System.out.println(new Solution().sumOfAllValuesInMemory(masks, assignments));
    }
}