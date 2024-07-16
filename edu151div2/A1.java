import java.util.Scanner;

public class A1{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();
            sol(n, k, x);
        }
    }
        
    public static void sol(long n, long k, long x) {
        if (x != 1) {
            System.out.println("YES");
            System.out.println(n);
            for (int i = 1; i <= n; i++) {
                System.out.print(1 + " ");
            }
            System.out.println();
            return;
        }
        
        if (n == 1 || k <= 1) {
            System.out.println("NO");
            return;
        }
        
        if (n % 2 == 0) {
            System.out.println("YES");
            System.out.println(n / 2);
            for (int i = 1; i <= n / 2; i++) {
                System.out.print(2 + " ");
            }
            System.out.println();
            return;
        }
        
        if (k > 2) {
            System.out.println("YES");
            System.out.println((n - 3) / 2 + 1);
            for (int i = 1; i <= (n - 3) / 2; i++) {
                System.out.print(2 + " ");
            }
            System.out.print(3);
            System.out.println();
            return;
        }
        
        System.out.println("NO");
    }

    
}

