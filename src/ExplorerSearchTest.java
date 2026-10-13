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

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testOnlyStart() {
        int[][] island = { { 0 } };

        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testAllLand() {
        int[][] island = {
                { 0, 1 },
                { 1, 1 }
        };

        assertEquals(4, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testBlockedStart() {
        int[][] island = {
                { 1, 2, 1 },
                { 3, 0, 3 },
                { 1, 2, 1 }
        };

        assertEquals(1, ExplorerSearch.reachableArea(island));
    }
}
