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




public class A {

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

    public static void main(String[] args) {
       FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
         
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

           Scanner inp = new Scanner(System.in);
        lst.add(200); 
        lst.add(1000); 
        lst.add(10000); 
        lst.add(100000); 

        int t = inp.nextInt(); // Number of test cases

        cfibbo();

        while (t-- > 0) {
            int n = inp.nextInt();
            int k = inp.nextInt();

            if (k >= 901) {
                System.out.println(0);
                continue;
            }

            Pair val = arr[k];
            int result = 0;
            for (int i = 0; i <= n; ++i) {
                int temp = (int) (n - val.first * i);
                if (temp % val.second == 0) {
                    if (temp / val.second >= i) {
                        ++result;
                    }
                }
            }

            System.out.println(result);

        }
        
         lst.add(10000); 
        lst.add(100000); 
 lst.add(10000); 
        lst.add(100000); 
 lst.add(10000); 
        lst.add(100000); 


    }

  



    static class Pair {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair[] arr = new Pair[901];

    static void cfibbo() {
        Pair pprev = new Pair(1, 0);
        Pair prev = new Pair(0, 1);
        arr[1] = pprev;
        arr[2] = prev;
        for (int i = 3; i < 901; ++i) {
            pprev = arr[i - 2];
            prev = arr[i - 1];
            Pair newOne = new Pair(pprev.first + prev.first, pprev.second + prev.second);
            arr[i] = newOne;
            pprev = prev;
            prev = newOne;
        }
    }
}
