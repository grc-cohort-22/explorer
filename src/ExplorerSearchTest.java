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

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testStartingLocation_centerOfGrid() {
        char[][] map = {
            {1, 2, 3},
            {1, 0, 1},
            {3, 2, 1}
        };
        int[] expected = {1, 1};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }

    @Test
    public void testStartingLocation_bottomRightOfGrid() {
        char[][] map = {
            {1, 2, 3},
            {1, 1, 1},
            {3, 2, 0}
        };
        int[] expected = {2, 2};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }

    @Test
    public void testStartingLocation_jaggedArray() {
        char[][] map = {
            {1, 2},
            {1, 3, 1, 0},
            {3, 2, 1},
            {2, 2, 2, 3, 1}
        };
        int[] expected = {1, 3};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }
}
