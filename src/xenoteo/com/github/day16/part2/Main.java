package xenoteo.com.github.day16.part2;

import xenoteo.com.github.day16.InputReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day16/input.txt");
        Map<String, List<Integer>> rules = reader.getRules();
        List<Integer> myTicket = reader.getMyTicket();
        List<List<Integer>> nearbyTickets = reader.getNearbyTickets();
        System.out.println(new Solution().multiplicationOfSixDepartureValues(rules, myTicket, nearbyTickets));
    }
}
