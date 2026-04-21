import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    @Test
    public void testReachableArea_startLeft() {
        int[][] island = {
                { 0, 1, 1, 3 },
                { 2, 2, 1, 3 },
                { 1, 1, 1, 3 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(7, actual);
    }

    @Test
    public void testReachableArea_allOpen() {
        int[][] island = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual);
    }

    @Test
    public void testReachableArea_longPath() {
        int[][] island = {
                { 0, 1, 1, 1, 1 },
                { 3, 3, 3, 3, 1 },
                { 1, 1, 1, 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(11, actual);
    }

    @Test
    public void testReachableArea_singleCell() {
        int[][] island = {
                { 0 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_onlyStart() {
        int[][] island = {
                { 2, 2, 2 },
                { 2, 0, 2 },
                { 2, 2, 2 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_threeSidesBlocked() {
        int[][] island = {
                { 3, 3, 3 },
                { 3, 0, 1 },
                { 3, 3, 3 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(2, actual);
    }

    @Test
    public void testReachableArea_mixed() {
        int[][] island = {
                { 1, 1, 3, 1, 1 },
                { 1, 2, 3, 1, 0 },
                { 1, 1, 1, 2, 1 },
                { 3, 3, 1, 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
}
