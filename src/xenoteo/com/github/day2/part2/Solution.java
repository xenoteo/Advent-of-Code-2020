package xenoteo.com.github.day2.part2;

import java.util.List;

/**
 * Each line gives the password policy and then the password.
 *
 * Each policy describes two positions in the password, where 1 means the first character.
 * Exactly one of these positions must contain the given letter.
 * Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
 *
 * Counting how many passwords are valid according to the policies.
 */
public class Solution {

    /**
     * Counts how many passwords are valid according to the policies.
     *
     * Finds characters at given indexes and checks whether they are valid.
     *
     * Complexity is O(N), where N is a number of passwords.
     *
     * @param lowests  list of first positions
     * @param highests  list of second positions
     * @param letters  list of given letters
     * @param passwords  list of passwords
     * @return number of valid passwords
     */
    public int countValidPasswords(List<Integer> lowests, List<Integer> highests,
                                   List<Character> letters, List<String> passwords){
        int validPasswords = 0;
        for (int i = 0; i < passwords.size(); i++){
            int lowest = lowests.get(i) - 1;
            int highest = highests.get(i) - 1;
            char letter = letters.get(i);
            String password = passwords.get(i);

            char first = password.charAt(lowest);
            char second = password.charAt(highest);

            if ((first == letter || second == letter) && !(first == letter && second == letter))
                validPasswords++;
        }
        return validPasswords;
    }
}
