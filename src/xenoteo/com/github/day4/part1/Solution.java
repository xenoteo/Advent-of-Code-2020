package xenoteo.com.github.day4.part1;

import xenoteo.com.github.day4.Passport;

import java.util.List;

/**
 * Counting how many passports are valid.
 * Passport is valid when all eight fields are present or when the only missing field is cid.
 */
public class Solution {
    public int countValidPassports(List<Passport> passports){
        int count = 0;
        for (Passport passport : passports){
            if (passport.fieldsCount == 8 || (passport.fieldsCount == 7 && passport.cid == null))
                count++;
        }
        return count;
    }
}