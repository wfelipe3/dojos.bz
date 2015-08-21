import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PicasYFijas {

    private String referenceValue;

    public PicasYFijas(String referenceValue) {
        this.referenceValue = referenceValue;
    }

    public int[] returnAnswer(String entry) {
        if(entry.length() != 4)
            throw new IllegalArgumentException();

        return new int[]{countPicas(entry),countFijas(entry)};
    }

    private int countPicas(String entry) {

        Predicate<Integer> containsValue = x -> entry.contains(String.valueOf(referenceValue.charAt(x)));
        Predicate<Integer> isNotSameIndex = x -> entry.charAt(x) != referenceValue.charAt(x);

        return (int)IntStream.range(0,4).
                filter(x -> containsValue.and(isNotSameIndex).test(x)).
                count();
    }


    private int countFijas(String entry) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if(isSameInIndex(entry,i))
                count++;
        }
        return count;
    }

    private boolean isSameInIndex(String entry, int index) {
        return entry.charAt(index) == referenceValue.charAt(index);
    }
}