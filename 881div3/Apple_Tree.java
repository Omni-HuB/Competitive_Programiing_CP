import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Apple_Tree {
    static final int maxm = 800006;
    static long l, r, mid;
    static long n, m;
    static boolean[] vis = new boolean[maxm];
    static boolean[] gos = new boolean[maxm];
    static long[] darage = new long[maxm];
    static long ss, mm, po;
    static List<Integer>[] g = new ArrayList[maxm];
    static List<Integer>[] z = new ArrayList[maxm];
    static long[] pedaret = new long[maxm];
    static List<Long> st = new ArrayList<>();
    static List<Long> wtf = new ArrayList<>();
    static List<Long> ajab = new ArrayList<>();
    static long[] rp = new long[maxm];
    static long[][] rw = new long[maxm][maxm];
    static long[] dp = new long[maxm];
    static long[] lft = new long[maxm];
    static long[] rgh = new long[maxm];
    static List<Long> vec = new ArrayList<>();
    static BufferedReader br;

    public static void dfs(long x, long jad) {
        if (g[(int)x].size() == 1 && x != 1)
            darage[(int)x] = 1;
        for (int v : g[(int)x]) {
            if (v != jad) {
                dfs(v, x);
                darage[(int)x] += darage[v];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
                darage[i] = 0;
            }
            for (int i = 1; i < n; i++) {
                String[] lr = br.readLine().split(" ");
                l = Integer.parseInt(lr[0]);
                r = Integer.parseInt(lr[1]);
                g[(int)l].add((int)r);
                g[(int)r].add((int)l);
            }
            dfs(1, -1);
            m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                String[] lr = br.readLine().split(" ");
                l = Integer.parseInt(lr[0]);
                r = Integer.parseInt(lr[1]);
                System.out.println(darage[(int)l] * darage[(int)r]);
            }
        }
    }
}