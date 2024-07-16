import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        while (inp-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>(n);
            a.add(2);
            for (int i = 1; i < n; i++) {
                a.add(0);
            }
            a.set(n - 1, 3);
            a.set(n / 2, 1);
            int counter = 4;

            for (int i = 1; i < n - 1; i++) {
                if (i == n / 2) continue;
                a.set(i, counter++);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
