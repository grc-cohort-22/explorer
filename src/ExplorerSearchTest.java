import static org.junit.Assert.*;
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
    public void testReachableArea_allUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,3,3,3},
            {3,1,2,3,0,3},
            {1,1,1,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_allReachable() {
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
    public void testReachableArea_rightEdgeWithOpenLeft() {
        int[][] island = {
            {1,1,1,1,1,0}
            
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    @Test
    public void testReachableArea_topLeftCornerWithOneOpen() {
        int[][] island = {
            {0,2},
            {2,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_blockedLeftByWall() {
        int[][] island = {
            {1,1,1,1,1,0}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    @Test
    public void testReachableArea_blockedBelowByWall() {
        int[][] island = {
            {1,0,1},
            {1,2,1},
            
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual);
    }

    @Test
    public void testReachableArea_blockedRightByWall() {
        int[][] island = {
            {1,0,2},
            {1,1,1},
            
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual);
    }

    @Test
    public void testReachableArea_blockedAboveByWall() {
        int[][] island = {
            {1,2,1},
            {1,0,1},
            
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual);
    }

    @Test
    public void testReachableArea_oneOpen_twoWalls_oneEdge() {
        int[][] island = {
            {2,2,2},
            {1,0,1},
            {2,2,2},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }
}
