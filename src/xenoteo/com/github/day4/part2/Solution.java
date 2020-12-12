package xenoteo.com.github.day4.part2;

import xenoteo.com.github.day4.Passport;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counting how many passports are valid.
 * Passport is valid when all eight fields are present or when the only missing field is cid,
 * and each field has strict rules about what values are valid for automatic validation:
 *  - byr (Birth Year) - four digits; at least 1920 and at most 2002.
 *  - iyr (Issue Year) - four digits; at least 2010 and at most 2020.
 *  - eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
 *  - hgt (Height) - a number followed by either cm or in:
 *      - If cm, the number must be at least 150 and at most 193.
 *      - If in, the number must be at least 59 and at most 76.
 *  - hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
 *  - ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
 *  - pid (Passport ID) - a nine-digit number, including leading zeroes.
 *  - cid (Country ID) - ignored, missing or not.
 */
public class Solution {
    public int countValidPassports(List<Passport> passports){
        int count = 0;
        for (Passport passport : passports){
            if (passport.fieldsCount == 8 || (passport.fieldsCount == 7 && passport.cid == null)){
                if (byrValid(passport.byr) && iyrValid(passport.iyr) && eyrValid(passport.eyr)
                        && hgtValid(passport.hgt) && hclValid(passport.hcl)
                        && eclValid(passport.ecl) && pidValid(passport.pid))
                    count++;
            }
        }
        return count;
    }

    /**
     * Checks whether birth year is valid,
     * that is whether it contains four digits and has value of at least 1920 and at most 2002.
     * @param byr birth year
     * @return whether birth year is valid
     */
    private boolean byrValid(String byr){
        int year = Integer.parseInt(byr);
        return (year >= 1920 && year <= 2002);
    }

    /**
     * Checks whether issue year is valid,
     * that is whether it contains four digits and has value of at least 2010 and at most 2020.
     * @param iyr issue year
     * @return whether issue year is valid
     */
    private boolean iyrValid(String iyr){
        int year = Integer.parseInt(iyr);
        return (year >= 2010 && year <= 2020);
    }

    /**
     * Checks whether expiration year is valid,
     * that is whether it contains four digits and has value of at least 2020 and at most 2030.
     * @param eyr expiration year
     * @return whether expiration year is valid
     */
    private boolean eyrValid(String eyr){
        int year = Integer.parseInt(eyr);
        return (year >= 2020 && year <= 2030);
    }

    /**
     * Checks whether height is valid,
     * that is if it has value of at least 150 and at most 193 cm or at least 59 and at most 76 in.
     * @param hgt height
     * @return whether height is valid
     */
    private boolean hgtValid(String hgt){
        if (hgt.indexOf('c') != -1){
            int height = Integer.parseInt(hgt.split("c")[0]);
            return (height >= 150 && height <= 193);
        }
        else {
            int height = Integer.parseInt(hgt.split("i")[0]);
            return (height >= 59 && height <= 76);
        }
    }

    /**
     * Checks whether hair color is valid,
     * that is a # followed by exactly six characters 0-9 or a-f.
     * @param hcl hair color
     * @return whether hair color is valid
     */
    private boolean hclValid(String hcl){
        Pattern pattern = Pattern.compile("#[a-f0-9]{6}");
        Matcher matcher = pattern.matcher(hcl);
        return matcher.matches();
    }

    /**
     * Checks whether eye color is valid,
     * that is has value one of amb blu brn gry grn hzl oth.
     * @param ecl eye color
     * @return whether eye color is valid
     */
    private boolean eclValid(String ecl){
        return ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry")
                || ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth");
    }

    /**
     * Checks whether passport ID is valid,
     * that is a nine-digit number, including leading zeroes.
     * @param pid passport ID
     * @return whether passport ID is valid
     */
    private boolean pidValid(String pid){
        return pid.length() == 9;
    }
}