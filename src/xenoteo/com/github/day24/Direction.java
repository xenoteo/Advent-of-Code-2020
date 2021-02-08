package xenoteo.com.github.day24;

/**
 * Enum representing hexagonal directions.
 */
public enum Direction {
    E("e"),
    SE("se"),
    SW("sw"),
    W("w"),
    NE("ne"),
    NW("nw");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    /**
     * Gets a direction matching the provided string.
     *
     * @param directionString  the string representing a direction
     * @return the direction matching the provided string
     */
    public static Direction directionFromString(String directionString){
        for (Direction direction : Direction.values()){
            if (direction.value.equals(directionString))
                return direction;
        }
        return null;
    }
}
