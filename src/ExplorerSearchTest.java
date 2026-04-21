import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {0,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testReachableArea_allUnreachable() {
        int[][] island = {
            {1,1,1,1,2,0},
            {1,1,1,1,3,2},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_initialLocationReachable() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,2,2,2,2,3},
            {3,2,0,2,2,3},
            {3,2,2,2,2,3},
            {3,3,3,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testStartingLocation_noExplorer() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };
        assertThrows(IllegalArgumentException.class, () -> { ExplorerSearch.startingLocation(island); });
    }

    @Test
    public void testStartingLocation_CornerExplorer() {
        int[][] island = {
            {1,1,1,3,1},
            {3,2,3,1,3},
            {1,1,1,1,3},
            {3,1,2,1,1},
            {1,1,1,2,0},
        };
        int[] location = {4, 4};
        assertArrayEquals(location, ExplorerSearch.startingLocation(island));
    }

    @Test
    public void testStartingLocation_CenterExplorer() {
        int[][] island = {
            {1,2,3,2,1},
            {1,2,3,2,3},
            {1,2,0,2,3},
            {1,2,3,2,1},
            {1,2,3,2,1},
        };
        int[] location = {2, 2};
        assertArrayEquals(location, ExplorerSearch.startingLocation(island));
    }

    @Test
    public void testPossibleMoves_BlockedIsland() {
        int[][] island = {
            {3,3,3,3,3},
            {3,3,3,3,3},
            {3,3,0,3,3},
            {3,3,3,3,3},
            {3,3,3,3,3},
        };
        int[] location = {2, 2};
        assertEquals(0, ExplorerSearch.possibleMoves(island, location).size());
        assertTrue(ExplorerSearch.possibleMoves(island, location).isEmpty());
    }

    @Test
    public void testPossibleMoves_OpenIsland() {
        int[][] island = {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,0,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
        };
        int[] location = {2, 2};
        Set<String> moves = toSet(ExplorerSearch.possibleMoves(island, location));

        assertEquals(4, ExplorerSearch.possibleMoves(island, location).size());
        assertTrue(moves.contains("1,2"));
        assertTrue(moves.contains("2,1"));
        assertTrue(moves.contains("3,2"));
        assertTrue(moves.contains("2,3"));
    }

    @Test
    public void testPossibleMoves_PathIsland() {
        int[][] island = {
            {1,1,1,1,1},
            {1,2,1,2,1},
            {1,3,1,3,1},
            {1,3,1,3,1},
            {1,2,0,2,1},
        };
        int[] location = {4, 2};
        Set<String> moves = toSet(ExplorerSearch.possibleMoves(island, location));

        assertEquals(1, ExplorerSearch.possibleMoves(island, location).size());
        assertTrue(moves.contains("3,2"));
    }

    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
