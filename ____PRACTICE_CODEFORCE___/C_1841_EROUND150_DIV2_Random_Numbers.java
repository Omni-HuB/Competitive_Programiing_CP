
import java.util.Scanner;
import java.util.*;

public class C_1841_EROUND150_DIV2_Random_Numbers{
    private static final int INF = (int) 2.01e9;
    private static final int MOD = 1_000_000_007;
    private static final List<Integer> p10 = Arrays.asList(1, 10, 100, 1000, 10000);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int inp = sc.nextInt();
        while (inp-- > 0) {
            String s = sc.next();
            int result = calculateMxmValue(s);
            System.out.println(result);
        }
    }

    private static int calculateMxmValue(String s) {
        int len = s.length();
        List<List<Integer>> ll = initializeF();
        ll.get(0).set(0, 0);

        for (int pos = len - 1; pos >= 0; pos--) {
            List<List<Integer>> newF = initializeF();
            int me = s.charAt(pos) - 'A';

            for (int mx = 0; mx < 5; mx++) {
                for (int have = 0; have < 2; have++) {
                    for (int digit = 0; digit < 5; digit++) {
                        int newMx = Math.max(mx, digit);
                        int newHave = have + (digit != me ? 1 : 0);
                        int newValue = ll.get(mx).get(have) + (digit < mx ? -1 : 1) * p10.get(digit);
                        if (newHave <= 1) {
                            newF.get(newMx).set(newHave, Math.max(newF.get(newMx).get(newHave), newValue));
                        }
                    }
                }
            }
            ll = newF;
        }

        int ans = -INF;
        for (int mx = 0; mx < 5; mx++) {
            for (int have = 0; have < 2; have++) {
                ans = Math.max(ans, ll.get(mx).get(have));
            }
        }
        return ans;
    }

    private static List<List<Integer>> initializeF() {
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                row.add(-INF);
            }
            ll.add(row);
        }
        return ll;
    }
}
