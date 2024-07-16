
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class E_1843_ROUND881_DIV3_Tracking_Segments{

   
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        while (inp-- > 0) {
            int result = solve(sc);
            System.out.println(result);
        }
    }

    public static int solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Pair> iv = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            iv.add(new Pair(first - 1, second - 1));
        }

        int q = sc.nextInt();
        List<Integer> op = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            op.add(query - 1);
        }

        int result = -1;
        int lo = -1;
        int hi = q;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            if (f(mid, op, iv, n)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (hi == q) {
            hi = -2;
        }

        result = hi + 1;
        return result;
    }

    public static boolean f(int last, List<Integer> op, List<Pair> iv, int n) {
        int[] acc = new int[n];
        for (int i = 0; i <= last; i++) {
            acc[op.get(i)] = 1;
        }

        for (int i = 1; i < n; i++) {
            acc[i] += acc[i - 1];
        }

        for (Pair p : iv) {
            int l = p.first;
            int r = p.second;
            int len = r - l + 1;
            int sum = acc[r] - (l > 0 ? acc[l - 1] : 0);
            if (sum + sum > len) {
                return true;
            }
        }
        return false;
    }
}

