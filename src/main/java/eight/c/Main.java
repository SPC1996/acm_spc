package eight.c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        int[] p;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            p = new int[n + 1];
            p[0] = 0;
            for (int j = 1; j <= n; j++) {
                p[j] = scanner.nextInt();
                int k = j - 1;
                while (p[j] - p[k] < j - k)
                    k--;
                System.out.print((j - k) + " ");
            }
            System.out.println();
        }
    }
}
