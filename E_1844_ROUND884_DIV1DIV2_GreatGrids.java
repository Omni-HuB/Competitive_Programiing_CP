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

public class E_1844_ROUND884_DIV1DIV2_GreatGrids  {

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

    public static void main(String[] args) throws IOException {
       // FastReader in = new FastReader();
        //PrintWriter out = new PrintWriter(System.out);
         
        //StringBuilder output = new StringBuilder();

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
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            solve(sc, sb);
        }

        System.out.print(sb.toString());
       
    }

    static class Pair<T1, T2> {
        T1 first;
        T2 second;

        Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }


    static void solve(Scanner sc, StringBuilder sb) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ArrayList<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;

            if (y2 == y1 + 1) {
                adj.get(x2).add(new Pair<>(n + y2, 1));
                adj.get(n + y2).add(new Pair<>(x2, 1));
            } else {
                adj.get(x2).add(new Pair<>(n + y1, 0));
                adj.get(n + y1).add(new Pair<>(x2, 0));
            }
        }

        int[] col = new int[n + m];
        Arrays.fill(col, -1);

        for (int i = 0; i < n + m; i++) {
            if (col[i] == -1) {
                col[i] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int x = queue.poll();

                    for (Pair<Integer, Integer> pair : adj.get(x)) {
                        int y = pair.first;
                        int w = pair.second;

                        if (col[y] == (w ^ col[x] ^ 1)) {
                            sb.append("NO\n");
                            return;
                        }
                        if (col[y] == -1) {
                            col[y] = w ^ col[x];
                            queue.add(y);
                        }
                    }
                }
            }
        }

        sb.append("YES\n");
    }
}





  


