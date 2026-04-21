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
        int[] startLocation = ExplorerLocation(island);

        return visited.size();
    }
    // int[][] island = {
    //     {1,1,1,3,1,1},
    //     {3,2,3,1,3,1},
    //     {1,1,1,1,3,3},
    //     {3,1,2,1,0,1},
    //     {1,1,1,2,1,1},
    // };

    //return the [row, col] location fot eh salamander
    //throw IllegalArgumentException if there is no salamander.
    public static int[] ExplorerLocation(int[][] island) {
        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 0) {
                    int[] result = {row, col};
                    return result;
                }
            }
        }
        
        throw new IllegalArgumentException("No explorer present");
    }
    
}
