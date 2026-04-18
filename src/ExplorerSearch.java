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
        return travelTiles(start, island, visited, 0);
    }

    static int travelTiles(int[] location, int[][] island, boolean[][] visited, int count){
        int curR = location[0];
        int curC = location[1];

        if(visited[curR][curC]) return count;

        visited[curR][curC] = true;
        count++;

        for(int[] travel : traveling(island, location)){
            count = travelTiles(travel, island, visited, count);
        }

        return count;
    }

    public static List<int[]> traveling(int[][] island, int[] location){
        int curR = location[0];
        int curC = location[1];

        List<int[]> validLocs = new ArrayList<>();

        // up
        int newR = curR - 1;
        int newC = curC;

        if(newR >= 0 && (island[newR][newC] != 2 && island[newR][newC] != 3)){
            validLocs.add(new int[]{newR, newC});
        }

        // down
        newR = curR + 1;
        newC = curC;

        if(newR < island.length && (island[newR][newC] != 2 && island[newR][newC] != 3)){
            validLocs.add(new int[]{newR, newC});
        }

        //right
        newR = curR;
        newC = curC + 1;

        if(newC < island[0].length && (island[newR][newC] != 2 && island[newR][newC] != 3)){
            validLocs.add(new int[]{newR, newC});
        }

        //left
        newR = curR;
        newC = curC - 1;

        if(newC >= 0 && (island[newR][newC] != 2 && island[newR][newC] != 3)){
            validLocs.add(new int[]{newR, newC});
        }
        return validLocs;
    }

    static int[] startingLocation(int[][] island){
        for(int i = 0; i < island.length; i++) {
            for(int j = 0; j < island[0].length; j++){
                if(island[i][j] == 0){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Starting location");
    }
}
