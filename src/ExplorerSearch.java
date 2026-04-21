import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> visited = new HashSet<>();

        return visited.size();
    }

    public static boolean canReach(char[][] enclosure) {
        int [] startLocation = salamanderLocation(enclosure);
        boolean[][] visisted = new boolean[enclosure.length][enclosure[0].length];
        return canReach(startLocation, enclosure, visisted);
    }

    private static boolean canReach(int[] currentLoc, char[][] enclosure, boolean[][] visisted) {
        int curR = currentLoc[0];
        int curC = currentLoc[1];
        if (enclosure[curR][curC] == 'f') return true;
        if (visisted[curR][curC]) return false;

        visisted[curR][curC] = true;

        
        for (int[] move : possibleMoves(enclosure, currentLoc)) {
            if (canReach(move, enclosure, visisted)) {
                return true;
            }
        }
        return false;
        
    }

    public static List<int[]> possibleMoves(char[][] enclosure, int[] location) {
        int curR = location[0];
        int curC = location[1];

        List<int[]> validLocs = new ArrayList<>();

        // UP
        int newR = curR - 1;
        int newC = curC;

        if (newR >= 0 && enclosure[newR][newC] != 'W') {
            validLocs.add(new int[]{newR, newC});

        }
        // DOWN
        newR = curR + 1;
        newC = curC;

        if (newR < enclosure.length && enclosure[newR][newC] != 'W') {
            validLocs.add(new int[]{newR, newC});

        }
        // LEFT
        newR = curR;
        newC = curC - 1;

        if (newC >= 0 && enclosure[newR][newC] != 'W') {
            validLocs.add(new int[]{newR, newC});

        }
        // RIGHT
        newR = curR;
        newC = curC + 1;

        if (newC < enclosure[newR].length && enclosure[newR][newC] != 'W') {
            validLocs.add(new int[]{newR, newC});

        }
        return validLocs;
    }

    //return the [row, col] location fot eh salamander
    //throw IllegalArgumentException if there is no salamander.
    public static int[] salamanderLocation(char[][] enclosure) {
        for (int row = 0; row < enclosure.length; row++) {
            for (int col = 0; col < enclosure[row].length; col++) {
                if (enclosure[row][col] == 's') {
                    int[] result = {row, col};
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No salamander present");
    }
}
