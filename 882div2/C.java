import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        
        while (inp-- > 0) {
            long nn = sc.nextLong();
            ArrayList<Long> a = new ArrayList<Long>();
            
            for (int i = 0; i < nn + 2; i++) {
                a.add(0L);
            }
            
            for (int i = 1; i <= nn; i++) {
                a.set(i, sc.nextLong());
            }
            
            long ans = 0;
            
            for (int i = 1; i <= nn; i++) {
                ans = Math.max(ans, a.get(i));
            }
            
            for (int i = 1; i <= nn; i++) {
                long res = a.get(i);
                
                for (int j = i + 1; j <= Math.min(nn, i + 256); j++) {
                    res ^= a.get(j);
                    ans = Math.max(ans, res);
                }
            }
            
            System.out.println(ans);
        }
        
        sc.close();
    }
}
