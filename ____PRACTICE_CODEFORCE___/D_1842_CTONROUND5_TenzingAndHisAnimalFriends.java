import java.io.*;
import java.util.*;

//import java.io.BufferedReader;
// import java.util.StringTokenizer;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;

//C_1841_EROUND150_DIV2_Random_Numbers

public class D_1842_CTONROUND5_TenzingAndHisAnimalFriends {

    static final int MOD = 1000000007;


    static class Pair<K, V> {
        private final K key;
        private final V value;

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

    /// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // MAIN FILE

class DSU {
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


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        final long inf = (long) 1e18;
        long[][] g = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }

        DSU d = new DSU(n);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            --x; --y;
            d.unite(x, y);
            g[x][y] = z;
            g[y][x] = z;
        }
        if (d.get(0) != d.get(n - 1)) {
            System.out.println("inf");
            return;
        }
        List<Pair<String, Long>> res = new ArrayList<>();
        long ans = 0;
        while (true) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append("0");
            }
            s.setCharAt(0, '1');
            List<Integer> que = new ArrayList<>();
            que.add(0);
            for (int b = 0; b < que.size(); b++) {
                for (int to = 0; to < n; to++) {
                    if (s.charAt(to) == '0' && g[que.get(b)][to] == 0) {
                        que.add(to);
                        s.setCharAt(to, '1');
                    }
                }
            }
            if (s.charAt(n - 1) == '1') {
                break;
            }
            long T = inf;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    for (int j = 0; j < n; j++) {
                        if (s.charAt(j) == '0') {
                            T = Math.min(T, g[i][j]);
                        }
                    }
                }
            }
            ans += T;
            res.add(new Pair<>(s.toString(), T));
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    for (int j = 0; j < n; j++) {
                        if (s.charAt(j) == '0') {
                            g[i][j] -= T;
                            g[j][i] -= T;
                        }
                    }
                }
            }
        }
        System.out.println(ans + " " + res.size());
        for (Pair<String, Long> p : res) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
    }
}
