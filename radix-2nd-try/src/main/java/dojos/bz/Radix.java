package dojos.bz;

public class Radix {
    public Radix() {
    }

    int[] count(int[] ints, int iteration) {
        int[] result = new int[10];
        for (int digit : ints) {
            result[getDigit(digit, iteration)]++;
        }
        return result;
    }

    static Integer getDigit(int digit, int index) {
        StringBuilder builder = new StringBuilder();
        builder.append(digit);
        char[] chars = builder.reverse().toString().toCharArray();
        char c;
        if (index <= chars.length - 1)
            c = chars[index];
        else
            c = '0';
        String newDigit = String.valueOf(c);
        return Integer.valueOf(newDigit);
    }

    public int[] accum(int[] ints) {
        int[] result = new int[10];
        result[0]=ints[0];
        for (int i = 1; i < ints.length; i++) {
            result[i]=result[i-1]+ints[i];

        }

        return result;
    }

    public int[] reorder(int[] ints, int[] ints1) {
        return new int[0];
    }
}