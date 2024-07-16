
//import java.io.BufferedReader;
// import java.util.StringTokenizer; 

import java.io.*;
import java.util.*;

public class D_1841_EROUND150_DIV2_PairsOfSegments {

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



    /// MAIN LOGIC

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static List<Pair> readPairs(Scanner sc, int n) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            pairs.add(new Pair(first, second));
        }
        return pairs;
    }

    static List<Pair> generatePairs(List<Pair> s) {
        List<Pair> pairs = new ArrayList<>();
        int n = s.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.max(s.get(i).first, s.get(j).first) <= Math.min(s.get(i).second, s.get(j).second)) {
                    pairs.add(new Pair(Math.min(s.get(i).first, s.get(j).first),
                            Math.max(s.get(i).second, s.get(j).second)));
                }
            }
        }

        return pairs;
    }

    static int countNonOverlappingPairs(List<Pair> pairs) {
        int cnt_pairs = 0;
        pairs.sort(Comparator.comparingInt(a -> a.second));

        int last_pos = -1;

        for (Pair x : pairs) {
            if (x.first > last_pos) {
                cnt_pairs++;
                last_pos = x.second;
            }
        }

        return cnt_pairs;
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        List<Pair> s = readPairs(sc, n);

        List<Pair> pairs = generatePairs(s);
        int cnt_pairs = countNonOverlappingPairs(pairs);

        System.out.println(n - cnt_pairs * 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        for (int i = 0; i < inp; i++) {
            solve(sc);
        }

        sc.close();
    }
}
