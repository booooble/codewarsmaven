import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumHelper {

    /*
    Returns double[] of n numbers of the tribonacci sequence.
    Example: [1.0, 1.0, 1.0], n = 10 --> [1.0, 1.0, 1.0, 3.0, 5.0, 9.0, 17.0, 31.0, 57.0, 105.0]
    */
    public static double[] tribonacci(double[] s, int n) {
        double[] result = null;
        int count = 0;
        try {
            if (s.length < 3 || s == null || n < 3) {
                return new double[0];
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | NullPointerException e) {
            System.out.println(e);
            return new double[0];
        }
        if (s.length >= 3) {
            int addedElementsCount = n - s.length;
            result = Arrays.copyOf(s, n);
            while (count < addedElementsCount) {
                int inputIndex = s.length + count;
                result[inputIndex] = result[inputIndex - 1] + result[inputIndex - 2] + result[inputIndex - 3];
                count++;
            }
        }
        return result;
    }

    /*
    Xbonacci function takes a signature of X elements and returns the first n elements of the sequence where
    each next element is the sum of the last X elements.
    Examples:   [1,1,1,1], n = 10 --> [1,1,1,1,4,7,13,25,49,94]
                [0,0,0,0,1], n = 10 --> [0,0,0,0,1,1,2,4,8,16]
                [1,0,0,0,0,0,1], n = 10 --> [1,0,0,0,0,0,1,1,2,4]
     */
    public static double[] xbonacci(double[] signature, int n) {
        double[] result = null;
        int count = 0;
        try {
            if (signature.length == 0 || signature == null || n < signature.length) {
                return new double[0];
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e);
            return new double[0];
        }
        if (signature.length >= 2) {
            result = Arrays.copyOf(signature, n);
            int inpArrayLength = signature.length;
            int addedElementsCount = n - inpArrayLength;
            while (count < addedElementsCount) {
                int inputIndex = inpArrayLength + count;
                double nextElement = 0.0;
                for (int i = 1; i <= inpArrayLength; i++) {
                    nextElement += result[inputIndex - i];
                }
                result[inputIndex] = nextElement;
                count++;
            }
        }
        return result;
    }

    /*
    Method takes an array of integers and returns the array with duplicates removed
     */
    public static int[] uniqueArray(int[] integers) {
        List<Integer> list = new ArrayList<>();
        try {
            if (integers.length > 0) {
                list.add(integers[0]);
                for (Integer x : integers) {
                    if (!list.contains(x)) {
                        list.add(x);
                    }
                }
            }
            return list.stream().mapToInt(i -> i).toArray();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e);
            return new int[0];
        }
    }
}