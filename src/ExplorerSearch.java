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
        int[] start = startingLocation(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return reachableArea(start, island, visited, 0);
    }

    private static int reachableArea(int[] current, int[][] map, boolean[][] visited, int count) {
        int curR = current[0];
        int curC = current[1];
        if (visited[curR][curC]) return count;
        visited[curR][curC] = true;
        count++;
        for (int[] move : possibleMoves(map, current)) {
            count = reachableArea(move, map, visited, count);
        }
        return count;
    }

    // Returns starting location
    public static int[] startingLocation(int[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 0) return new int[]{row, col};
            }
        }
        throw new IllegalArgumentException("No starting location present");
    }

    // Returns all possible moves from the current position
    public static List<int[]> possibleMoves(int[][] map, int[] location) {
        int curR = location[0];
        int curC = location[1];

        List<int[]> validLocs = new ArrayList<>();

        // UP
        curR--;
        if (curR >= 0 && curC < map[curR].length && map[curR][curC] != 2 && map[curR][curC] != 3) {
            validLocs.add(new int[]{curR, curC});
        }

        // DOWN
        curR += 2;
        if (curR < map.length && curC < map[curR].length && map[curR][curC] != 2 && map[curR][curC] != 3) {
            validLocs.add(new int[]{curR, curC});
        }

        // LEFT
        curR--;
        curC--;
        if (curC >= 0 && map[curR][curC] != 2 && map[curR][curC] != 3) {
            validLocs.add(new int[]{curR, curC});
        }

        // RIGHT
        curC += 2;
        if (curC < map[curR].length && map[curR][curC] != 2 && map[curR][curC] != 3) {
            validLocs.add(new int[]{curR, curC});
        }

        return validLocs;
    }
}
