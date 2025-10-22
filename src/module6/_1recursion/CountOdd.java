package module6._1recursion;

public class CountOdd {
    public static void main(String[] args) {
        int[] test = { 1, 1, 2, 3, 5, 8, 13 };
        int odds = countOdd(test);
        System.out.println(odds);
    }

    public static int countOdd(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    public static int countOddR(int[] values) {
        int count = 0;
        int i = 0;

        return countOddHelper(values, count, i);
        // can also set the line above equal to an integer variable and return that
    }

    public static int countOddHelper(int[] values, int count, int i) {
        if (i >= values.length) {// can also do i == values.length
            return count;
        } else {
            if (values[i] % 2 == 1) {
                count++;
            }
            return countOddHelper(values, count, i + 1);
        }
    }
}
