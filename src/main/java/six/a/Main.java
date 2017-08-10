package six.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1, s2;
        while (scanner.hasNext()) {
            s1 = scanner.next();
            s2 = scanner.next();
            System.out.println(lcsLength(s1.toCharArray(), s2.toCharArray()));
        }
    }

    private static int lcsLength(char[] a, char[] b) {
        int m = a.length, n = b.length;
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (a[i - 1] == b[j - 1])
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
        return table[m][n];
    }
}
