import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        while (inp-- > 0) {
            int n = sc.nextInt();
            List<Integer> sol_arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sol_arr.add(sc.nextInt());
            }
            long[] s = new long[2];
            int idx = 0;
            for (int num : sol_arr) {
                if (num > 0) {
                    s[idx % 2] += num;
                }
                idx++;
            }
            long ans = Math.max(s[0], s[1]);
            if (ans == 0) {
                ans = sol_arr.stream().mapToLong(Integer::intValue).max().orElse(0);
            }
            System.out.println(ans);
        }
    }
}
