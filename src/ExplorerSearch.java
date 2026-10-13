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
        if (island.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[island.length][island[0].length];

        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 0) {
                    return explore(island, visited, row, col);
                }
            }
        }

        return 0;
    }

    private static int explore(int[][] island, boolean[][] visited,
            int row, int col) {
        if (row < 0 || row >= island.length ||
                col < 0 || col >= island[0].length) {
            return 0;
        }

        if (visited[row][col] ||
                island[row][col] == 2 || island[row][col] == 3) {
            return 0;
        }

        // Count each square once
        visited[row][col] = true;

        int count = 1;
        count += explore(island, visited, row - 1, col); //Up
        count += explore(island, visited, row + 1, col);  //Down
        count += explore(island, visited, row, col - 1); //Left 
        count += explore(island, visited, row, col + 1);  // Right 

        return count;

    }
}
