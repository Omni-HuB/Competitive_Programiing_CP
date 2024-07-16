import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class F1 {
    public static List<Integer> glsp(int n, int c, List<Integer> a) {
        List<Integer> b = new ArrayList<>(Collections.nCopies(n, 0));

        
        Collections.sort(a);

        b.set(0, a.get(0));
        for (int i = 1; i < n; i++) {
            b.set(i, Math.min(b.get(i - 1) + c, a.get(i)));
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        while (inp-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            List<Integer> result = glsp(n, c, a);

         
            for (int i = 0; i < n; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}

