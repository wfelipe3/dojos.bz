import dz.dojo.Point;

import java.util.List;

public class QueenChecker {
    public QueenChecker() {
    }

    boolean verifyQueens(List<Point> points) {
        if (thereIsMoreThanOnePoint(points)) {
            if (points.size() == 2) {
                return areInSameRow(points.get(0), points.get(1)) || areInSameColumn(points.get(0), points.get(1));
            } else if (points.size() == 3) {
                return (areInSameRow(points.get(0), points.get(1))) && (areInSameRow(points.get(0), points.get(2)));
            }
        }
        return true;
    }

    private boolean areInSameRow(Point point1, Point point2) {
        return point1.getX() != point2.getX();
    }

    private boolean areInSameColumn(Point point1, Point point2) {
        return point1.getY() != point2.getY();
    }


    private boolean thereIsMoreThanOnePoint(List<Point> points) {
        return points.size() > 1;
    }



}