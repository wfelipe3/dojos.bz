package dojo;

import java.util.Arrays;

public class KarateChop {
    public KarateChop() {
    }

    Integer binarySearch(Integer[] integers, Integer query) {
        Integer position = -1;
        if (integers.length == 0) {
            position = -1;
        } else {
            int middlePosition = getMiddlePosition(integers);
            Integer[] leftPart = Arrays.copyOfRange(integers, 0, middlePosition);

            Integer[] rightPart = Arrays.copyOfRange(integers, middlePosition + 1, integers.length);
            Integer middleValue = integers[middlePosition];
            if (middleValue == query) {
                position = middlePosition;
            } else if (middleValue > query && middlePosition > 0) {
                if (query == integers[middlePosition - 1]) {
                    position = middlePosition - 1;
                }
            } else {
                for (int i = middlePosition + 1; i < integers.length; i++) {
                    if (position == -1 && i < integers.length) {
                        if (query == integers[i]) {
                            position = i;
                        }
                    }
                }
            }
        }
        return position;
    }

    private int getMiddlePosition(Integer[] integers) {
        return integers.length / 2;
    }
}