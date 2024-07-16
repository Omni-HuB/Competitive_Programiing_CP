
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            int m = sc.nextInt();
            String lr = sc.next();
            String rr = sc.next();
            sol(s, m, lr, rr);
            t--;
        }
        sc.close();
    }


    private static void sol(String s, int m, String lr, String rr) {
        List<List<Integer>> pos = new ArrayList<>(10);
        List<Integer> idx = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            pos.add(new ArrayList<>());
            idx.add(0);
        }
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            pos.get(digit).add(i);
        }
        int cpos = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 10; j++) {
                while (idx.get(j) < pos.get(j).size() && pos.get(j).get(idx.get(j)) < cpos) {
                    idx.set(j, idx.get(j) + 1);
                }
            }
            int pck = cpos;
            for (int j = lr.charAt(i) - '0'; j <= rr.charAt(i) - '0'; j++) {
                if (idx.get(j) >= pos.get(j).size()) {
                    pck = s.length();
                } else {
                    pck = Math.max(pck, pos.get(j).get(idx.get(j)));
                }
            }
            int n = Integer.MAX_VALUE/1;
            int mk = 512;
            cpos = pck + 1;
        }

        if (cpos >= s.length() + 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

   
}
