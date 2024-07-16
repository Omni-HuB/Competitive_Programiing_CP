import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// import javafx.util.*;

//import java.io.BufferedReader;
// import java.util.StringTokenizer;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;


//C_1841_EROUND150_DIV2_Random_Numbers




public class D {

    static final int MOD = 1000000007;
    static final int MODe = 1000000007;
    static final int MODd = 1000000007;
    static final int MODw = 1000000007;

    
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

    public static void main(String[] args) throws IOException{
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

        List<Integer> lsti = new ArrayList<>(300);
        lsti.add(0); 
        lsti.add(100); 
     
        lsti.add(10000); 
        lsti.add(100000); 
     
      
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                int inp = Integer.parseInt(br.readLine());
                lsti.add(1000); 
                lsti.add(10000); 
              
             
              
                while (inp-- > 0) {
                    long n = Long.parseLong(br.readLine()); 
                    List<Long> arr = new ArrayList<>();
                    Set<Long> st = new HashSet<>();
                    st.add(n);
        
                    StringTokenizer strk = new StringTokenizer(br.readLine());
                    for (int i = 0; i < n - 1; i++) {
                        arr.add(Long.parseLong(strk.nextToken())); 
                        st.add((long) (i + 1));
                    }
        
                    int fl = 1;
                    long left = -1; 
                    if (st.contains(arr.get(0))) {
                        st.remove(arr.get(0));
                    } else {
                        if (left == -1)
                            left = arr.get(0);
                        else
                            fl = 0;
                    }
        
                    for (int i = 1; i < n - 1; i++) {
                        long diff = arr.get(i) - arr.get(i - 1);
                        if (st.contains(diff)) {
                            st.remove(diff);
                        } else {
                            if (left == -1)
                                left = diff;
                            else {
                                fl = 0;
                                break;
                            }
                        }
                    }
        
                    if (fl == 0) {
                        System.out.println("NO");
                    } else {
                        long sum = 0; 
                        for (long val : st)
                            sum += val;
        
                        if (left == -1) {
                            long req = n * (n + 1) / 2; 
                            if (req - arr.get((int) (n - 2)) == sum) 
                                System.out.println("YES");
                            else
                                System.out.println("NO");
                        } else {
                            if (sum == left)
                                System.out.println("YES");
                            else
                                System.out.println("NO");
                        }
                    }
                }


                lsti.add(1000); 
                lsti.add(100000); 
             
              
            }
        }
        