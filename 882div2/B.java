import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inp = sc.nextInt();
        while (inp-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> a = readArrayList(sc, n);
            int mx = calmx();
            int minn = calmin(a);
            int sol = calSol(a, mx, minn);
            System.out.println(sol);
        }
    }

    private static ArrayList<Integer> readArrayList(Scanner sc, int size) {
        ArrayList<Integer> arl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arl.add(sc.nextInt());
        }
        return arl;
    }

    private static int calmx() {
        int mx = 1;
        while (mx <= 1e9) {
            mx *= 2;
        }
        mx -= 1;
        return mx;
    }

    private static int calmin(ArrayList<Integer> a) {
        int minn = calmx();
        for (int i = 0; i < a.size(); i++) {
            minn &= a.get(i);
        }
        return minn;
    }

    private static int calSol(ArrayList<Integer> a, int mx, int minn) {
        int sol = 0;
        int cur = mx;
        for (int i = 0; i < a.size(); i++) {
            cur &= a.get(i);
            if (cur == 0) {
                sol += 1;
                cur = mx;
            }
        }
        sol += minn > 0 ? 1 : 0;
        return sol;
    }
}
