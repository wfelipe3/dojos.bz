import dz.dojo.Point;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by WilliamE on 30/07/2015.
 */
public class EightQueensTest {

    private final QueenChecker queenChecker = new QueenChecker();

    @Test
    public void givenOneQueen_mustReturnTrue() {
        List<Point> points = points(point(0, 0));
        isValid(points);
    }

    @Test
    public void givenTwoAlignedInSameRowsQueens_mustReturnFalse() {
        List<Point> points = points(point(0, 1), point(0, 2));
        isNotValid(points);
    }

    private void isNotValid(List<Point> points) {
        assertFalse(queenChecker.verifyQueens(points));
    }

    @Test
    public void givenTwoValidQueens_mustReturnTrue() {
        isValid(points(point(0, 0), point(1, 2)));
    }

    @Test
    public void givenThreeQueens_WhenTwoOfThemAreInTheSameRow_ThenReturnFalse() {
        isNotValid(points(point(0, 0), point(1, 2), point(0, 1)));
    }

    @Test
    public void testGivenTwoQueensInTheSameColumn_ThenReturnFalse() throws Exception {
        isNotValid(points(point(0,1),point(2,1)));
    }

    private void isValid(List<Point> points) {
        assertTrue(queenChecker.verifyQueens(points));
    }

    private Point point(int x, int y) {
        return new Point(x, y);
    }

    private List<Point> points(Point... points) {
        return Arrays.asList(points);
    }
}
