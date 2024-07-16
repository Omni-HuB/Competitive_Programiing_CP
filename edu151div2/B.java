import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        while (t-- > 0) {
            int ax = inp.nextInt();
            int ay = inp.nextInt();
            int bx = inp.nextInt();
            int by = inp.nextInt();
            int cx = inp.nextInt();
            int cy = inp.nextInt();
            int ans = calDis(ax, ay, bx, by, cx, cy);
            System.out.println(ans);
        }
    }

    static int calDis(int ax, int ay, int bx, int by, int cx, int cy) {
        int ans = 1;
        int a1 = bx-ax;
        int a2 = cx-ax;
        int b1 = by-ay;
        int b2 = cy-ay;
        if ((bx < ax && cx < ax) || (bx > ax && cx > ax)) {
            ans = ans + Math.min(Math.abs(a1), Math.abs(a2));
        }
        if ((by < ay && cy < ay) || (by > ay && cy > ay)) {
            ans = ans + Math.min(Math.abs(b1), Math.abs(b2));
        }
        return ans;
    }
}







