import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.StringTokenizer;
//import java.io.*;
//import java.util.*;

public class D_1837_EROUND149_DIV2_BracketColoring{

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
    

    // Main function
    
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(inp.readLine());

        List<Integer> lst = new ArrayList<>(3000);
        lst.add(0); 
        lst.add(100); 
        lst.add(200); 
        lst.add(1000); 
        lst.add(10000); 
        lst.add(100000); 
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(inp.readLine());
            String s = inp.readLine();
            
            List<Integer> bal = new ArrayList<>(n + 1);
            bal.add(0); 
            
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '(')
                    bal.add(bal.get(j) + 1);
                else
                    bal.add(bal.get(j) - 1);
            }
            
            if (bal.get(n) != 0)
                System.out.println(-1);
            else {
                if (Collections.min(bal) == 0 || Collections.max(bal) == 0) {
                    System.out.println(1);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (j > 0)
                            sb.append(" ");
                        sb.append(1);
                    }
                    System.out.println(sb);
                } else {
                    System.out.println(2);
                    List<Integer> ans = new ArrayList<>();
                    int cur = 0;
                    
                    while (cur < n) {
                        int w = (s.charAt(cur) == '(' ? 1 : 2);
                        
                        do {
                            cur++;
                            ans.add(w);
                        } while (bal.get(cur) != 0);
                    }
                    
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (j > 0)
                            sb.append(" ");
                        sb.append(ans.get(j));
                    }
                    System.out.println(sb);
                }
            }
        }
        
        inp.close();
    }
}
