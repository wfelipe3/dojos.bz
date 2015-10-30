package dojos.bz;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by WilliamE on 29/10/2015.
 */
public class RadixTest {

    private final Radix radix = new Radix();

    @Test
    public void givenOneSizeArrayReturnAccumulator() {
        assertArrayEquals(ints(0, 1, 0, 0, 0, 0, 0, 0, 0, 0), radix.count(ints(1), 0));
        assertArrayEquals(ints(0, 0, 0, 1, 0, 0, 0, 0, 0, 0), radix.count(ints(3), 0));
        assertArrayEquals(ints(0, 0, 0, 0, 0, 0, 0, 0, 1, 0), radix.count(ints(8), 0));
    }

    @Test
    public void givenTwoSizeArrayReturnAccumulator() {
        assertArrayEquals(ints(0, 1, 1, 0, 0, 0, 0, 0, 0, 0), radix.count(ints(1, 2), 0));
        assertArrayEquals(ints(0, 0, 0, 1, 0, 0, 0, 0, 1, 0), radix.count(ints(8, 3), 0));
    }

    @Test
    public void givenTwoDigitNumberReturnAccumulator() {
        assertArrayEquals(ints(0, 0, 0, 0, 0, 0, 0, 0, 1, 0), radix.count(ints(18), 0));
        assertArrayEquals(ints(0, 0, 0, 1, 0, 0, 0, 0, 0, 0), radix.count(ints(23), 0));
    }

    @Test
    public void givenTwoDigitNumberReturnAccumulatorSecondIteration() {
        assertArrayEquals(ints(0, 1, 0, 0, 0, 0, 0, 0, 0, 0), radix.count(ints(18), 1));
        assertArrayEquals(ints(0, 0, 1, 0, 0, 0, 0, 0, 0, 0), radix.count(ints(23), 1));
    }

    @Test
    public void givenArrayWithDifferentDigitSizeWhenIsSecondIterationThenReturnAccumulator() {
        assertArrayEquals(ints(1, 1, 0, 0, 0, 0, 0, 0, 0, 0), radix.count(ints(18, 3), 1));
    }

    @Test
    public void givenArrayWithSameDigitValueAccumulateCounter() {
        assertArrayEquals(ints(0, 2, 0, 0, 0, 0, 0, 0, 2, 0), radix.count(ints(18, 28, 11, 1), 0));
    }

    @Test
    public void givenOneSizeArrayReturnAccumulated() {
        assertArrayEquals(ints(0, 1, 1, 1, 1, 1, 1, 1, 1, 1), radix.accum(ints(0, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        assertArrayEquals(ints(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), radix.accum(ints(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    }

    @Test
    public void givenOriginalAndAccumulatedThenReturnPositionedArray() {
        assertArrayEquals(ints(1,12,118,9),radix.reorder(ints(118,1,9,12),ints(0,1,2,2,2,2,2,2,3,4)));
    }
    private int[] ints(int... a) {
        return a;
    }

}
