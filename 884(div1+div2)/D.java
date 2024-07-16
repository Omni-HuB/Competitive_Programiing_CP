import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        while (inp-- > 0) {
            int n = sc.nextInt();
            Set<Integer> ftrs = getFactors(n);
            int[][] h = new int[n][26];
            int[] val = new int[n];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int ftr : ftrs) {
                    if (i + ftr >= n)
                        break;
                    h[i + ftr][val[i]] = 1;
                }
                if (i + 1 < n) {
                    for (int j = 0; j < 26; j++) {
                        if (h[i + 1][j] == 0) {
                            val[i + 1] = j;
                            break;
                        }
                    }
                }
            }
            for (int i : val) {
                char c = (char) (i + 97);
                sb.append(c);
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }

    public static Set<Integer> getFactors(int n) {
        Set<Integer> ftrs = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ftrs.add(i);
                ftrs.add(n / i);
            }
        }
        return ftrs;
    }

    
}
