package xenoteo.com.github.day24;

import java.util.Objects;

/**
 * Class representing hexagonal point.
 * The x coordinate is measured by halfs, the y coordinate is integer.
 */
public class Point {
    public double x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Updates the point's coordinates according to the provided direction.
     *
     * @param direction  the direction
     */
    public void update(Direction direction){
        switch (direction){
            case E -> x++;
            case W -> x--;
            case NE -> {
                x += 0.5;
                y++;
            }
            case NW -> {
                x -= 0.5;
                y++;
            }
            case SE -> {
                x += 0.5;
                y--;
            }
            case SW -> {
                x -= 0.5;
                y--;
            }
        }
    }
}
