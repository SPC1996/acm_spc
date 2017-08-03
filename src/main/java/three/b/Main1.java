package three.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    private static int[] board = new int[10];
    private static int NUM;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NUM = scanner.nextInt();
        while (NUM != 0) {
            Arrays.fill(board, Integer.MAX_VALUE);
            queen();
            NUM = scanner.nextInt();
        }
    }

    public static void queen() {
        int i = 0, j = 0, n = 0;
        while (i < NUM) {
            while (j < NUM) {
                if (canSet(i, j)) {
                    board[i] = j;
                    j = 0;
                    break;
                } else {
                    j++;
                }
            }
            if (board[i] == Integer.MAX_VALUE) {
                if (i == 0)
                    break;
                else {
                    i--;
                    j = board[i] + 1;
                    board[i] = Integer.MAX_VALUE;
                    continue;
                }
            }
            if (i == NUM - 1) {
                n++;
                j = board[i] + 1;
                board[i] = Integer.MAX_VALUE;
                continue;
            }
            i++;
        }
        System.out.println(n);
    }

    private static boolean canSet(int x, int y) {
        for (int i = 0; i < NUM; i++) {
            if (board[i] == y || Math.abs(x - i) == Math.abs(board[i] - y))
                return false;
        }
        return true;
    }
}
