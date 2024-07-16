
/// wrong sol

import java.util.Scanner;

public class D{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();

        while (t-- > 0) {
            int n = inp.nextInt();
            int[] ratings = new int[n];

            for (int i = 0; i < n; i++) {
                ratings[i] = inp.nextInt();
            }

            long mxrat = computemxrat(ratings);
            System.out.println(mxrat);
        }
    }

    private static long computemxrat(int[] ratings) {
        long mxrat = 0;
        long crat = 0;

        for (int i = 0; i < ratings.length; i++) {
            crat += ratings[i];
            mxrat = Math.max(mxrat, crat);

            if (crat < 0) {
                crat = 0;
            }
        }

        return mxrat;
    }
}
 

