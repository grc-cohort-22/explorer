import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,0,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testReachableArea_allUnreachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,3,3,3,1},
            {1,1,3,0,2,1},
            {1,1,2,2,2,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_noStartingPosition() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
        assertEquals("No starting location present", exception.getMessage());
    }

    @Test
    public void testReachableArea_windyPath() {
        int[][] island = {
            {0,1,1,1,1,1},
            {3,3,3,3,3,1},
            {1,1,1,1,1,1},
            {1,2,2,2,2,2},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(20, actual);
    }

    @Test
    public void testReachableArea_blockedOffAreas() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,3,1,1,1},
            {1,2,1,2,1,1},
            {3,1,1,1,3,2},
            {1,1,1,0,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(10, actual);
    }

    @Test
    public void testReachableArea_jaggedArrayAllReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1},
            {1,1,1,1,1,1,0,1,1},
            {1,1,1,1,1,1},
            {1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(26, actual);
    }

    @Test
    public void testReachableArea_jaggedArraySomeUnreachable() {
        int[][] island = {
            {1,2,2,1,2,1},
            {1,2,2,1},
            {1,1,1,1,3,1,0,1,1},
            {3,3,1,1,1,1},
            {1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(16, actual);
    }

    @Test
    public void testReachableArea_jaggedArrayAllUnreachable() {
        int[][] island = {
            {2,1,1,1},
            {0},
            {3,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testStartingLocation_centerOfGrid() {
        int[][] map = {
            {1, 2, 3},
            {1, 0, 1},
            {3, 2, 1}
        };
        int[] expected = {1, 1};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }

    @Test
    public void testStartingLocation_bottomRightOfGrid() {
        int[][] map = {
            {1, 2, 3},
            {1, 1, 1},
            {3, 2, 0}
        };
        int[] expected = {2, 2};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }

    @Test
    public void testStartingLocation_jaggedArray() {
        int[][] map = {
            {1, 2},
            {1, 3, 1, 0},
            {3, 2, 1},
            {2, 2, 2, 3, 1}
        };
        int[] expected = {1, 3};
        assertArrayEquals(expected, ExplorerSearch.startingLocation(map));
    }

    @Test
    public void testPossibleMoves_allDirectionsOpen() {
        int[][] map = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(map, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(4, moves.size());
        assertTrue(moveSet.contains("0,1")); // up
        assertTrue(moveSet.contains("2,1")); // down
        assertTrue(moveSet.contains("1,0")); // left
        assertTrue(moveSet.contains("1,2")); // right
    }

    @Test
    public void testPossibleMoves_oneDirectionOpen() {
        int[][] map = {
            {3, 1, 1},
            {0, 2, 1},
            {1, 1, 1}
        };
        int[] location = {1, 0};
        List<int[]> moves = ExplorerSearch.possibleMoves(map, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(1, moves.size());
        assertFalse(moveSet.contains("0,0")); // up
        assertTrue(moveSet.contains("2,0")); // down
        assertFalse(moveSet.contains("1,-1")); // left
        assertFalse(moveSet.contains("1,1")); // right
    }

    @Test
    public void testPossibleMoves_twoDirectionsOpen() {
        int[][] map = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 0, 3}
        };
        int[] location = {2, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(map, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(2, moves.size());
        assertTrue(moveSet.contains("1,1")); // up
        assertFalse(moveSet.contains("3,1")); // down
        assertTrue(moveSet.contains("2,0")); // left
        assertFalse(moveSet.contains("2,2")); // right
    }

    @Test
    public void testPossibleMoves_jaggedArray() {
        int[][] map = {
            {1, 2, 3},
            {2, 1, 1, 0, 1,},
            {1}
        };
        int[] location = {1, 3};
        List<int[]> moves = ExplorerSearch.possibleMoves(map, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(2, moves.size());
        assertFalse(moveSet.contains("0,3")); // up
        assertFalse(moveSet.contains("2,3")); // down
        assertTrue(moveSet.contains("1,2")); // left
        assertTrue(moveSet.contains("1,4")); // right
    }

    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
