import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // Single cell (only start)
    @Test
    public void testReachableArea_singleCell() {
        int[][] island = {
            {0}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    // Fully open grid
    @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {0,1,1},
            {1,1,1},
            {1,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual);
    }

    // Surrounded by obstacles
    @Test
    public void testReachableArea_surrounded() {
        int[][] island = {
            {2,2,2},
            {2,0,2},
            {2,2,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    // Narrow path
    @Test
    public void testReachableArea_narrowPath() {
        int[][] island = {
            {0,2,1,1},
            {1,2,1,2},
            {1,1,1,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(8, actual);
    }

    // Start in corner
    @Test
    public void testReachableArea_startCorner() {
        int[][] island = {
            {0,1,2},
            {1,1,2},
            {2,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    // Large blocked sections
    @Test
    public void testReachableArea_blockedRegions() {
        int[][] island = {
            {0,1,2,1},
            {1,2,2,1},
            {1,1,1,1},
            {2,2,1,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(10, actual);
    }
}

