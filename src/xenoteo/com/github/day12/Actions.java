package xenoteo.com.github.day12;

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

    public static Actions actionFromString(String act){
        for (Actions action : Actions.values()) {
            if (action.value.equals(act))
                return action;
        }
        return null;
    }
}
