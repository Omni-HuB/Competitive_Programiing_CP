import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import javafx.util.*;

//import java.io.BufferedReader;
// import java.util.StringTokenizer;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;


//C_1841_EROUND150_DIV2_Random_Numbers




public class C {

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

    
    // static class Pair {
    //     int first;
    //     int second;

    //     Pair(int first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }


    // static class Pair implements Comparable<Pair> {
    //     int first;
    //     int second;

    //     Pair(int first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }

    //     @Override
    //     public int compareTo(Pair other) {
    //         if (this.first != other.first)
    //             return Integer.compare(this.first, other.first);
    //         return Integer.compare(this.second, other.second);
    //     }
    // }

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

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //  MAIN FILE

    public static void main(String[] args) throws IOException {
       FastReader in = new FastReader();
        //PrintWriter out = new PrintWriter(System.out);
         
        StringBuilder output = new StringBuilder();

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
      
        lst.add(10000); 
        lst.add(100000); 

      

 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int inp = Integer.parseInt(br.readLine());
        while (inp-- > 0) {
            
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            
            int[] a = new int[n];
            String[] aValues = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aValues[i]);
            }
            
            int last = n - 1;
            int lll = 3;
            int aw = 0;

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == a[0])
                    count++;
                if (count == k) {
                    last = i;
                    break;
                }
            }
            
            if (count < k) {
                System.out.println("NO");
                continue;
            } else {
                if (a[0] == a[n - 1]) {
                    System.out.println("YES");
                    continue;
                }
            }
            
            count = 0;
            for (int i = n - 1; i > last; i--) {
                if (a[i] == a[n - 1])
                    count++;
            }
            
            if (count >= k)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
        br.close();
    }
}
