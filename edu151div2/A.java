import java.util.Scanner;

public class A {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            solveTestCase(sc);
        }
        sc.close();
    }
    
    static void solveTestCase(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        
        if (x != 1) {
            printSolution(true, n, 1);
            return;
        }
        
        if (n == 1 || k <= 1) {
            printSolution(false);
            return;
        }
        
        if (n % 2 == 0) {
            printSolution(true, n / 2, 2);
            return;
        }
        
        if (k > 2) {
            int count = (n - 3) / 2 + 1;
            printSolution(true, count, 2);
            System.out.print("3");
            System.out.println();
            return;
        }
        
        printSolution(false);
    }
    
    static void printSolution(boolean isValid, int... numbers) {
        if (isValid) {
            System.out.println("YES");
            System.out.println(numbers.length);
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("NO");
        }
        System.out.println();
    }
}
