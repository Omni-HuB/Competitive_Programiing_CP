import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        while (inp-- > 0) {
            int n = sc.nextInt();
            List<Long> cgs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cgs.add(sc.nextLong());
            }
            long rslt = solve(cgs);
            System.out.println(rslt);
        }
    }

    public static long solve(List<Long> cgs) {
        int n = cgs.size();
        long rslt = cgs.get(n - 1);
        for (int i = 0; i < n - 1; i++) {
            if (cgs.get(i) < 0 && cgs.get(i + 1) > 0) {
                rslt += cgs.get(i);
                cgs.set(i + 1, cgs.get(i + 1) + cgs.get(i));
            }
        }
        return rslt;
    }
}
