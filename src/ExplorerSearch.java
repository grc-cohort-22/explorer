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
        int[] start = new int[]{-1, -1};
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (island[i][j] == 's') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        if (start[0] == -1||start[1] == -1) throw new IllegalArgumentException("Explorer not found");
        return reachableArea(island, start, new boolean[island.length][island[0].length]);
    }

    private static int reachableArea(int[][] island, int[] current, boolean[][] visited) {

    }
}
