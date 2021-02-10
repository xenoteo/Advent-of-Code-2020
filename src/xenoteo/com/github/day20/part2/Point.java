package xenoteo.com.github.day20.part2;

import java.util.Objects;

/**
 * Class representing 2D point.
 */
public class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the point.
     *
     * @param dx  the x difference
     * @param dy  the y difference
     * @return the moved point
     */
    public Point move(int dx, int dy) {
        return new Point(x + dx, y + dy);
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
}
