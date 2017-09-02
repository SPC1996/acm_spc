package eight.d;

import java.util.Scanner;

public class Main {
    private static int[][][] tb = new int[12][12][2];
    private static int[][][] lr = new int[12][12][2];
    private static int[][][] tlbr = new int[12][12][2];
    private static int[][][] trbl = new int[12][12][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[10][10];
        char[] row;
        for (int i = 0; i < 10; i++) {
            row = scanner.nextLine().toCharArray();
            System.arraycopy(row, 0, board[i], 0, row.length);
        }
        if (check(board))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean check(char[][] board) {
        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 10; j++) {
                if (board[i - 1][j - 1] == 'X') {
                    tb[i][j][0] = tb[i - 1][j][0] + 1;
                    tb[i][j][1] = tb[i - 1][j][1] + 1;
                    lr[i][j][0] = lr[i][j - 1][0] + 1;
                    lr[i][j][1] = lr[i][j - 1][1] + 1;
                    tlbr[i][j][0] = tlbr[i - 1][j - 1][0] + 1;
                    tlbr[i][j][1] = tlbr[i - 1][j - 1][1] + 1;
                    trbl[i][j][0] = trbl[i - 1][j + 1][0] + 1;
                    trbl[i][j][1] = trbl[i - 1][j + 1][1] + 1;
                } else if (board[i - 1][j - 1] == '.') {
                    tb[i][j][1] = tb[i - 1][j][0] + 1;
                    lr[i][j][1] = lr[i][j - 1][0] + 1;
                    tlbr[i][j][1] = tlbr[i - 1][j - 1][0] + 1;
                    trbl[i][j][1] = trbl[i - 1][j + 1][0] + 1;
                }
                if (tb[i][j][0] == 5 || tb[i][j][1] == 5 ||
                        lr[i][j][0] == 5 || lr[i][j][1] == 5 ||
                        tlbr[i][j][0] == 5 || tlbr[i][j][1] == 5 ||
                        trbl[i][j][0] == 5 || trbl[i][j][1] == 5) {
                    return true;
                }
            }
        return false;
    }
}
