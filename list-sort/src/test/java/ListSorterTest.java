import org.junit.Assert;
import org.junit.Test;
import sort.Sorter;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by WilliamE on 01/10/2015.
 */
public class ListSorterTest {

    private final Sorter sorter = new Sorter();

    @Test
    public void givenEmptyListReturnEmptyList() {
        sortAndAssert(Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void givenOneElementListThenReturnSameList() {
        sortAndAssert(asList(1), asList(1));
        sortAndAssert(asList(20), asList(20));
    }

    @Test
    public void givenAListWithTwoElementsThenReturnTheListButSorted() {
        sortAndAssert(asList(1896, 78), asList(78, 1896));
        sortAndAssert(asList(10, 20), asList(10, 20));
        sortAndAssert(asList(98, 98), asList(98, 98));
    }

    @Test
    public void givenListWithThreeElementsReturnSorted() {
        sortAndAssert(asList(1896, 78,3), asList(3, 78, 1896));
        sortAndAssert(asList(1896,3, 34), asList(3, 34, 1896));
        sortAndAssert(asList(3, 1896, 78), asList(3, 78, 1896));
        sortAndAssert(asList(3, 78, 1896), asList(3, 78, 1896));
        sortAndAssert(asList(78 ,1896,3), asList(3, 78, 1896));
    }


    private void sortAndAssert(List<Integer> actual, List<Integer> expected) {
        assertList(sorter.sort(actual), expected);
    }

    private void assertList(List<Integer> listToOrder, List<Integer> orderedList) {
        Assert.assertArrayEquals(orderedList.toArray(), listToOrder.toArray());
    }
}
