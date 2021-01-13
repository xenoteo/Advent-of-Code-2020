package xenoteo.com.github.day2.part1;

import java.util.List;

/**
 * Each line gives the password policy and then the password.
 *
 * The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid.
 * For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.
 *
 * Counting how many passwords are valid according to the policies.
 */
public class Solution {

    /**
     * Counts how many passwords are valid according to the policies.
     *
     * Counts the frequency of required character in each password and checks whether it is valid.
     *
     * Complexity is O(N * S), where N is a number of passwords and S is password's length.
     *
     * @param lowests  list of numbers of times a given letter must appear for the password to be valid
     * @param highests  list of numbers of times a given letter must appear for the password to be valid
     * @param letters  list of given letters
     * @param passwords  list of passwords
     * @return number of valid passwords
     */
    public int countValidPasswords(List<Integer> lowests, List<Integer> highests,
                                   List<Character> letters, List<String> passwords){
        int validPasswords = 0;
        for (int i = 0; i < passwords.size(); i++){
            int lowest = lowests.get(i);
            int highest = highests.get(i);
            char letter = letters.get(i);
            String password = passwords.get(i);

            int count = countFrequency(password, letter);

            if (count >= lowest && count <= highest)
                validPasswords++;
        }
        return validPasswords;
    }

    /**
     * Counts the frequency of a required letter in a given string.
     *
     * @param str  string
     * @param letter  to count frequency
     * @return frequency of a required letter
     */
    private int countFrequency(String str, char letter){
        int count = 0;
        for (char c : str.toCharArray()){
            if (c == letter)
                count++;
        }
        return count;
    }
}
