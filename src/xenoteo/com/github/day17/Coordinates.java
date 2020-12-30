package xenoteo.com.github.day17;

import java.util.Objects;

/**
 * Class representing either 3D or 4D point coordinates.
 * (In case of 3D the fourth value set to 0 as default.)
 */
public class Coordinates {
    public int x;
    public int y;
    public int z;
    public int w;

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 0;
    }

    public Coordinates(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y && z == that.z && w == that.w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}
