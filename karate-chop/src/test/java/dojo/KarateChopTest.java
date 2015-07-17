package dojo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by WilliamE on 16/07/2015.
 */
public class KarateChopTest {

    private final KarateChop karateChop = new KarateChop();

    @Test
    public void givenEmptyArray_thenReturnMinusOne() {
        assertKarateChop(-1, 1, new Integer[0]);
    }

    @Test
    public void givenNumberNotInArray_thenReturnMinusOne() {
        assertKarateChop(-1, 1, new Integer[]{2});
    }

    @Test
    public void givenNumberInArray_thenReturnTheIndex() {
        assertKarateChop(0, 2, new Integer[]{2});
    }
    
    @Test
    public void givenNumberInArray_whenArraySizeIsTwo() {
        assertKarateChop(1, 5, new Integer[]{2,5});
    }

    @Test
    public void givenNumberInArray_whenArraySizeIsThree() {
        Integer[] integers = {2, 4, 6};
        assertKarateChop(1, 4, integers);
        assertKarateChop(0, 2, integers);
        assertKarateChop(2, 6, integers);
    }

    @Test
    public void givenNumberInArray_whenArraySizeIsEven() {
        Integer[] integers = {-1, 2, 4, 6, 7, 8};
        assertKarateChop(4, 7, integers);
        assertKarateChop(-1, 10, integers);
        assertKarateChop(5, 8, integers);
    }

    @Test
    public void givenNumberInArray_whenArraySizeIsOdd() {
        Integer[] integers = { 2, 4, 6, 7, 8};
        assertKarateChop(3, 7, integers);
    }



    private void assertKarateChop(int expected, Integer query, Integer[] integers) {
        Assert.assertEquals(Integer.valueOf(expected), karateChop.binarySearch(integers, query));
    }
}
