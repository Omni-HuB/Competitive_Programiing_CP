import java.util.*;

public class A {
    static int n, m, ans = -1;
    static List<List<Integer>> g;
    static int[] dp;

    static int dfs(int idx) {
        if (idx == n) {
            return 1;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int temp = 0;
        for (int i = 0; i < g.get(idx).size(); i++) {
            temp = Math.max(1 + dfs(g.get(idx).get(i)), temp);
        }
        if (temp != 0)
            return dp[idx] = temp;
        else
            return dp[idx] = -1000000;
    }

    static void testcase() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g.get(from).add(to);
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        ans = dfs(1);
        if (ans > 1)
            System.out.println(ans);
        else
            System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        int TC = 1;
        for (int i = 0; i < TC; i++) {
            testcase();
        }
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class A {
//     static int n, m;
//     static ArrayList<Integer>[] g;
//     static int[] dp;

//     static void dfs() {
//         Arrays.fill(dp, -1);
//         dp[1] = 0;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j < g[i].size(); j++) {
//                 int next = g[i].get(j);
//                 dp[next] = Math.max(dp[next], dp[i] + 1);
//             }
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());

//         g = new ArrayList[n + 1];
//         for (int i = 1; i <= n; i++)
//             g[i] = new ArrayList<>();

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());
//             int from = Integer.parseInt(st.nextToken());
//             int to = Integer.parseInt(st.nextToken());
//             g[from].add(to);
//         }

//         dp = new int[n + 1];
//         dfs();

//         if (dp[n] >= 0)
//             System.out.println(dp[n] + 1);
//         else
//             System.out.println("IMPOSSIBLE");
//     }
// }
