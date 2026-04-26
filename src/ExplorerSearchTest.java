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
    public void testGetStarting_findsStartingLocation() {
        int[][] island = {
            {1,1,1,2,1},
            {1,3,1,2,1},
            {1,3,0,1,1},
            {1,2,2,2,1},
            {1,1,1,1,1},
        };

        ExplorerSearch.Location actual = ExplorerSearch.getStarting(island);

        assertEquals(new ExplorerSearch.Location(2, 2), actual);
    }

    @Test
    public void testReachableArea_noStartingLocation() {
        int[][] island = {
            {1,1,1,2,1},
            {1,3,1,2,1},
            {1,3,1,1,1},
            {1,2,2,2,1},
            {1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);

        assertEquals(0, actual);
    }

    @Test
    public void testReachableArea_allLand() {
        int[][] island = {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,0,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);

        assertEquals(25, actual);
    }

    @Test
    public void testReachableArea_startingLocationBlockedIn() {
        int[][] island = {
            {1,1,1,1,1},
            {1,2,2,2,1},
            {1,2,0,3,1},
            {1,2,3,3,1},
            {1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);

        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_reachesOnlyConnectedLand() {
        int[][] island = {
            {0,1,1,2,1},
            {2,2,1,2,1},
            {1,1,1,2,1},
            {1,2,2,2,1},
            {1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);

        assertEquals(17, actual);
    }
}
