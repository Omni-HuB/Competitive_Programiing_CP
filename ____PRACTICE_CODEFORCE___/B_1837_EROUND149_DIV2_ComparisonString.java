import java.util.Scanner;
import java.io.*;
import java.util.*;


//import java.io.BufferedReader;
// import java.util.StringTokenizer;

public class B_1837_EROUND149_DIV2_ComparisonString {

    static final int MOD = 1000000007;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // Utility methods

    static int add(int a, int b) {
        return (a + b) % MOD;
    }

    static int subtract(int a, int b) {
        return (a - b + MOD) % MOD;
    }

    static int multiply(int a, int b) {
        return (int) (((long) a * b) % MOD);
    }

    static int power(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exponent /= 2;
        }
        return result;
    }

    // BIT MANIPULATION

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    static int countSetBits(long n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    static boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }



    //  MAIN FILE

    public static void main(String[] args) {
        // FastReader in = new FastReader();
        // PrintWriter out = new PrintWriter(System.out);
        //out.flush();
        //out.close();

        List<Integer> lst = new ArrayList<>(300);
        lst.add(0); 
        lst.add(100); 
        lst.add(200); 
        lst.add(1000); 
        lst.add(10000); 
        lst.add(100000); 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int ans = 1, cur = 1;
            
            for (int j = 1; j < n; j++) {
                if (s.charAt(j) != s.charAt(j - 1))
                    cur = 1;
                else
                    cur++;
                
                ans = Math.max(ans, cur);
            }
            
            System.out.println(ans + 1);
        }
        
        sc.close();
    }
}
