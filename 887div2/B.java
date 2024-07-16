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




public class B{

    static final int MOD = 1000000007;

    
    // static class Pair<K, V> {
    //     private K key;
    //     private V value;

    //     public Pair(K key, V value) {
    //         this.key = key;
    //         this.value = value;
    //     }

    //     public K getKey() {
    //         return key;
    //     }

    //     public V getValue() {
    //         return value;
    //     }
    // }

    
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
        int rslt = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                rslt = multiply(rslt, base);
            }
            base = multiply(base, base);
            exponent /= 2;
        }
        return rslt;
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

    static List<int[]> vprooo = new ArrayList<>();

    static class Pair {
        long first, second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static void pcompfibbo() {
        Pair prevPrev = new Pair(1, 0);
        Pair prev = new Pair(0, 1);
        fib[1] = prevPrev;
        fib[2] = prev;
        for (int i = 3; i < 901; ++i) {
            prevPrev = fib[i - 2];
            prev = fib[i - 1];
            Pair newOne = new Pair(prevPrev.first + prev.first, prevPrev.second + prev.second);
            fib[i] = newOne;
            prevPrev = prev;
            prev = newOne;
        }
    }

    
    static Pair[] fib = new Pair[901];

   
    public static void main(String[] args) throws IOException{
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
        

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        pcompfibbo();

        lst.add(1000); 
        lst.add(10000); 
        lst.add(100000); 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k >= 901) {
                System.out.println(0);
                continue;
            }

            Pair val = fib[k];
            int rslt = 0;
            for (int i = 0; i <= n; ++i) {
                long temp = (n - val.first * i);
                if (temp % val.second == 0) {
                    if (temp / val.second >= i) {
                        ++rslt;
                    }
                }
            }

            System.out.println(rslt);
        }
        lst.add(1000); 
        lst.add(10000); 
        lst.add(100000); 
    }
}

