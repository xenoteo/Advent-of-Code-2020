package xenoteo.com.github.day12;

/**
 * Enum for navigation instructions.
 */
public enum Actions {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W"),
    LEFT("L"),
    RIGHT("R"),
    FORWARD("F");

    private final String value;

    Actions(String value) {
        this.value = value;
    }

    /**
     * Gets an Action from given string.
     *
     * @param actionString  an action string
     * @return the action
     */
    public static Actions actionFromString(String actionString){
        for (Actions action : Actions.values()) {
            if (action.value.equals(actionString))
                return action;
        }
        return null;
    }
}
