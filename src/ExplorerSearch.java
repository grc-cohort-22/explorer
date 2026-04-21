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
     * They CANNOT move onto a body of water or mountain.
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
        int[] start = findStart(island);

        boolean[][] visited = new boolean[island.length][island[0].length];
        
        return explore(island, start[0], start[1], visited);
    }

    // returns the explorer's initial starting position
    public static int[] findStart(int[][] island) {
        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[0].length; col++) {
                if (island[row][col] == 0) {
                    return new int[]{row,col};
                }
            }
        }
        return null;
    }

    // returns the count of every possible space available for the explorer to move to (also includes the starting position)
    public static int explore(int[][] island, int row, int col, boolean[][] visited) {
        if (row < 0 || row  >= island.length || 
            col < 0 || col >= island[0].length ||
            visited[row][col] || island[row][col] == 2 || 
            island[row][col] == 3
        ) return 0;

        visited[row][col] = true;

        // count the starting position of the explorer
        int count = 1;

        count += explore(island, row - 1, col, visited); //up
        count += explore(island, row + 1, col, visited); //down
        count += explore(island, row, col - 1, visited); // left
        count += explore(island, row, col + 1, visited); // right

        return count;
    } 
}
