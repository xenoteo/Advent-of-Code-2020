package xenoteo.com.github.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding input file and converting it to a passport list.
 *
 * Each passport is represented as a sequence of key:value pairs separated by spaces or newlines.
 * Passports are separated by blank lines.
 *
 * Input example:
 * <pre>
 * eyr:2029 iyr:2013
 * hcl:#ceb3a1 byr:1939 ecl:blu
 * hgt:163cm
 * pid:660456119
 *
 * hcl:#0f8b2e ecl:grn
 * byr:1975 iyr:2011
 * eyr:2028 cid:207 hgt:158cm
 * pid:755567813
 * </pre>
 */
public class InputReader {
    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to Passport list
     */
    public List<Passport> readInputFile(URL path){
        try {
            List<Passport> passports = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            Passport lastPassport = new Passport();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    passports.add(lastPassport);
                    lastPassport = new Passport();
                }
                else {
                    proceedLine(line.split(" "), lastPassport);
                }
            }
            passports.add(lastPassport);
            scanner.close();
            return passports;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fills the fields of a password with provided inputs.
     *
     * @param inputs  input data
     * @param passport  passport to be filled
     */
    private void proceedLine(String[] inputs, Passport passport){
        for (String input : inputs){
            String[] pair = input.split(":");
            passport.addField(pair[0], pair[1]);
        }
    }
}