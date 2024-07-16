import java.io.*;
import java.util.*;

// import javafx.util.*;

//import java.io.BufferedReader;
// import java.util.StringTokenizer;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;

//C_1841_EROUND150_DIV2_Random_Numbers

public class C_1117_EROUND60_DIV2_MagicShip {

    static final int MOD = 1000000007;

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static class DSU {
        private int[] p;
        private int n;

        public DSU(int n) {
            this.n = n;
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public int get(int x) {
            return (x == p[x] ? x : (p[x] = get(p[x])));
        }

        public boolean unite(int x, int y) {
            x = get(x);
            y = get(y);
            if (x != y) {
                p[x] = y;
                return true;
            }
            return false;
        }
    }

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

    // MAIN FILE

   static int X, Y;
    static int[] LR = new int[101010];
    static int[] UD = new int[101010];
    static int N;
    static String S;

    static boolean can(long step) {
        long LR2 = LR[N] * (step / N) + LR[(int) (step % N)];
        long UD2 = UD[N] * (step / N) + UD[(int) (step % N)];

        return (Math.abs(X - LR2) + Math.abs(Y - UD2)) <= step;
    }

    public static void main(String[] args) {
        // FastReader in = new FastReader();
        // PrintWriter out = new PrintWriter(System.out);

        // StringBuilder output = new StringBuilder();

        // // Read input
        // int n = in.nextInt();

        // // Solve the problem

        // // Print output
        // out.println("Hello, World!");

        // out.flush();
        // out.close();

        List<Integer> lst = new ArrayList<>(300);
        lst.add(0);
        lst.add(100);
        lst.add(200);
        lst.add(1000);
        lst.add(10000);
        lst.add(100000);
        solve();
    }
    

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        X = sc.nextInt() - x;
        Y = sc.nextInt() - y;
        N = sc.nextInt();
        S = sc.next();

        for (int i = 0; i < N; i++) {
            LR[i + 1] = LR[i];
            UD[i + 1] = UD[i];
            if (S.charAt(i) == 'U') UD[i + 1]++;
            if (S.charAt(i) == 'D') UD[i + 1]--;
            if (S.charAt(i) == 'L') LR[i + 1]--;
            if (S.charAt(i) == 'R') LR[i + 1]++;
        }

        long ret = (1L << 50) - 1;
        if (!can(ret)) {
            System.out.println("-1");
            return;
        }
        for (int i = 49; i >= 0; i--) {
            if (can(ret - (1L << i))) {
                ret -= 1L << i;
            }
        }
        System.out.println(ret);
    }

    
}
