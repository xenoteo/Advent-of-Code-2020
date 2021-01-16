package xenoteo.com.github.day8;

/**
 * Enum representing game instructions.
 */
public enum Instructions {
    ACC("acc"),
    JMP("jmp"),
    NOP("nop");

    private final String value;

    Instructions(String op) {
        value = op;
    }

    /**
     * Gets an instruction from enum that is represented by input string.
     *
     * @param op  input string
     * @return an instruction represented by input string
     */
    public static Instructions instructionFromString(String op){
        for (Instructions instruction : Instructions.values()) {
            if (instruction.value.equals(op))
                return instruction;
        }
        return null;
    }
}
