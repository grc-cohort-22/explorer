import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testReachableAreaAll() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,0,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }
        @Test
    public void testReachableAreaNone() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,0,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,2,3,2,3},
            {3,3,3,2,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }
        @Test
    public void testReachableAreaLeftTopCornerStart() {
        int[][] island = {
            {0,1,1,3,1,1},
            {3,2,1,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(18, actual);
    }
        @Test
    public void testReachableAreaRightTopCornerStart() {
        int[][] island = {
            {1,1,1,3,1,0},
            {3,2,3,1,3,1},
            {1,1,1,1,3,1},
            {3,1,2,1,1,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(19, actual);
    }
        @Test
    public void testReachableAreaBottomLeftCornerStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {0,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
        @Test
    public void testReachableAreaBottomRightCornerStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
        @Test
    public void testReachableAreaNoStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };
        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
    }

}
