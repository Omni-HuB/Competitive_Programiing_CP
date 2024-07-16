import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<int[]> e = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            e.add(new int[]{u, v});
        }
        checkStarTree(N, e);
    }

    public static void checkStarTree(int N, List<int[]> e) {
        List<List<Integer>> ajl = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ajl.add(new ArrayList<>());
        }

        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            ajl.get(u).add(v);
            ajl.get(v).add(u);
        }

        int inNod = -1;
        for (int node = 1; node <= N; node++) {
            if (ajl.get(node).size() == N - 1) {
                inNod = node;
            } else if (ajl.get(node).size() > 1) {
                System.out.println("NO");
                return;
            }
        }

        if (inNod != -1 && ajl.get(inNod).size() == N - 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
