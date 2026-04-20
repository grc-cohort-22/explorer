import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        // Locate and store the persons location on the island
        int[] personLocation = findPersonLocation(island);

        // Track all visited spots on the island
        boolean[][] visited = new boolean[island.length][island[0].length];

        // Return the number of spots we reached
        int count = canReach(personLocation, island, visited);
        return count;
    }

    private static int canReach(int[] currentLocation, int[][] island, boolean[][] visited) {
        int currR = currentLocation[0];
        int currC = currentLocation[1];

        if (visited[currR][currC]) return 0;
        visited[currR][currC] = true;

        int count = 1;

        List<int[]> validLocations = possibleMoves(island, currentLocation);

        for (int[] point : validLocations) {
            count += canReach(point, island, visited);
        }

        return count;
    }

    public static List<int[]> possibleMoves(int[][] island, int[] currentLocation) {
        int currR = currentLocation[0];
        int currC = currentLocation[1];
        List<int[]> validLocations = new ArrayList<>();

        // up
        int newR = currR - 1;
        int newC = currC;
        if (newR >= 0 && (island[newR][newC] == 0 || island[newR][newC] == 1)) {
            validLocations.add(new int[] {newR, newC});
        }

        // down
        newR = currR + 1;
        newC = currC;
        if (newR < island.length && (island[newR][newC] == 0 || island[newR][newC] == 1)) {
            validLocations.add(new int[] {newR, newC});
        }

        // left
        newR = currR;
        newC = currC - 1;
        if (newC >= 0 && (island[newR][newC] == 0 || island[newR][newC] == 1)) {
            validLocations.add(new int[] {newR, newC});
        }

        // right
        newR = currR;
        newC = currC + 1;
        if (newC < island[0].length && (island[newR][newC] == 0 || island[newR][newC] == 1)) {
            validLocations.add(new int[] {newR, newC});
        }

        return validLocations;
    }

    /**
     * This method is designed to find a person on a rectangular 2d array
     * Will throw an illegal argument exception if there is no person on the island
     * @param island
     * @return coordinates/location of the found person
     */
    public static int[] findPersonLocation(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[r].length; c++) {
                if (island[r][c] == 0) return new int[] {r, c};
            }
        }
        throw new IllegalArgumentException("Preson not found in island.");
    }
}
