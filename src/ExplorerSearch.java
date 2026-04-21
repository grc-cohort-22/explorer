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
        int[] startLocation = startingLocation(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return reachableArea(startLocation, island, visited);
    }

    private static int reachableArea(int[] currentLocation, int[][] island, boolean[][] visited) {
        int currentR = currentLocation[0];
        int currentC = currentLocation[1];

        if(currentR < 0 || currentC < 0 || currentR >= island.length || currentC >= island[0].length) { return 0; }
        if(island[currentR][currentC] == 2 || island[currentR][currentC] == 3) { return 0; }
        if(visited[currentR][currentC]) { return 0; }

        visited[currentR][currentC] = true;
        int reachCount = 1;

        for(int[] move : possibleMoves(island, currentLocation)) {
            reachCount += reachableArea(move, island, visited);
        }

        return reachCount;
    }

    public static List<int[]> possibleMoves(int[][] island, int[] location) {
        int currentR = location[0];
        int currentC = location[1];
        List<int[]> validLocations = new ArrayList<>();

        //Moving up
        int newR = currentR - 1;
        int newC = currentC;
        if(newR >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3) { validLocations.add(new int[]{newR, newC}); }
        //Moving down
        newR = currentR + 1;
        newC = currentC;
        if(newR < island.length && island[newR][newC] != 2 && island[newR][newC] != 3) { validLocations.add(new int[]{newR, newC}); }
        //Moving left
        newR = currentR;
        newC = currentC - 1;
        if(newC >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3) { validLocations.add(new int[]{newR, newC}); }
        //Moving right
        newR = currentR;
        newC = currentC + 1;
        if(newC < island[0].length && island[newR][newC] != 2 && island[newR][newC] != 3) { validLocations.add(new int[]{newR, newC}); }

        return validLocations;
    }

    public static int[] startingLocation(int[][] island) {
        for(int row = 0; row < island.length; row++) {
            for(int col = 0; col < island[row].length; col++) {
                if(island[row][col] == 0) { 
                    return new int[]{row, col};
                }
            }
        }
        throw new IllegalArgumentException("The explorer was not found on the island.");
    } 
}
