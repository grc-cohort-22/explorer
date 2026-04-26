import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Condition.Step;

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
        Location starting = getStarting(island);
        if (starting == null) return 0;

        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        int spots = 0;
        spots += dfs(starting, island, new HashSet<Location>());
        return spots;
    }

    public static Location getStarting(int[][] island){
        for (int r = 0; r < island.length; r++){
            for (int c = 0; c < island[r].length; c++){
                if (island[r][c] == 0){
                    return new Location(r, c);
                }
            }
        }

        return null;
    }
    

    public static int dfs(Location starting, int[][] island, Set<Location> seen){
        if (
            island[starting.row()][starting.col()] == 2 || 
            island[starting.row()][starting.col()] == 3 ||
            // island[starting.row()][starting.col()] == 0 ||
            seen.contains(starting)
        ){
            return 0;
        }
        
        int reachable = 1;

        seen.add(starting);

        int[][] moves = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] move : moves){
            if (
                starting.row() + move[0] >= 0 &&
                starting.row() + move[0] < island.length &&
                starting.col() + move[1] >= 0 &&
                starting.col() + move[1] < island[starting.row()].length &&
                island[starting.row() + move[0]][starting.col() + move[1]] == 1
            ){
                reachable += dfs(new Location(starting.row() + move[0], starting.col() + move[1]), island, seen);
            } 
        }


        return reachable;
    }
    public record Location(int row, int col){}
}
