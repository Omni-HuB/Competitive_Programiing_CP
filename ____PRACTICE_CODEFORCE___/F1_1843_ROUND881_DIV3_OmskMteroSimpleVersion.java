import java.io.*;
import java.util.*;
 
public class F1_1843_ROUND881_DIV3_OmskMteroSimpleVersion {
 
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
 
    /// Main Functions----------------------------------------------------------------
 
    static class Info {
        int mn_suf;
        int mx_suf;
        int mn_ans;
        int mx_ans;
    }
 
    // MAIN METHODS----------------------------------------------------------------
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
 
        List<Integer> lst = new ArrayList<>(300);
        lst.add(0);
        lst.add(100);
        lst.add(200);
        lst.add(1000);
        lst.add(10000);
        lst.add(100000);
 
        int t = Integer.parseInt(in.nextLine());
 
        StringBuilder output = new StringBuilder();
 
        for (int testCase = 0; testCase < t; testCase++) {
            solve(in, output);
        }
 
        System.out.println(output.toString());
    }
 
    private static void solve(FastReader in, StringBuilder output) {
        int n = Integer.parseInt(in.nextLine());
 
        Info start = new Info();
        start.mx_suf = start.mx_ans = 1;
 
        List<Info> st = new ArrayList<>();
        st.add(start);
 
        for (int i = 0; i < n; i++) {
            String[] com = in.nextLine().split(" ");
 
            if (com[0].equals("+")) {
                int v = Integer.parseInt(com[1]) - 1;
                int x = Integer.parseInt(com[2]);
 
                Info pref = st.get(v);
                Info cur = new Info();
 
                cur.mn_suf = Math.min(0, pref.mn_suf + x);
                cur.mx_suf = Math.max(0, pref.mx_suf + x);
                cur.mn_ans = Math.min(pref.mn_ans, cur.mn_suf);
                cur.mx_ans = Math.max(pref.mx_ans, cur.mx_suf);
 
                st.add(cur);
            } else {
                int v = Integer.parseInt(com[2]) - 1;
                int x = Integer.parseInt(com[3]);
 
                checkValidity(st, v, x, output);
            }
        }
    }
 
    private static void checkValidity(List<Info> st, int v, int x, StringBuilder output) {
        Info info = st.get(v);
 
        if (info.mn_ans <= x && x <= info.mx_ans) {
            output.append("Yes").append("\n");
        } else {
            output.append("No").append("\n");
        }
    }
}