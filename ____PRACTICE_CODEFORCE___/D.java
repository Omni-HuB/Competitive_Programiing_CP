

// import java.util.Scanner;

// public class C {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         int inp = sc.nextInt();

//         while (inp-- > 0) {
//             int n = sc.nextInt();
//             int m = 1;
//             while (n % m == 0) {
//                 m += 1;
//             }
//             for (int i = 0; i < n; i++) {
//                 System.out.print((char) ('a' + i % m));
//             }
//             System.out.println();
//         }
//     }
// }

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        
        while (inp-- > 0) {
            int n = sc.nextInt();
            String pttrn = getPattern(n);
            System.out.println(pttrn);
        }
    }
    
    private static String getPattern(int n) {
        StringBuilder pttrn = new StringBuilder();
        int d = 2;
        while (n % d == 0) {
            d++;
        }
        
        for (int i = 0; i < n; i++) {
            char ch = (char) ('a' + i % d);
            pttrn.append(ch);
        }
        
        return pttrn.toString();
    }
}
