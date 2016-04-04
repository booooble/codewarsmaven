import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NumHelperTest {

    @Test
    public void testTribonacci() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, NumHelper.tribonacci(new double[]{1, 1, 1}, 10), 0.0);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, NumHelper.tribonacci(new double[]{0, 0, 1}, 10), 0.0);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, NumHelper.tribonacci(new double[]{0, 1, 1}, 10), 0.0);
        assertArrayEquals(new double[0], NumHelper.tribonacci(null, 10), 0.0);
        assertArrayEquals(new double[0], NumHelper.tribonacci(new double[]{1, 1}, 10), 0.0);
    }

    @Test
    public void testXbonacci() throws Exception {
        assertArrayEquals(new double[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, NumHelper.xbonacci(new double[]{0, 1}, 10), 0.0);
        assertArrayEquals(new double[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, NumHelper.xbonacci(new double[]{1, 1}, 10), 0.0);
        assertArrayEquals(new double[]{0, 0, 0, 0, 1, 1, 2, 4, 8, 16}, NumHelper.xbonacci(new double[]{0, 0, 0, 0, 1}, 10), 0.0);
        assertArrayEquals(new double[]{1, 0, 0, 0, 0, 0, 1, 2, 3, 6}, NumHelper.xbonacci(new double[]{1, 0, 0, 0, 0, 0, 1}, 10), 0.0);
        assertArrayEquals(new double[0], NumHelper.xbonacci(null, 10), 0.0);
        assertArrayEquals(new double[]{1, 1, 2, 3, 5, 8, 13}, NumHelper.xbonacci(new double[]{1, 1}, 7), 0.0);
    }

    @Test
    public void testUniqueArray() throws Exception {
        // Empty array should return an empty array.
        int[] emptyArray = new int[0];
        assertArrayEquals(new int[0], NumHelper.uniqueArray(emptyArray));

        // One value should return that value in array.
        int[] singleValArr = new int[]{-1};
        assertArrayEquals(new int[]{-1}, NumHelper.uniqueArray(singleValArr));

        // Multiple values should return in same order as given.
        int[] multipleValsInOrder = new int[]{-1, 5, 10, -100, 3, 2};
        assertArrayEquals(new int[]{-1, 5, 10, -100, 3, 2}, NumHelper.uniqueArray(multipleValsInOrder));

        // Duplicates should be removed and in the order first seen.
        int[] duplicatesInOrder1 = new int[]{1, 2, 3, 3, 2, 1, 2, 3, 1, 1, 3, 2};
        assertArrayEquals(new int[]{1, 2, 3}, NumHelper.uniqueArray(duplicatesInOrder1));
        int[] duplicatesInOrder2 = new int[]{1, 3, 2, 3, 2, 1, 2, 3, 1, 1, 3, 2};
        assertArrayEquals(new int[]{1, 3, 2}, NumHelper.uniqueArray(duplicatesInOrder2));
        int[] duplicatesInOrder3 = new int[]{3, 2, 3, 3, 2, 1, 2, 3, 1, 1, 3, 2};
        assertArrayEquals(new int[]{3, 2, 1}, NumHelper.uniqueArray(duplicatesInOrder3));

        // Null should return empty array
        assertArrayEquals(new int[0], NumHelper.uniqueArray(null));
    }
}