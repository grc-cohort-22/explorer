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
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual);
    }

    @Test
    public void testReachableArea_multiplePaths() {
        int[][] island = {
            {1,3,1,1},
            {1,3,1,3},
            {1,1,1,3},
            {2,2,0,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(10, actual);
    }
    
    @Test
    public void testReachableArea_tunnel() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,3,1,3,1},
            {1,1,3,1,3,1},
            {2,2,3,1,3,1},
            {2,2,3,0,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(17, actual);
    }
}
