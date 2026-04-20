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
        int[] start =  reachableAreaHelperStartPoint(island);
        System.out.println("start row " + start[0]);
        System.out.println("start col " + start[1]);
        
        // List<int[]> validMove = validMoves(start, island);
        // System.out.println(validMove);
        boolean[][] visited = new boolean[island.length][island[0].length];
        // int moves = reachable(start, island, 0, visited);
        // System.out.println(moves);


      
        return reachable(start, island,  visited);
    }

    private static int reachable(int[] startingPoint, int[][] island, boolean[][] visited){
        int currentRow = startingPoint[0];
        int currentCol = startingPoint[1];
        int moves = 0;

        if(visited[currentRow][currentCol]) return 0;

        visited[currentRow][currentCol] = true;

        for(int[] neighbor : validMoves(startingPoint, island)){
                int move = reachable(neighbor, island, visited);
                moves += move;
        }

        return moves + 1;
    }

    private static int[] reachableAreaHelperStartPoint (int[][] island){

        for(int row = 0; row < island.length;row++){
            for(int col = 0; col < island[row].length;col++){
               if(island[row][col] == 0){
                return new int[]{row,col};
               }
            }
        }
        throw new IllegalArgumentException("There is no starting point");
    }

    private static List<int[]> validMoves(int[] startPoint, int[][] island){
        List<int[]> possible = new ArrayList<>();
        // int moves = 0;
        int startRow = startPoint[0];
        int startCol = startPoint[1];

        // possible.add(new int[]{startRow, startCol});

        // up
        int newRow = startRow - 1;
        int newCol = startCol;
        if(newRow >= 0 && island[newRow][newCol] != 3 && island[newRow][newCol] != 2){
            possible.add(new int[]{newRow, newCol});
        }

        //down
        newRow = startRow + 1;
        newCol = startCol;
        if(newRow < island.length && island[newRow][newCol] != 3 && island[newRow][newCol] != 2){
            possible.add(new int[]{newRow, newCol});
        }

        //right
        newRow = startRow;
        newCol = startCol + 1;
        if(newCol < island[startRow].length && island[newRow][newCol] != 3 && island[newRow][newCol] != 2){
            possible.add(new int[]{newRow, newCol});
        }


        //left
        newRow = startRow;
        newCol = startCol - 1;
        if(newCol >= 0 && island[newRow][newCol] != 3 && island[newRow][newCol] != 2){
            possible.add(new int[]{newRow, newCol});
        }


        //count moves
        // for(int[] move : possible){
        //     moves++;
        // }



        return possible;
    }
}
