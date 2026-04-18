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

    @Test
    public void testReachableArea_Unmovable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,2,0,2},
            {1,1,1,2,2,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_AllReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testTravelTiles_AllDirections() {
        int[][] island = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int[] location = {1, 1};
        boolean[][] visited = new boolean[3][3];
        int actual = ExplorerSearch.travelTiles(location, island, visited, 0);
        assertEquals(9, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testStartingLocation_TopLeft() {
        int[][] island = {
            {0,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] actual = ExplorerSearch.startingLocation(island);
        assertArrayEquals(new int[]{0, 0}, actual);
    }

    @Test
    public void testStartingLocation_Middle() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,0,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] actual = ExplorerSearch.startingLocation(island);
        assertArrayEquals(new int[]{2, 3}, actual);
    }

    @Test
    public void testStartingLocation_LastIndex() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,0},
        };

        int[] actual = ExplorerSearch.startingLocation(island);
        assertArrayEquals(new int[]{4, 5}, actual);
    }

    @Test
    public void testPossibleMoves_Center_MediumIsland() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,0,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] location = {2, 2};
        List<int[]> actual = ExplorerSearch.traveling(island, location);
        List<int[]> expected = Arrays.asList(
            new int[]{2, 3}, // right
            new int[]{2, 1}  // left
        );

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testPossibleMove_SmallIsland() {
        int[][] island = {
            {0, 2},
            {3, 1}
        };

        int[] location = {0, 0};
        List<int[]> actual = ExplorerSearch.traveling(island, location);
        List<int[]> expected = Arrays.asList();

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }
}
