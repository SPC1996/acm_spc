package six.d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, len;
        int[] num;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            len = n * (n + 1) / 2;
            num = new int[len];
            for (int i = 0; i < len; i++)
                num[i] = scanner.nextInt();
            get(num, n);
        }
    }

    private static void get(int[] a, int n) {
        int[][] table = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                table[i][j] = Math.max(table[i + 1][j], table[i + 1][j + 1]) + a[i * (i + 1) / 2 + j];
        System.out.println(table[0][0]);
        int lasti = 0, lastj = 0;
        while (true) {
            if (lasti == n - 1) {
                System.out.println(a[lasti * (lasti + 1) / 2 + lastj]);
                break;
            } else {
                System.out.print(a[lasti * (lasti + 1) / 2 + lastj] + " ");
                if (table[lasti + 1][lastj] < table[lasti + 1][lastj + 1])
                    lastj = lastj + 1;
                lasti = lasti + 1;
            }
        }
    }
}
