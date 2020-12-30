package xenoteo.com.github.day17.part1;

import xenoteo.com.github.day17.Coordinates;

import java.util.HashSet;
import java.util.Set;

/**
 * The pocket dimension contains an infinite 3-dimensional grid. At every integer 3-dimensional coordinate (x,y,z),
 * there exists a single cube which is either active or inactive.
 *
 * In the initial state of the pocket dimension, almost all cubes start inactive. The only exception to this is a small
 * flat region of cubes; the cubes in this region start in the specified active (#) or inactive (.) state.
 *
 * Each cube only ever considers its neighbors: any of the 26 other cubes where any of their coordinates differ by at most 1.
 *
 * During a cycle, all cubes simultaneously change their state according to the following rules:
 * - If a cube is active and exactly 2 or 3 of its neighbors are also active, the cube remains active.
 *   Otherwise, the cube becomes inactive.
 * - If a cube is inactive but exactly 3 of its neighbors are active, the cube becomes active.
 *   Otherwise, the cube remains inactive.
 *
 * Even though the pocket dimension is 3-dimensional, this initial state represents a small 2-dimensional slice of it.
 *
 * Counting how many cubes are left in the active state after the sixth cycle.
 */
public class Solution {

    /**
     * Counts how many cubes are left in the active state after the sixth cycle.
     * @param states initial state (2D slice of 3D where z = 0)
     * @return number of active cubes after 6 cycles
     */
    public int activeCubesAfter6Cycles(char[][] states){
        Set<Coordinates> activeCubes = fillActiveCubesSetFromInitialStates(states);
        for (int i = 0; i < 6; i++){
            Set<Coordinates> neighbours = neighboursOfActiveCubes(activeCubes);
            Set<Coordinates> newActiveCubes = new HashSet<>();

            for (Coordinates cube : activeCubes){
                int activeNeighbours = countActiveNeighbours(activeCubes, cube);
                if (activeNeighbours == 2 || activeNeighbours == 3)
                    newActiveCubes.add(cube);
            }

            for (Coordinates cube : neighbours){
                if (!activeCubes.contains(cube)){
                    int activeNeighbours = countActiveNeighbours(activeCubes, cube);
                    if (activeNeighbours == 3)
                        newActiveCubes.add(cube);
                }
            }

            activeCubes = newActiveCubes;
        }
        return activeCubes.size();
    }

    /**
     * Fills the set of coordinates of active cubes according to initial state.
     * @param states initial state
     * @return filled set of active cubes
     */
    private Set<Coordinates> fillActiveCubesSetFromInitialStates(char[][] states){
        Set<Coordinates> activeCubes = new HashSet<>();
        for (int i = 0; i < states.length; i++){
            for (int j = 0; j < states[0].length; j++){
                if (states[i][j] == '#')
                    activeCubes.add(new Coordinates(i, j, 0));
            }
        }
        return activeCubes;
    }

    /**
     * Creates a set of all the neighbours of active cubes.
     * @param activeCubes the set of active cubes
     * @return a set of the active cubes neighbours
     */
    private Set<Coordinates> neighboursOfActiveCubes(Set<Coordinates> activeCubes){
        Set<Coordinates> neighbours = new HashSet<>();
        for (Coordinates cube : activeCubes){
            fillCubeNeighboursSet(neighbours, cube);
        }
        return neighbours;
    }

    /**
     * Fills the set with all cube's neighbours.
     * @param neighbours the set to fill
     * @param cube a cube
     */
    private void fillCubeNeighboursSet(Set<Coordinates> neighbours, Coordinates cube){
        neighbours.add(new Coordinates(cube.x - 1, cube.y, cube.z));
        neighbours.add(new Coordinates(cube.x - 1, cube.y - 1, cube.z));
        neighbours.add(new Coordinates(cube.x - 1, cube.y + 1, cube.z));
        neighbours.add(new Coordinates(cube.x - 1, cube.y, cube.z - 1));
        neighbours.add(new Coordinates(cube.x - 1, cube.y, cube.z + 1));
        neighbours.add(new Coordinates(cube.x - 1, cube.y - 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x - 1, cube.y - 1, cube.z + 1));
        neighbours.add(new Coordinates(cube.x - 1, cube.y + 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x - 1, cube.y + 1, cube.z + 1));

        neighbours.add(new Coordinates(cube.x, cube.y - 1, cube.z));
        neighbours.add(new Coordinates(cube.x, cube.y + 1, cube.z));
        neighbours.add(new Coordinates(cube.x, cube.y, cube.z - 1));
        neighbours.add(new Coordinates(cube.x, cube.y, cube.z + 1));
        neighbours.add(new Coordinates(cube.x, cube.y - 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x, cube.y - 1, cube.z + 1));
        neighbours.add(new Coordinates(cube.x, cube.y + 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x, cube.y + 1, cube.z + 1));

        neighbours.add(new Coordinates(cube.x + 1, cube.y, cube.z));
        neighbours.add(new Coordinates(cube.x + 1, cube.y - 1, cube.z));
        neighbours.add(new Coordinates(cube.x + 1, cube.y + 1, cube.z));
        neighbours.add(new Coordinates(cube.x + 1, cube.y, cube.z - 1));
        neighbours.add(new Coordinates(cube.x + 1, cube.y, cube.z + 1));
        neighbours.add(new Coordinates(cube.x + 1, cube.y - 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x + 1, cube.y - 1, cube.z + 1));
        neighbours.add(new Coordinates(cube.x + 1, cube.y + 1, cube.z - 1));
        neighbours.add(new Coordinates(cube.x + 1, cube.y + 1, cube.z + 1));
    }

    /**
     * Counts active neighbours of the cube.
     * @param activeCubes the set of all active cubes
     * @param cube the cube to count neighbours
     * @return number of active neighbours of the cube
     */
    private int countActiveNeighbours(Set<Coordinates> activeCubes, Coordinates cube){
        int activeNeighbours = 0;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y - 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y + 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y - 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y - 1, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y + 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x - 1, cube.y + 1, cube.z + 1))) activeNeighbours++;

        if (activeCubes.contains(new Coordinates(cube.x, cube.y - 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y + 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y - 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y - 1, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y + 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x, cube.y + 1, cube.z + 1))) activeNeighbours++;

        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y - 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y + 1, cube.z))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y - 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y - 1, cube.z + 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y + 1, cube.z - 1))) activeNeighbours++;
        if (activeCubes.contains(new Coordinates(cube.x + 1, cube.y + 1, cube.z + 1)))activeNeighbours++;

        return activeNeighbours;
    }
}
