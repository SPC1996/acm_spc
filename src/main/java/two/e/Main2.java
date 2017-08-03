package two.e;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] output = new int[t];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] str = new int[n];
            int[] sub = new int[m];
            for (int j = 0; j < n; j++) {
                str[j] = scanner.nextInt();
            }
            for (int j = 0; j < m; j++) {
                sub[j] = scanner.nextInt();
            }
            output[i] = kmp(str, sub);
        }
        for (int j : output)
            System.out.println(j);
    }

    public static int kmp(int[] str, int[] sub) {
        int[] next = next(sub);
        int k = -1;
        for (int i = 0; i < str.length; i++) {
            while (k > -1 && sub[k + 1] != str[i])
                k = next[k];
            if (sub[k + 1] == str[i])
                k = k + 1;
            if (k == sub.length - 1)
                return i - k + 1;
        }
        return -1;
    }

    public static int[] next(int[] sub) {
        int[] next = new int[sub.length];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < sub.length; i++) {
            while (k > -1 && sub[k + 1] != sub[i])
                k = next[k];
            if (sub[k + 1] == sub[i])
                k = k + 1;
            next[i] = k;
        }
        return next;
    }

}
