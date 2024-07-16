import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        while (inp-- > 0) {
            String[] board = new String[3];
            for (int i = 0; i < 3; i++) {
                board[i] = sc.next();
            }
            char winner = fWinner(board);
            if (winner == '.') {
                System.out.println("DRAW");
            } else {
                System.out.println(winner);
            }
        }
    }

    private static char fWinner(String[] board) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)) {
                return board[i].charAt(0);
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)) {
                return board[0].charAt(i);
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
            return board[0].charAt(0);
        }
        if (board[2].charAt(0) == board[1].charAt(1) && board[2].charAt(0) == board[0].charAt(2)) {
            return board[2].charAt(0);
        }

        return '.';
    }
}
