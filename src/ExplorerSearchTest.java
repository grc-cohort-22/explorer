import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class ExplorerSearchTest {

    // =========================
    // reachableArea tests
    // =========================

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
    public void testReachableArea_onlyStartingLocation() {
        int[][] island = {
            {0}
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {0,1},
            {1,1}
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }

    // =========================
    // findPersonLocation tests
    // =========================

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

    // =========================
    // possibleMoves tests
    // =========================

    @Test
    public void possibleMoves_fromTopLeft_returnsDownAndRight() {
        int[][] island = {
            {0, 1},
            {1, 1}
        };

        List<int[]> moves = ExplorerSearch.possibleMoves(island, new int[]{0, 0});

        assertEquals(2, moves.size());
        assertArrayEquals(new int[]{1, 0}, moves.get(0));
        assertArrayEquals(new int[]{0, 1}, moves.get(1));
    }

    @Test
    public void possibleMoves_blockedByWaterAndMountain_returnsNoMoves() {
        int[][] island = {
            {2, 2, 2},
            {2, 0, 3},
            {2, 3, 2}
        };

        List<int[]> moves = ExplorerSearch.possibleMoves(island, new int[]{1, 1});

        assertEquals(0, moves.size());
    }

    @Test
    public void possibleMoves_fromCenter_returnsOnlyValidMoves() {
        int[][] island = {
            {1, 2, 1},
            {1, 0, 3},
            {1, 1, 1}
        };

        List<int[]> moves = ExplorerSearch.possibleMoves(island, new int[]{1, 1});

        assertEquals(2, moves.size());
        assertArrayEquals(new int[]{2, 1}, moves.get(0)); // down
        assertArrayEquals(new int[]{1, 0}, moves.get(1)); // left
    }
}