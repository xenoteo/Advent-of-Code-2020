package xenoteo.com.github.day16.part1;

import xenoteo.com.github.day16.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day16/input.txt");
        List<List<Integer>> rules = reader.getRules();
        List<List<Integer>> nearbyTickets = reader.getNearbyTickets();
        System.out.println(new Solution().findTicketScanningErrorRate(rules, nearbyTickets));
    }
}
