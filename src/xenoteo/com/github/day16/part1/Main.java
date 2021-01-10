package xenoteo.com.github.day16.part1;

import xenoteo.com.github.day16.InputReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        List<List<Integer>> rules = reader.getRulesList();
        List<List<Integer>> nearbyTickets = reader.getNearbyTickets();
        System.out.println(new Solution().findTicketScanningErrorRate(rules, nearbyTickets));
    }
}
