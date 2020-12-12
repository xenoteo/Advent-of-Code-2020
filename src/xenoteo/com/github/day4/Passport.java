package xenoteo.com.github.day4;

/**
 * Class representing password.
 */
public class Passport {
    /**
     * Birth Year.
     */
    public String byr;

    /**
     * Issue Year.
     */
    public String iyr;

    /**
     * Expiration Year.
     */
    public String eyr;

    /**
     * Height.
     */
    public String hgt;

    /**
     * Hair Color.
     */
    public String hcl;

    /**
     * Eye Color.
     */
    public String ecl;

    /**
     * Passport ID.
     */
    public String pid;

    /**
     * Country ID.
     */
    public String cid;

    /**
     * The number of filled fields.
     */
    public int fieldsCount = 0;

    /**
     * Filling new field in a password.
     * @param fieldName string representing field's name
     * @param fieldValue value of the field
     */
    public void addField(String fieldName, String fieldValue){
        fieldsCount++;
        switch (fieldName) {
            case "byr" -> byr = fieldValue;
            case "iyr" -> iyr = fieldValue;
            case "eyr" -> eyr = fieldValue;
            case "hgt" -> hgt = fieldValue;
            case "hcl" -> hcl = fieldValue;
            case "ecl" -> ecl = fieldValue;
            case "pid" -> pid = fieldValue;
            case "cid" -> cid = fieldValue;
            default -> fieldsCount--;
        }
    }
}