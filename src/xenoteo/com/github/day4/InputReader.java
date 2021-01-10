package xenoteo.com.github.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proceeding input file and converting it to a passport list.
 */
public class InputReader {
    /**
     * Reads data from the input file with provided filename.
     * @param path the path of the file
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
     * Filling the fields of a password with provided inputs.
     * @param inputs input data
     * @param passport passport to be filled
     */
    private void proceedLine(String[] inputs, Passport passport){
        for (String input : inputs){
            String[] pair = input.split(":");
            passport.addField(pair[0], pair[1]);
        }
    }
}