import java.util.Arrays;
import java.util.Scanner;

class D_1830_ROUND875_DIV2_BossCanCountPairs {
    
    static class Pair implements Comparable<Pair> {
        int first;
        int second;
    
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
         }
     
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            Pair[] a = new Pair[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = new Pair(scanner.nextInt(), 0);
            }
            for (int i = 1; i <= n; i++) {
                a[i].second = scanner.nextInt();
            }
            Arrays.sort(a, 1, n + 1);
            long ans = 0;
            int[] m = new int[n + 1];
            for (int i = 1; i * i <= n * 2; i++) {
                for (int j = 1; j <= n; j++) {
                    long nd = (long) (a[j].first * i) - a[j].second;
                    if (nd >= 1 && nd <= n) {
                        ans += m[(int) nd];
                    }
                    if (a[j].first == i) {
                        m[a[j].second]++;
                    }
                }
                Arrays.fill(m, 1, n + 1, 0);
            }
            System.out.println(ans);
        }
        
    }
    
 
}



