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
    public void findPersonLocation_personAtTopLeft_returnsCorrectCoordinates() {
        int[][] island = {
            {0, 1, 1},
            {1, 1, 1}
        };

        int[] result = ExplorerSearch.findPersonLocation(island);

        assertArrayEquals(new int[]{0, 0}, result);
    }

    @Test
    public void findPersonLocation_personInMiddle_returnsCorrectCoordinates() {
        int[][] island = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int[] result = ExplorerSearch.findPersonLocation(island);

        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPersonLocation_noPerson_throwsIllegalArgumentException() {
        int[][] island = {
            {1, 1},
            {1, 1}
        };

        ExplorerSearch.findPersonLocation(island);
    }
}