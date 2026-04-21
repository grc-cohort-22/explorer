import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {

    @Test
    public void testSingleCell() {
        int[][] island = {{0}};
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testSingleRow() {
        int[][] island = {{1, 1, 0, 1, 1}};
        assertEquals(5, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testSingleColumn() {
        int[][] island = {
            {1},
            {1},
            {0},
            {1},
            {1},
        };
        assertEquals(5, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testExplorerOnEdge() {
        int[][] island = {
            {1, 0, 1},
            {1, 1, 1},
        };
        assertEquals(6, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testFullyOpen() {
        int[][] island = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };
        assertEquals(9, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testSurroundedByObstacles() {
        int[][] island = {
            {1, 2, 1},
            {3, 0, 2},
            {1, 3, 1},
        };
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testIslandDividedByWater() {
        int[][] island = {
            {0, 1, 2, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 2, 1, 1},
        };
        assertEquals(10, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testIslandDividedByMountains() {
        int[][] island = {
            {0, 1, 3, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 1, 3, 1, 1},
        };
        assertEquals(10, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testIslandDividedByMountainAndWater() {
        int[][] island = {
            {0, 1, 2, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 1, 2, 1, 1},
        };
        assertEquals(10, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1, 1, 1, 3, 1, 1},
            {3, 2, 3, 1, 3, 1},
            {1, 1, 1, 1, 3, 3},
            {3, 1, 2, 1, 0, 1},
            {1, 1, 1, 2, 1, 1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
    
    @Test
    public void testNoExplorerThrowsException() {
        int[][] island = {
            {1, 1, 1},
            {1, 1, 1},
        };
        assertThrows(IllegalArgumentException.class, () -> ExplorerSearch.reachableArea(island));
    }    

    @Test
    public void testInvalidTilesThrowsException() {
        int[][] island = {
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
        };
        assertThrows(IllegalArgumentException.class, () -> ExplorerSearch.reachableArea(island));
    }  
   
    @Test
    public void testTwoZigzagRivers() {
        int[][] island = {
            {0, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1},
        };
        assertEquals(40, ExplorerSearch.reachableArea(island));
    }
}