// import java.util.Scanner;

// public class C_1838_ROUND877_DIV2_No_Prime_Differences{
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int inp = sc.nextInt();
        
//         while (inp-- > 0) {
//             int n = sc.nextInt();
//             int m = sc.nextInt();
            
//             for (int i = n; i > 0; i--) {
//                 if ((i & 1) == 1) {
//                     for (int j = 1; j <= m; j++) {
//                         System.out.print((i - 1) * m + j);
//                         if (j == m) {
//                             System.out.println();
//                         } else {
//                             System.out.print(" ");
//                         }
//                     }
//                 }
//             }
            
//             for (int i = n; i > 0; i--) {
//                 if (i % 2 == 0) {
//                     for (int j = 1; j <= m; j++) {
//                         System.out.print((i - 1) * m + j);
//                         if (j == m) {
//                             System.out.println();
//                         } else {
//                             System.out.print(" ");
//                         }
//                     }
//                 }
//             }
//         }
        
//         sc.close();
//     }
// }


import java.util.Scanner;

public class C_1838_ROUND877_DIV2_No_Prime_Differences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        StringBuilder output = new StringBuilder();

        while (inp-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = n; i > 0; i--) {
                if ((i & 1) == 1) {
                    int startValue = (i - 1) * m + 1;
                    for (int j = 0; j < m; j++) {
                        output.append(startValue + j).append(' ');
                    }
                    output.append('\n');
                }
            }

            for (int i = n; i > 0; i--) {
                if (i % 2 == 0) {
                    int startValue = (i - 1) * m + 1;
                    for (int j = 0; j < m; j++) {
                        output.append(startValue + j).append(' ');
                    }
                    output.append('\n');
                }
            }
        }

        System.out.print(output);
        sc.close();
    }
}
