import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases
    // TESTING: ExplorerLocation method
    @Test
    public void testExplorerLocation_findsStart() {
        int[][] island = {
            {1, 1, 1},
            {3, 0, 1},
            {1, 1, 1}
        };
        int[] expected = {1, 1};
        int[] actual = ExplorerSearch.ExplorerLocation(island);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExplorerLocation_noStart_throws() {
        int[][] island = {
            {1, 1, 1},
            {3, 1, 1},
            {1, 1, 1}
        };
        ExplorerSearch.ExplorerLocation(island);
    }

    @Test
    public void testExplorerLocation_findsStart_large() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int[] expected = {3, 4};
        int[] actual = ExplorerSearch.ExplorerLocation(island);
        assertArrayEquals(expected, actual);
    }
    // TESTING: possible moves
    @Test
    public void testPossibleMoves_PossibleMovesExist() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[] location = {3, 4};

        List<int[]> expected = Arrays.asList(
            new int[]{4, 4},
            new int[]{3, 3},
            new int[]{3, 5}
        );

        List<int[]> actual = ExplorerSearch.possibleMoves(island, location);

        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testPossibleMoves_NoPossibleMovesExist() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,2,0,2},
            {1,1,1,2,2,1},
        };

        int[] location = {3, 4};

        List<int[]> expected = Arrays.asList();

        List<int[]> actual = ExplorerSearch.possibleMoves(island, location);

        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    
    
}
