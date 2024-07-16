import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        for (int i = 0; i < inp; i++) {
            int tt = sc.nextInt();
            int sol = 0;
            for (int j = 0; j < tt; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a > b) {
                    sol++;
                }
            }
            System.out.println(sol);
        }
    }
}
