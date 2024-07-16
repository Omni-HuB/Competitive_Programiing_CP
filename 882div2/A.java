import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inp = sc.nextInt();
        while (inp-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = rArray(sc, n);
            int[] ar = calDiff(arr);
            Arrays.sort(ar);
            int sum = calSum(ar, n, k);
            System.out.println(sum);
        }
    }

    private static int[] rArray(Scanner sc, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static int[] calDiff(int[] arr) {
        int size = arr.length;
        int[] ar = new int[size - 1];
        for (int i = 1; i < size; i++) {
            ar[i - 1] = Math.abs(arr[i] - arr[i - 1]);
        }
        return ar;
    }

    private static int calSum(int[] ar, int n, int k) {
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += ar[i];
        }
        return sum;
    }
}
