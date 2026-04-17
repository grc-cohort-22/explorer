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
        int rows = island.length;
        int columns = island[0].length;

        int[] explorer = findExplorer(island);

        boolean[][] visited = new boolean[rows][columns];
        return reachableArea(island, visited, explorer[0], explorer[1]);
    }

    private static int reachableArea(int[][] island, boolean[][] visited, int row, int column) {
        if(row < 0 || column < 0 || row >= island.length || column >= island[0].length) return 0;
        if(visited[row][column]) return 0;

        int tileBeingChecked = island[row][column];
        if(tileBeingChecked == 2 || tileBeingChecked == 3) return 0;

        visited[row][column] = true;

        int tileCount = 1;

        int south = reachableArea(island, visited, row+1, column);
        tileCount += south;

        int north = reachableArea(island, visited, row-1, column);
        tileCount += north;

        int east = reachableArea(island, visited, row, column+1);
        tileCount += east;

        int west = reachableArea(island, visited, row, column-1);
        tileCount += west;

        return tileCount;
    }

    private static int[] findExplorer(int[][] island) {
        for(int row = 0; row < island.length; row++) {
            for(int column = 0; column < island[0].length; column++) {
                if(island[row][column] == 0) {
                    return new int[]{row, column};
                }
            }
        }

        throw new IllegalArgumentException("No explorer was on the island.");
    }
}
